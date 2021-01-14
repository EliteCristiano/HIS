package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

/**
 * Created by LSK.Reno on 2019/5/17 12:09.
 */
@Table(name = "university")
public class university extends Model{
    @Column(name = "university_name")
    private String university_name;
    @Column(name = "university_id")
    private String university_id;
    @Column(name = "competent_department")
    private String competent_department;
    @Column(name = "province")
    private String province;
    @Column(name = "level")
    private String level;
    @Column(name = "note")
    private String note;
    @Column(name = "university_description")
    private String university_description;
    @Column(name = "u985")
    private String u985;
    @Column(name = "u211")
    private String u211;
    @Column(name = "double_first_class")
    private String double_first_class;


    public university(String university_name, String university_id, String competent_department, String province, String level, String note, String university_description, String u985, String u211, String double_first_class) {
        this.university_name = university_name;
        this.university_id = university_id;
        this.competent_department = competent_department;
        this.province = province;
        this.level = level;
        this.note = note;
        this.university_description = university_description;
        this.u985 = u985;
        this.u211 = u211;
        this.double_first_class = double_first_class;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(String university_id) {
        this.university_id = university_id;
    }

    public String getCompetent_department() {
        return competent_department;
    }

    public void setCompetent_department(String competent_department) {
        this.competent_department = competent_department;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUniversity_description() {
        return university_description;
    }

    public void setUniversity_description(String university_description) {
        this.university_description = university_description;
    }

    public String getU985() {
        return u985;
    }

    public void setU985(String u985) {
        this.u985 = u985;
    }

    public String getU211() {
        return u211;
    }

    public void setU211(String u211) {
        this.u211 = u211;
    }

    public String getDouble_first_class() {
        return double_first_class;
    }

    public void setDouble_first_class(String double_first_class) {
        this.double_first_class = double_first_class;
    }
}
