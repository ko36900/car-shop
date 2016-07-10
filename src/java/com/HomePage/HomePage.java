package com.HomePage;

/**
 *
 * @author vita_
 */
import com.SuperClass.SuperClass;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "home")

public class HomePage extends SuperClass {

    private String username;
    private String searchTextTem;
    private String menuSearchTem;                   //通过菜单搜索时访问的数据

    public HomePage() {
        setUsernameFromSuperClass();
    }

//    public String toSearch() {                        应该是无用的 可删除
//        //将searchText传入对数据库进行搜索 符合的元组取出展示页面
//        //此函数返回搜索之后的页面的xhtml
//
//        Cleaner();  //清空搜索框
//        return null;
//    }
//
//    public void Cleaner() {
//        setSearchTextTem(null);
//    }
    
    public void setUsernameFromSuperClass() {
        setUsername(super.getUsernamePrint());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSearchTextTem() {
        return searchTextTem;
    }

    public void setSearchTextTem(String searchTextTem) {
        this.searchTextTem = searchTextTem;
        super.setSearchText(searchTextTem);
    }

    public String getMenuSearchTem() {
        return menuSearchTem;
    }

    public void setMenuSearchTem(String menuSearchTem) {
        this.menuSearchTem = menuSearchTem;
        super.setMenuSearch(menuSearchTem);
    }

}
