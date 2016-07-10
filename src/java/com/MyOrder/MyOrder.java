package com.MyOrder;

/**
 *
 * @author vita_
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import com.SuperClass.SuperClass;
import javax.faces.bean.RequestScoped;

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

    public MyOrder() {
        setUsernameFromSuperClass();
    }

//    public String deleteProductsFromOrder(int productQuantity,int productToRenderTem,String username){   SessionBean的函数返回boolean 显示是否删除成功 触发前端提示
//        return"";   //刷新Order页 
//    }
    
    
    public void setUsernameFromSuperClass() {
        setUsername(super.getUsernamePrint());
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
