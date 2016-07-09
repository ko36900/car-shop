package com.huang.log;

/**
 *
 * @author vita_
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "home")

public class HomePage {

    private String searchText;
    public static String menuSearchTem;                   //通过菜单搜索时访问的数据

    public String toSearch() {
        //将searchText传入对数据库进行搜索 符合的元组取出展示页面
        //此函数返回搜索之后的页面的xhtml

        Cleaner();  //清空搜索框
        return null;
    }

    public void Cleaner() {
        setSearchText("");
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public static String getMenuSearchTem() {
        return menuSearchTem;
    }

    public static void setMenuSearchTem(String menuSearchTem) {
        HomePage.menuSearchTem = menuSearchTem;
    }

}
