package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "患者历次挂号信息")
public class RegInformation extends Model{
    @Column(name = "挂号ID")
    private int regID;
    @Column(name = "病历号")
    private int medHisID;
    @Column(name = "姓名")
    private String name;
    @Column(name = "性别ID")
    private int sexID;
    @Column(name = "出生日期")
    private String datedate;
    @Column(name = "年龄")
    private int age;
    @Column(name = "家庭住址")
    private String address;
    @Column(name = "本次看诊日期")
    private String currdate;
    @Column(name = "午别")
    private String noon;
    @Column(name = "挂号科室ID")
    private int departmentid;
    @Column(name = "挂号医生ID")
    private int doctorid;
    @Column(name = "挂号级别ID")
    private int rankid;
    @Column(name = "结算类别ID")
    private int settletypeid;
    @Column(name = "病历本要否")
    private int ornot;
    @Column(name = "挂号时间")
    private String regtime;
    @Column(name = "挂号收费员ID")
    private int clerkID;
    @Column(name = "身份证号")
    private int idcard;
    @Column(name = "诊断状态")
    private int diagnosestate;

    public RegInformation() {
    }

    public RegInformation(int regID, int medHisID, String name, int sexID, String datedate, int age, String address, String currdate, String noon, int departmentid, int doctorid, int rankid, int settletypeid, int ornot, String regtime, int clerkID, int idcard, int diagnosestate) {
        this.regID = regID;
        this.medHisID = medHisID;
        this.name = name;
        this.sexID = sexID;
        this.datedate = datedate;
        this.age = age;
        this.address = address;
        this.currdate = currdate;
        this.noon = noon;
        this.departmentid = departmentid;
        this.doctorid = doctorid;
        this.rankid = rankid;
        this.settletypeid = settletypeid;
        this.ornot = ornot;
        this.regtime = regtime;
        this.clerkID = clerkID;
        this.idcard = idcard;
        this.diagnosestate = diagnosestate;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public int getMedHisID() {
        return medHisID;
    }

    public void setMedHisID(int medHisID) {
        this.medHisID = medHisID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSexID() {
        return sexID;
    }

    public void setSexID(int sexID) {
        this.sexID = sexID;
    }

    public String getDatedate() {
        return datedate;
    }

    public void setDatedate(String datedate) {
        this.datedate = datedate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrdate() {
        return currdate;
    }

    public void setCurrdate(String currdate) {
        this.currdate = currdate;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public int getRankid() {
        return rankid;
    }

    public void setRankid(int rankid) {
        this.rankid = rankid;
    }

    public int getSettletypeid() {
        return settletypeid;
    }

    public void setSettletypeid(int settletypeid) {
        this.settletypeid = settletypeid;
    }

    public int getOrnot() {
        return ornot;
    }

    public void setOrnot(int ornot) {
        this.ornot = ornot;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public int getClerkID() {
        return clerkID;
    }

    public void setClerkID(int clerkID) {
        this.clerkID = clerkID;
    }

    public int getIdcard() {
        return idcard;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    public int getDiagnosestate() {
        return diagnosestate;
    }

    public void setDiagnosestate(int diagnosestate) {
        this.diagnosestate = diagnosestate;
    }
}
