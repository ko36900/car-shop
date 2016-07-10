
/**
 *
 * @author vita_
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import com.SuperClass.SuperClass;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "product")

public class CertainPage extends SuperClass implements Serializable {

    private String username;                               //储存用于导航栏显示的用户名称
    private int productID;                            //储存用于展示的具体的产品名称 
    private int productQuantity;
    
//    public String addProductsToOrder(int productQuantity, int productID,String username) {
//                                                 //返回boolean 成功或者失败 
//        return "";   //刷新产品页
//    }
//    public XX getProductInfo(int productID){}     //返回产品实例
    
    
    CertainPage() {

        setUsernameFromSuperClass();
        productID = super.getProductToRender();
    }

    public void setUsernameFromSuperClass() {
        setUsername(super.getUsernamePrint());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

}
