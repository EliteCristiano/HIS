package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "处方明细")
public class PrescribeDetail extends Model{
    @Column(name = "处方明细ID")
    private int prescribedetailID;
    @Column(name = "成药处方ID")
    private int prescribeofID;
    @Column(name = "药品ID")
    private int medicineID;
    @Column(name = "用法")
    private String usage;
    @Column(name = "用量")
    private String dosage;
    @Column(name = "频次")
    private String medfrequency;
    @Column(name = "数量")
    private int medicinenumber;
    @Column(name = "明细状态")
    private int detailstate;

    public PrescribeDetail() {
    }

    public PrescribeDetail(int prescribedetailID, int prescribeofID, int medicineID, String usage, String dosage, String medfrequency, int medicinenumber, int detailstate) {
        this.prescribedetailID = prescribedetailID;
        this.prescribeofID = prescribeofID;
        this.medicineID = medicineID;
        this.usage = usage;
        this.dosage = dosage;
        this.medfrequency = medfrequency;
        this.medicinenumber = medicinenumber;
        this.detailstate = detailstate;
    }

    public int getPrescribedetailID() {
        return prescribedetailID;
    }

    public void setPrescribedetailID(int prescribedetailID) {
        this.prescribedetailID = prescribedetailID;
    }

    public int getPrescribeofID() {
        return prescribeofID;
    }

    public void setPrescribeofID(int prescribeofID) {
        this.prescribeofID = prescribeofID;
    }

    public int getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(int medicineID) {
        this.medicineID = medicineID;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMedfrequency() {
        return medfrequency;
    }

    public void setMedfrequency(String medfrequency) {
        this.medfrequency = medfrequency;
    }

    public int getMedicinenumber() {
        return medicinenumber;
    }

    public void setMedicinenumber(int medicinenumber) {
        this.medicinenumber = medicinenumber;
    }

    public int getDetailstate() {
        return detailstate;
    }

    public void setDetailstate(int detailstate) {
        this.detailstate = detailstate;
    }
}
