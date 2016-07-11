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
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import com.entities.Autoparts;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;

@SessionScoped
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
    private List<Autoparts> tem;

    public MyOrder() {
        setUsernameFromSuperClass();
        listOfAutoparts = new ArrayList<>();
        tem = new ArrayList<>();
    }

    public void setEverything() {                             //由于是sessionscoped 每次跳转到这个页面时 都要刷新
        setUserResultList();
        setNumbers();
        setElementsOfThisPage();
    }

    public void setUserResultList() {                        //还未实现

    }

    public void setNumbers() {                                   //设置页内跳转的数字信息
        super.setTotalNumberOfPages((listOfAutoparts.size() / 10) + 1);
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

//    public List<Autoparts> getElementsOfThisPage() {
//        List<Autoparts> tem=new ArrayList<Autoparts>();
//        int pageNumber = super.getCurrentPageNumber();
//        for (int i = 1; i < 11; i++) {
//            tem.add(listOfAutoparts[(pageNumber - 1) * 10 - 1 + i]);   //[i - 1] = listOfAutoparts[(pageNumber - 1) * 10 - 1 + i];
//        }
//        return tem;
//    }
    public void setElementsOfThisPage() {                                //获得每个页面展示的实例
        tem.clear();
        int pageNumber = super.getCurrentPageNumber();
        for (int i = 1; i < 11; i++) {
            tem.add(listOfAutoparts.get((pageNumber - 1) * 10 - 1 + i));//[(pageNumber - 1) * 10 - 1 + i]);   //[i - 1] = listOfAutoparts[(pageNumber - 1) * 10 - 1 + i];
        }
    }

    public void resetPageInfo() {                                        //离开页面前清空页内跳转信息
        super.setTotalNumberOfPages(0);
        super.setNumberOfInstancesInListOfCurrentPage(null);
        super.setCurrentPageNumber(0);
        listOfAutoparts.clear();
    }

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
