
/**
 *
 * @author vita_
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import com.LoginController.LoginController;
import com.SearchPage.SearchPage;
import com.MyOrder.MyOrder;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "product")

public class CertainPage implements Serializable {

    private String username;                               //储存用于导航栏显示的用户名称
    private String productName;                            //储存用于展示的具体的产品名称 

    CertainPage() {

        username = LoginController.usernamePrint;
        if (MyOrder.productToRender != null) {
            productName = MyOrder.productToRender;
            MyOrder.productToRender = null;
        } else {
            productName = SearchPage.productToRender;
            SearchPage.productToRender = null;
        }
    }
}
