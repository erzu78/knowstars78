package com.jk.pojo;

public class Staff {

    private Integer sid;
    private String staffname;//登录名
    private String staffpassword;//登录密码
    private Integer role;//员工角色 1.会员2.管理员
    private String staffimg;//员工头像
    private String staffinfo;//员工格言

    public String getStaffimg() {
        return staffimg;
    }

    public void setStaffimg(String staffimg) {
        this.staffimg = staffimg;
    }

    public String getStaffinfo() {
        return staffinfo;
    }

    public void setStaffinfo(String staffinfo) {
        this.staffinfo = staffinfo;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffpassword() {
        return staffpassword;
    }

    public void setStaffpassword(String staffpassword) {
        this.staffpassword = staffpassword;
    }
}
