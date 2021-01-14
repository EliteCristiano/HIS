package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

/**
 * Created by LSK.Reno on 2019/5/17 12:18.
 */
@Table(name = "enrollment_guide")
public class enrollment_guide extends Model {
    private int id;
    @Column(name = "university_name")
    private String university_name;
    @Column(name = "enrollment_guide_title")
    private String enrollment_guide_title;
    @Column(name = "enrollment_guide_content")
    private String enrollment_guide_content;

    public enrollment_guide() {
    }

    public enrollment_guide(int id, String university_name, String enrollment_guide_title, String enrollment_guide_content) {
        this.id = id;
        this.university_name = university_name;
        this.enrollment_guide_title = enrollment_guide_title;
        this.enrollment_guide_content = enrollment_guide_content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getEnrollment_guide_title() {
        return enrollment_guide_title;
    }

    public void setEnrollment_guide_title(String enrollment_guide_title) {
        this.enrollment_guide_title = enrollment_guide_title;
    }

    public String getEnrollment_guide_content() {
        return enrollment_guide_content;
    }

    public void setEnrollment_guide_content(String enrollment_guide_content) {
        this.enrollment_guide_content = enrollment_guide_content;
    }
}
