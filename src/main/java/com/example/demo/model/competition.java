package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
/**
 * Created by LSK.Reno on 2019/5/17 12:20.
 */
@Table(name = "competition")
public class competition extends Model {
    private int id;
    @Column(name = "competition_name")
    private String competition_name;
    @Column(name = "competition_category")
    private String competition_category;
    @Column(name = "competition_type")
    private String competition_type;
    @Column(name = "competition_organizer")
    private String competition_organizer;
    @Column(name = "competition_award")
    private String competition_award;
    @Column(name = "recognition_of_university")
    private String recognition_of_university;
    @Column(name = "competition_description")
    private String competition_description;

    public competition(int id, String competition_name, String competition_category, String competition_type, String competition_organizer, String competition_award, String recognition_of_university, String competition_description) {
        this.id = id;
        this.competition_name = competition_name;
        this.competition_category = competition_category;
        this.competition_type = competition_type;
        this.competition_organizer = competition_organizer;
        this.competition_award = competition_award;
        this.recognition_of_university = recognition_of_university;
        this.competition_description = competition_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getCompetition_category() {
        return competition_category;
    }

    public void setCompetition_category(String competition_category) {
        this.competition_category = competition_category;
    }

    public String getCompetition_type() {
        return competition_type;
    }

    public void setCompetition_type(String competition_type) {
        this.competition_type = competition_type;
    }

    public String getCompetition_organizer() {
        return competition_organizer;
    }

    public void setCompetition_organizer(String competition_organizer) {
        this.competition_organizer = competition_organizer;
    }

    public String getCompetition_award() {
        return competition_award;
    }

    public void setCompetition_award(String competition_award) {
        this.competition_award = competition_award;
    }

    public String getRecognition_of_university() {
        return recognition_of_university;
    }

    public void setRecognition_of_university(String recognition_of_university) {
        this.recognition_of_university = recognition_of_university;
    }

    public String getCompetition_description() {
        return competition_description;
    }

    public void setCompetition_description(String competition_description) {
        this.competition_description = competition_description;
    }
}
