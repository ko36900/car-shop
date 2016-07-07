/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.LoginController.LoginController;
import com.SearchPage.SearchPage;
import com.MyOrder.MyOrder;

@SessionScoped
@ManagedBean(name = "product")
/**
 *
 * @author vita_
 */
public class CertainPage implements Serializable {

    private String username;
    private String productName;
    private boolean isFromMyOrder;
    private boolean isFromSearchPage;

    CertainPage() {
        setIsFromMyOrder(MyOrder.isFromMyOrder);
        setIsFromSearchPage(SearchPage.isFromSearchPage);

        username = LoginController.usernamePrint;
        if (isFromMyOrder == true) {
            productName = MyOrder.productToRender;
        } else {
            productName = SearchPage.productToRender;
        }
        
        setIsFromMyOrder(false);
        setIsFromSearchPage(false);        
        
    }

    public boolean isIsFromMyOrder() {
        return isFromMyOrder;
    }

    public void setIsFromMyOrder(boolean isFromMyOrder) {
        this.isFromMyOrder = isFromMyOrder;
    }

    public boolean isIsFromSearchPage() {
        return isFromSearchPage;
    }

    public void setIsFromSearchPage(boolean isFromSearchPage) {
        this.isFromSearchPage = isFromSearchPage;
    }

}
