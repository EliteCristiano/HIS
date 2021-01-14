package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "用户")
public class user extends Model {
    @Column(name = "用户ID")
    private int id;
    @Column(name = "登录名")
    private String userName;
    @Column(name = "密码")
    private String password;
    @Column(name = "真实姓名")
    private String realname;
    @Column(name = "用户类型")
    private String type;
    @Column(name = "职称ID")
    private String jobID;
    @Column(name = "是否参与排班")
    private String ornot;
    @Column(name = "科室ID")
    private int departmentID;
    @Column(name = "挂号级别ID")
    private int rankID;
    @Column(name = "删除标记")
    private int deleteID;


    public user(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public user() {
    }

    public user(int id, String userName, String password, String realname, String type, String jobID, String ornot, int departmentID, int rankID, int deleteID) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.realname = realname;
        this.type = type;
        this.jobID = jobID;
        this.ornot = ornot;
        this.departmentID = departmentID;
        this.rankID = rankID;
        this.deleteID = deleteID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getOrnot() {
        return ornot;
    }

    public void setOrnot(String ornot) {
        this.ornot = ornot;
    }

//    public String getDepartmentID() {
//        return departmentID;
//    }
//
//    public void setDepartmentID(String departmentID) {
//        this.departmentID = departmentID;
//    }
//
//    public String getRankID() {
//        return rankID;
//    }
//
//    public void setRankID(String rankID) {
//        this.rankID = rankID;
//    }
//
//    public String getDeleteID() {
//        return deleteID;
//    }
//
//    public void setDeleteID(String deleteID) {
//        this.deleteID = deleteID;
//    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public int getDeleteID() {
        return deleteID;
    }

    public void setDeleteID(int deleteID) {
        this.deleteID = deleteID;
    }
}