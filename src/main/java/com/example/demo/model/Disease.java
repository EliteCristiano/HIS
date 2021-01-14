package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name ="疾病表")
public class Disease extends Model{
    @Column(name = "疾病ID")
    private int diseaseID;
    @Column(name = "疾病助记编码")
    private String diseasecode;
    @Column(name = "疾病名称")
    private String diseasename;
    @Column(name = "疾病所属分类")
    private int diseasekind;
    @Column(name = "删除标记")
    private int diseasedeletemark;

    public Disease() {
    }

    public Disease(int diseaseID, String diseasecode, String diseasename, int diseasekind, int diseasedeletemark) {
        this.diseaseID = diseaseID;
        this.diseasecode = diseasecode;
        this.diseasename = diseasename;
        this.diseasekind = diseasekind;
        this.diseasedeletemark = diseasedeletemark;
    }

    public int getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    public String getDiseasecode() {
        return diseasecode;
    }

    public void setDiseasecode(String diseasecode) {
        this.diseasecode = diseasecode;
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }

    public int getDiseasekind() {
        return diseasekind;
    }

    public void setDiseasekind(int diseasekind) {
        this.diseasekind = diseasekind;
    }

    public int getDiseasedeletemark() {
        return diseasedeletemark;
    }

    public void setDiseasedeletemark(int diseasedeletemark) {
        this.diseasedeletemark = diseasedeletemark;
    }
}
