package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "诊断评估表")
public class Assess extends Model{
    @Column(name = "诊断ID")
    private int assessID;
    @Column(name = "挂号ID")
    private int assessRegID;
    @Column(name = "疾病ID")
    private int assessdiseaseID;
    @Column(name = "诊断类型")
    private int assesstype;
    @Column(name = "发病日期")
    private String diseasedate;
    @Column(name = "诊断种类")
    private int assesskind;
    @Column(name = "病历号")
    private int assessmedID;

    public Assess() {
    }

    public Assess(int assessID, int assessRegID, int assessdiseaseID, int assesstype, String diseasedate, int assesskind, int assessmedID) {
        this.assessID = assessID;
        this.assessRegID = assessRegID;
        this.assessdiseaseID = assessdiseaseID;
        this.assesstype = assesstype;
        this.diseasedate = diseasedate;
        this.assesskind = assesskind;
        this.assessmedID = assessmedID;
    }

    public int getAssessID() {
        return assessID;
    }

    public void setAssessID(int assessID) {
        this.assessID = assessID;
    }

    public int getAssessRegID() {
        return assessRegID;
    }

    public void setAssessRegID(int assessRegID) {
        this.assessRegID = assessRegID;
    }

    public int getAssessdiseaseID() {
        return assessdiseaseID;
    }

    public void setAssessdiseaseID(int assessdiseaseID) {
        this.assessdiseaseID = assessdiseaseID;
    }

    public int getAssesstype() {
        return assesstype;
    }

    public void setAssesstype(int assesstype) {
        this.assesstype = assesstype;
    }

    public String getDiseasedate() {
        return diseasedate;
    }

    public void setDiseasedate(String diseasedate) {
        this.diseasedate = diseasedate;
    }

    public int getAssesskind() {
        return assesskind;
    }

    public void setAssesskind(int assesskind) {
        this.assesskind = assesskind;
    }

    public int getAssessmedID() {
        return assessmedID;
    }

    public void setAssessmedID(int assessmedID) {
        this.assessmedID = assessmedID;
    }
}
