
/**
 *
 * @author vita_
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import com.MyOrder.MyOrder;
import com.SuperClass.SuperClass;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "product")

public class CertainPage extends SuperClass implements Serializable {

    private String username;                               //储存用于导航栏显示的用户名称
    private String productName;                            //储存用于展示的具体的产品名称 

    CertainPage() {

        setUsernameFromSuperClass();
        productName = super.getProductToRender();
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
