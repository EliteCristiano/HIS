package com.example.demo.model;
import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name="病历首页")
public class medfirst extends Model {
    @Column(name = "病历号")
    private int medhisss;
    @Column(name = "挂号ID")
    private int regiddd;
    @Column(name = "主诉")
    private String mainsituation;
    @Column(name = "现病史")
    private String nowsituation;
    @Column(name = "现病治疗情况")
    private String nowtreatment;
    @Column(name = "既往史")
    private String pastsit;
    @Column(name = "过敏史")
    private String allegyhis;
    @Column(name = "体格检查")
    private String bodycheck;
    @Column(name = "检查建议")
    private String checkadvice;
    @Column(name = "注意事项")
    private String attention;
    @Column(name = "病历状态")
    private int medhisstate;

    public medfirst() {
    }

    public medfirst(int medhisss, int regiddd, String mainsituation, String nowsituation, String nowtreatment, String pastsit, String allegyhis, String bodycheck, String checkadvice, String attention, int medhisstate) {
        this.medhisss = medhisss;
        this.regiddd = regiddd;
        this.mainsituation = mainsituation;
        this.nowsituation = nowsituation;
        this.nowtreatment = nowtreatment;
        this.pastsit = pastsit;
        this.allegyhis = allegyhis;
        this.bodycheck = bodycheck;
        this.checkadvice = checkadvice;
        this.attention = attention;
        this.medhisstate = medhisstate;
    }

    public int getMedhisss() {
        return medhisss;
    }

    public void setMedhisss(int medhisss) {
        this.medhisss = medhisss;
    }

    public int getRegiddd() {
        return regiddd;
    }

    public void setRegiddd(int regiddd) {
        this.regiddd = regiddd;
    }

    public String getMainsituation() {
        return mainsituation;
    }

    public void setMainsituation(String mainsituation) {
        this.mainsituation = mainsituation;
    }

    public String getNowsituation() {
        return nowsituation;
    }

    public void setNowsituation(String nowsituation) {
        this.nowsituation = nowsituation;
    }

    public String getNowtreatment() {
        return nowtreatment;
    }

    public void setNowtreatment(String nowtreatment) {
        this.nowtreatment = nowtreatment;
    }

    public String getPastsit() {
        return pastsit;
    }

    public void setPastsit(String pastsit) {
        this.pastsit = pastsit;
    }

    public String getAllegyhis() {
        return allegyhis;
    }

    public void setAllegyhis(String allegyhis) {
        this.allegyhis = allegyhis;
    }

    public String getBodycheck() {
        return bodycheck;
    }

    public void setBodycheck(String bodycheck) {
        this.bodycheck = bodycheck;
    }

    public String getCheckadvice() {
        return checkadvice;
    }

    public void setCheckadvice(String checkadvice) {
        this.checkadvice = checkadvice;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public int getMedhisstate() {
        return medhisstate;
    }

    public void setMedhisstate(int medhisstate) {
        this.medhisstate = medhisstate;
    }
}
