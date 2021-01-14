package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "药品")
public class Medicine extends Model{
    @Column(name = "药品ID")
    private int mediCineID;
    @Column(name = "药品名称")
    private String medicineName;
    @Column(name = "药品规格")
    private String medicinespecification;
    @Column(name = "包装单位")
    private String packaging;
    @Column(name = "药品剂型")
    private int medicineform;
    @Column(name = "药品类型")
    private int medicinetype;
    @Column(name = "药品单价")
    private double medicineprice;
    @Column(name = "删除标记")
    private int deletemrk ;

    public Medicine() {
    }

    public Medicine(int mediCineID, String medicineName, String medicinespecification, String packaging, int medicineform, int medicinetype, double medicineprice, int deletemrk) {
        this.mediCineID = mediCineID;
        this.medicineName = medicineName;
        this.medicinespecification = medicinespecification;
        this.packaging = packaging;
        this.medicineform = medicineform;
        this.medicinetype = medicinetype;
        this.medicineprice = medicineprice;
        this.deletemrk = deletemrk;
    }

    public int getMediCineID() {
        return mediCineID;
    }

    public void setMediCineID(int mediCineID) {
        this.mediCineID = mediCineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicinespecification() {
        return medicinespecification;
    }

    public void setMedicinespecification(String medicinespecification) {
        this.medicinespecification = medicinespecification;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public int getMedicineform() {
        return medicineform;
    }

    public void setMedicineform(int medicineform) {
        this.medicineform = medicineform;
    }

    public int getMedicinetype() {
        return medicinetype;
    }

    public void setMedicinetype(int medicinetype) {
        this.medicinetype = medicinetype;
    }

    public double getMedicineprice() {
        return medicineprice;
    }

    public void setMedicineprice(double medicineprice) {
        this.medicineprice = medicineprice;
    }

    public int getDeletemrk() {
        return deletemrk;
    }

    public void setDeletemrk(int deletemrk) {
        this.deletemrk = deletemrk;
    }
}
