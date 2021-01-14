package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "科室")
public class Department extends Model{
    @Column(name = "科室ID")
    private int depID;
    @Column(name = "科室编码")
    private String depcode;
    @Column(name = "科室名称")
    private String depname;
    @Column(name = "科室分类")
    private int deptypeID;
    @Column(name = "删除标记")
    private int depdeleteID;

    public Department() {
    }

    public Department(int depID, String depcode, String depname, int deptypeID, int depdeleteID) {
        this.depID = depID;
        this.depcode = depcode;
        this.depname = depname;
        this.deptypeID = deptypeID;
        this.depdeleteID = depdeleteID;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public int getDeptypeID() {
        return deptypeID;
    }

    public void setDeptypeID(int deptypeID) {
        this.deptypeID = deptypeID;
    }

    public int getDepdeleteID() {
        return depdeleteID;
    }

    public void setDepdeleteID(int depdeleteID) {
        this.depdeleteID = depdeleteID;
    }
}
