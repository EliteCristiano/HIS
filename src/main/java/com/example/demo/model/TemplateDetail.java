package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "处方模板明细")
public class TemplateDetail extends Model{
    @Column(name = "模板明细ID")
    private int templateDetailID;
    @Column(name = "成药模板ID")
    private int templateid;
    @Column(name = "药品ID")
    private int medicineoftemID;
    @Column(name = "用法")
    private String detailusage;
    @Column(name = "用量")
    private String detaildosage;
    @Column(name = "频次")
    private String detailfrequency;
    @Column(name = "数量")
    private int detailnumber;

    public TemplateDetail() {
    }

    public TemplateDetail(int templateDetailID, int templateid, int medicineoftemID, String detailusage, String detaildosage, String detailfrequency, int detailnumber) {
        this.templateDetailID = templateDetailID;
        this.templateid = templateid;
        this.medicineoftemID = medicineoftemID;
        this.detailusage = detailusage;
        this.detaildosage = detaildosage;
        this.detailfrequency = detailfrequency;
        this.detailnumber = detailnumber;
    }

    public int getTemplateDetailID() {
        return templateDetailID;
    }

    public void setTemplateDetailID(int templateDetailID) {
        this.templateDetailID = templateDetailID;
    }

    public int getTemplateid() {
        return templateid;
    }

    public void setTemplateid(int templateid) {
        this.templateid = templateid;
    }

    public int getMedicineoftemID() {
        return medicineoftemID;
    }

    public void setMedicineoftemID(int medicineoftemID) {
        this.medicineoftemID = medicineoftemID;
    }

    public String getDetailusage() {
        return detailusage;
    }

    public void setDetailusage(String detailusage) {
        this.detailusage = detailusage;
    }

    public String getDetaildosage() {
        return detaildosage;
    }

    public void setDetaildosage(String detaildosage) {
        this.detaildosage = detaildosage;
    }

    public String getDetailfrequency() {
        return detailfrequency;
    }

    public void setDetailfrequency(String detailfrequency) {
        this.detailfrequency = detailfrequency;
    }

    public int getDetailnumber() {
        return detailnumber;
    }

    public void setDetailnumber(int detailnumber) {
        this.detailnumber = detailnumber;
    }
}
