package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "处方模板")
public class Template extends Model{
    @Column(name = "模板ID")
    private int templateID;
    @Column(name = "模板名称")
    private String tempname;
    @Column(name = "创立医生ID")
    private int createdoctorID;
    @Column(name = "使用范围")
    private int userange;
    @Column(name = "删除标记")
    private int deletemark;

    public Template() {
    }

    public Template(int templateID, String tempname, int createdoctorID, int userange, int deletemark) {
        this.templateID = templateID;
        this.tempname = tempname;
        this.createdoctorID = createdoctorID;
        this.userange = userange;
        this.deletemark = deletemark;
    }

    public int getTemplateID() {
        return templateID;
    }

    public void setTemplateID(int templateID) {
        this.templateID = templateID;
    }

    public String getTempname() {
        return tempname;
    }

    public void setTempname(String tempname) {
        this.tempname = tempname;
    }

    public int getCreatedoctorID() {
        return createdoctorID;
    }

    public void setCreatedoctorID(int createdoctorID) {
        this.createdoctorID = createdoctorID;
    }

    public int getUserange() {
        return userange;
    }

    public void setUserange(int userange) {
        this.userange = userange;
    }

    public int getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(int deletemark) {
        this.deletemark = deletemark;
    }
}
