package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "处方表")
public class prescribe extends Model{
    @Column(name = "处方ID")
    private int prescribeID;
    @Column(name = "挂号ID")
    private int presRegID;
    @Column(name = "开立医生ID")
    private int presdoctorID;
    @Column(name = "处方名称")
    private String prescribename;
    @Column(name = "病历ID")
    private int presmedhisID;
    @Column(name = "处方状态")
    private int presstate;

    public prescribe() {
    }

    public prescribe(int prescribeID, int presRegID, int presdoctorID, String prescribename, int presmedhisID, int presstate) {
        this.prescribeID = prescribeID;
        this.presRegID = presRegID;
        this.presdoctorID = presdoctorID;
        this.prescribename = prescribename;
        this.presmedhisID = presmedhisID;
        this.presstate = presstate;
    }

    public int getPrescribeID() {
        return prescribeID;
    }

    public void setPrescribeID(int prescribeID) {
        this.prescribeID = prescribeID;
    }

    public int getPresRegID() {
        return presRegID;
    }

    public void setPresRegID(int presRegID) {
        this.presRegID = presRegID;
    }

    public int getPresdoctorID() {
        return presdoctorID;
    }

    public void setPresdoctorID(int presdoctorID) {
        this.presdoctorID = presdoctorID;
    }

    public String getPrescribename() {
        return prescribename;
    }

    public void setPrescribename(String prescribename) {
        this.prescribename = prescribename;
    }

    public int getPresmedhisID() {
        return presmedhisID;
    }

    public void setPresmedhisID(int presmedhisID) {
        this.presmedhisID = presmedhisID;
    }

    public int getPresstate() {
        return presstate;
    }

    public void setPresstate(int presstate) {
        this.presstate = presstate;
    }
}
