package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

/**
 * Created by LSK.Reno on 2019/5/17 12:22.
 */
@Table(name = "new_entrance_policy")
public class new_entrance_policy extends Model{
    private int id;
    @Column(name = "new_entrance_policy_title")
    private String new_entrance_policy_title;
    @Column(name = "new_entrance_policy_content")
    private String new_entrance_policy_content;
    @Column(name = "new_entrance_policy_province")
    private String new_entrance_policy_province;

    public new_entrance_policy(int id, String new_entrance_policy_title, String new_entrance_policy_content, String new_entrance_policy_province) {
        this.id = id;
        this.new_entrance_policy_title = new_entrance_policy_title;
        this.new_entrance_policy_content = new_entrance_policy_content;
        this.new_entrance_policy_province = new_entrance_policy_province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNew_entrance_policy_title() {
        return new_entrance_policy_title;
    }

    public void setNew_entrance_policy_title(String new_entrance_policy_title) {
        this.new_entrance_policy_title = new_entrance_policy_title;
    }

    public String getNew_entrance_policy_content() {
        return new_entrance_policy_content;
    }

    public void setNew_entrance_policy_content(String new_entrance_policy_content) {
        this.new_entrance_policy_content = new_entrance_policy_content;
    }

    public String getNew_entrance_policy_province() {
        return new_entrance_policy_province;
    }

    public void setNew_entrance_policy_province(String new_entrance_policy_province) {
        this.new_entrance_policy_province = new_entrance_policy_province;
    }
}
