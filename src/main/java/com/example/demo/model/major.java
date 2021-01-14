package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
/**
 * Created by LSK.Reno on 2019/5/17 12:23.
 */
@Table(name = "major")
public class major extends Model{
    private int id;
    @Column(name = "major_name")
    private String major_name;
    @Column(name = "major_code")
    private String major_code;
    @Column(name = "major_popularity")
    private String major_popularity;
    @Column(name = "awarded_degree")
    private String awarded_degree;
    @Column(name = "years_of_study")
    private String years_of_study;
    @Column(name = "subject_category")
    private String subject_category;
    @Column(name = "profession_type")
    private String profession_type;
    @Column(name = "selection_discipline_advice")
    private String selection_discipline_advice;
    @Column(name = "major_sex_ratio")
    private String major_sex_ratio;
    @Column(name = "employment_rate")
    private String employment_rate;
    @Column(name = "major_what")
    private String major_what;
    @Column(name = "major_study_what")
    private String major_study_what;
    @Column(name = "major_do_what")
    private String major_do_what;
    @Column(name = "consultation_service_industry_distribution")
    private String consultation_service_industry_distribution;
    @Column(name = "advertisment_industry_distribution")
    private String advertisment_industry_distribution;

    public major(int id, String major_name, String major_code, String major_popularity, String awarded_degree, String years_of_study, String subject_category, String profession_type, String selection_discipline_advice, String major_sex_ratio, String employment_rate, String major_what, String major_study_what, String major_do_what, String consultation_service_industry_distribution, String advertisment_industry_distribution) {
        this.id = id;
        this.major_name = major_name;
        this.major_code = major_code;
        this.major_popularity = major_popularity;
        this.awarded_degree = awarded_degree;
        this.years_of_study = years_of_study;
        this.subject_category = subject_category;
        this.profession_type = profession_type;
        this.selection_discipline_advice = selection_discipline_advice;
        this.major_sex_ratio = major_sex_ratio;
        this.employment_rate = employment_rate;
        this.major_what = major_what;
        this.major_study_what = major_study_what;
        this.major_do_what = major_do_what;
        this.consultation_service_industry_distribution = consultation_service_industry_distribution;
        this.advertisment_industry_distribution = advertisment_industry_distribution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getMajor_code() {
        return major_code;
    }

    public void setMajor_code(String major_code) {
        this.major_code = major_code;
    }

    public String getMajor_popularity() {
        return major_popularity;
    }

    public void setMajor_popularity(String major_popularity) {
        this.major_popularity = major_popularity;
    }

    public String getAwarded_degree() {
        return awarded_degree;
    }

    public void setAwarded_degree(String awarded_degree) {
        this.awarded_degree = awarded_degree;
    }

    public String getYears_of_study() {
        return years_of_study;
    }

    public void setYears_of_study(String years_of_study) {
        this.years_of_study = years_of_study;
    }

    public String getSubject_category() {
        return subject_category;
    }

    public void setSubject_category(String subject_category) {
        this.subject_category = subject_category;
    }

    public String getProfession_type() {
        return profession_type;
    }

    public void setProfession_type(String profession_type) {
        this.profession_type = profession_type;
    }

    public String getSelection_discipline_advice() {
        return selection_discipline_advice;
    }

    public void setSelection_discipline_advice(String selection_discipline_advice) {
        this.selection_discipline_advice = selection_discipline_advice;
    }

    public String getMajor_sex_ratio() {
        return major_sex_ratio;
    }

    public void setMajor_sex_ratio(String major_sex_ratio) {
        this.major_sex_ratio = major_sex_ratio;
    }

    public String getEmployment_rate() {
        return employment_rate;
    }

    public void setEmployment_rate(String employment_rate) {
        this.employment_rate = employment_rate;
    }

    public String getMajor_what() {
        return major_what;
    }

    public void setMajor_what(String major_what) {
        this.major_what = major_what;
    }

    public String getMajor_study_what() {
        return major_study_what;
    }

    public void setMajor_study_what(String major_study_what) {
        this.major_study_what = major_study_what;
    }

    public String getMajor_do_what() {
        return major_do_what;
    }

    public void setMajor_do_what(String major_do_what) {
        this.major_do_what = major_do_what;
    }

    public String getConsultation_service_industry_distribution() {
        return consultation_service_industry_distribution;
    }

    public void setConsultation_service_industry_distribution(String consultation_service_industry_distribution) {
        this.consultation_service_industry_distribution = consultation_service_industry_distribution;
    }

    public String getAdvertisment_industry_distribution() {
        return advertisment_industry_distribution;
    }

    public void setAdvertisment_industry_distribution(String advertisment_industry_distribution) {
        this.advertisment_industry_distribution = advertisment_industry_distribution;
    }
}
