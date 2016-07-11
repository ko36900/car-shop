package com.SearchPage;

/**
 *
 * @author vita_
 */
import com.SuperClass.SuperClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import sun.util.logging.PlatformLogger;
import com.SessionBean.*;
import com.entities.Autoparts;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name = "search")

public class SearchPage extends SuperClass implements Serializable {

    private String username;
    private String menuSearchTem;
    private String searchTextTem;
    private int productToRenderTem;
    private List<Autoparts> listOfAutoparts;
    private List<Autoparts> tem;
    @EJB
    SearchLocal sl;

    public SearchPage() {

//        username = LoginController.getUsernamePrint();
        listOfAutoparts = new ArrayList<>();
        tem = new ArrayList<>();
        setUsernameFromSuperClass();
//
//        somethings = new ArrayList<>();                       //模板代码 可以更改使用
        //        SomethingOfferer=SomthingOfferer.getSomethingOfferer;
    }

    public void setEverything() {                             //由于是sessionscoped 每次跳转到这个页面时 都要刷新
        menuSearchTem = super.getMenuSearch();
        searchTextTem = super.getSearchText();
        setSearchResultList();
        setNumbers();
        setElementsOfThisPage();
    }

    public void setForGoToAnotherPage() {                  //去往前后页需要调用的函数  刷新tem中的实例 F
        setElementsOfThisPage();
    }

    public void setElementsOfThisPage() {
        tem.clear();
        int pageNumber = super.getCurrentPageNumber();
        for (int i = 1; i < 11; i++) {
            tem.add(listOfAutoparts.get((pageNumber - 1) * 10 - 1 + i));    //[(pageNumber - 1) * 10 - 1 + i]);   //[i - 1] = listOfAutoparts[(pageNumber - 1) * 10 - 1 + i];
        }
    }

    public void setNumbers() {                          //设置此搜索结果所对应的页码的数字信息
        super.setTotalNumberOfPages((listOfAutoparts.size() / 10) + 1);                   //25实际应该为xxx.size()
        super.numberOfInstancesInListOfCurrentPage = new int[super.getTotalNumberOfPages() + 1];
        for (int i = 0; i < super.getTotalNumberOfPages(); i++) {
            numberOfInstancesInListOfCurrentPage[i] = 10;
        }
        numberOfInstancesInListOfCurrentPage[super.getTotalNumberOfPages()] = (listOfAutoparts.size() - super.getTotalNumberOfPages() * 10);
        super.setCurrentPageNumber(1);
    }

    public void resetPageInfo() {                         //前往其它的html前调用 将页面信息与List清零
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

    public void setSearchTextAgain() {                       //再次进行文字搜索时 重新获得List 并且对应地刷新数字信息和tem中的实例
        try {
            if (searchTextTem != "") {
                listOfAutoparts.clear();
                setListOfAutoparts(sl.SearchResult(searchTextTem));
                super.setSearchText("");
                //              super.setMenuSearch("");
                resetPageInfo();
                setNumbers();
                setElementsOfThisPage();
            }
        } catch (Exception exc) {
            logger.log(Level.SEVERE, "Error when loading something", exc);
        }
    }

    public void setSearchResultList() {                      //初次获取时
        try {
            if (menuSearchTem != "") {
                listOfAutoparts.clear();
                setListOfAutoparts(sl.SearchResult(menuSearchTem));
                super.setSearchText("");
                super.setMenuSearch("");
            } else {
                listOfAutoparts.clear();
                setListOfAutoparts(sl.SearchResult(searchTextTem));
                super.setSearchText("");
                super.setMenuSearch("");
            }
        } catch (Exception exc) {
            logger.log(Level.SEVERE, "Error when loading something", exc);
        }
    }

    public void setUsernameFromSuperClass() {
        setUsername(super.getUsernamePrint());
    }

//     private List<Something> somethings;
//     private SomethingOfferer SomethingOfferer; 
//    public void loadSomething(List<Something>) {
//
//        Logger.info("Loading Something");
//
//        something.clear();
//
//        try {
//
//            somethings = SomethingOfferer.getsomething();
//        } catch (Exception exc) {
//
//            logger.log(Level.SEVERE, "Error when loading something", exc);
//
//            System.out.println(exc);                          //应更改输出方式
//        }
//    }
    public String getMenuSearchTem() {
        return menuSearchTem;
    }

    public void setMenuSearchTem(String menuSearchTem) {
        this.menuSearchTem = menuSearchTem;
    }

    public String getSearchTextTem() {
        return searchTextTem;
    }

    public void setSearchTextTem(String searchTextTem) {
        this.searchTextTem = searchTextTem;
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

    public List<Autoparts> getListOfAutoparts() {
        return listOfAutoparts;
    }

    public void setListOfAutoparts(List<Autoparts> listOfAutoparts) {
        this.listOfAutoparts = listOfAutoparts;
    }

}
