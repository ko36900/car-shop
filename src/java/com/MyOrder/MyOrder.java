package com.MyOrder;

/**
 *
 * @author vita_
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import com.SuperClass.SuperClass;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import com.entities.Autoparts;
import java.util.ArrayList;

@RequestScoped
@ManagedBean(name = "order")
/**
 *
 * @author vita_
 */
public class MyOrder extends SuperClass implements Serializable {

    private String username;
    private int productToRenderTem;
    private int productQuantity;
    private List<Autoparts> listOfAutoparts;

    public MyOrder() {
        setUsernameFromSuperClass();
    }

    public void setNumbers() {
        super.setTotalNumberOfPages((listOfAutoparts.size() / 10) + 1);                   //25实际应该为xxx.size()
        super.numberOfInstancesInListOfCurrentPage = new int[super.getTotalNumberOfPages() + 1];
        for (int i = 0; i < super.getTotalNumberOfPages(); i++) {
            numberOfInstancesInListOfCurrentPage[i] = 10;
        }
        numberOfInstancesInListOfCurrentPage[super.getTotalNumberOfPages()] = (listOfAutoparts.size() - super.getTotalNumberOfPages() * 10);
        super.setCurrentPageNumber(1);
    }

//    public String deleteProductsFromOrder(int productQuantity,int productToRenderTem,String username){   SessionBean的函数返回boolean 显示是否删除成功 触发前端提示
//        return"";   //刷新Order页 
//    }
    //   public List<配件> getProductList(username){}             
    public void setUsernameFromSuperClass() {
        setUsername(super.getUsernamePrint());
    }

//    public List<Autoparts> getElementsOfThisPage() {      可以用
//        List<Autoparts> tem = new ArrayList<>();
//        int pageNumber = super.getCurrentPageNumber();
//        for (int i = 1; i < 11; i++) {
//            tem[i - 1] = listOfAutoparts[(pageNumber - 1) * 10 - 1 + i];
//        }
//        return tem;
//    }

    public String plusCurrentPageNumber() {
        if (super.getCurrentPageNumber() == super.getTotalNumberOfPages()) {
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "无法翻到下一页"));
            return "";

        } else {
            super.setCurrentPageNumber(super.getCurrentPageNumber() + 1);
            return "";
        }
    }

    public String minusCurrentPageNumber() {
        if (super.getCurrentPageNumber() == 1) {
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "无法翻到上一页"));
            return "";
        } else {
            super.setCurrentPageNumber(super.getCurrentPageNumber() - 1);
            return "";
        }
    }

    public int getProductToRenderTem() {
        return productToRenderTem;
    }

    public void setProductToRenderTem(int productToRenderTem) {
        this.productToRenderTem = productToRenderTem;
        super.setProductToRender(productToRenderTem);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

}
