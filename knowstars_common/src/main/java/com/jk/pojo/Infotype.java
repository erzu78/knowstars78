package com.jk.pojo;

import java.io.Serializable;

public class Infotype implements Serializable{
    private Integer tid;

    private String tname;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }


    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }
}