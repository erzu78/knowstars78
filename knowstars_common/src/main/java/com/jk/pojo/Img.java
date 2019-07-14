package com.jk.pojo;

import java.io.Serializable;

public class Img implements Serializable{

    private Integer id;

    private String url;

    private String tabsname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getTabsname() {
        return tabsname;
    }

    public void setTabsname(String tabsname) {
        this.tabsname = tabsname;
    }
}