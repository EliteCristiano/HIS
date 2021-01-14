package com.example.demo.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name = "发票")
public class invoice extends Model{
    @Column(name = "发票ID")
    private int invoiceID;
    @Column(name = "发票金额")
    private double invoicemoney ;
    @Column(name = "收退费时间")
    private String timeoffee;
    @Column(name = "操作员ID")
    private int operatorID;
    @Column(name = "收费方式")
    private int settleway;
    @Column(name = "挂号ID")
    private int RegFeeID;
    @Column(name = "冲红发票号码")
    private int redinvoiceID;

    public invoice() {
    }

    public invoice(int invoiceID, double invoicemoney, String timeoffee, int operatorID, int settleway, int regFeeID, int redinvoiceID) {
        this.invoiceID = invoiceID;
        this.invoicemoney = invoicemoney;
        this.timeoffee = timeoffee;
        this.operatorID = operatorID;
        this.settleway = settleway;
        RegFeeID = regFeeID;
        this.redinvoiceID = redinvoiceID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public double getInvoicemoney() {
        return invoicemoney;
    }

    public void setInvoicemoney(double invoicemoney) {
        this.invoicemoney = invoicemoney;
    }

    public String getTimeoffee() {
        return timeoffee;
    }

    public void setTimeoffee(String timeoffee) {
        this.timeoffee = timeoffee;
    }

    public int getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public int getSettleway() {
        return settleway;
    }

    public void setSettleway(int settleway) {
        this.settleway = settleway;
    }

    public int getRegFeeID() {
        return RegFeeID;
    }

    public void setRegFeeID(int regFeeID) {
        RegFeeID = regFeeID;
    }

    public int getRedinvoiceID() {
        return redinvoiceID;
    }

    public void setRedinvoiceID(int redinvoiceID) {
        this.redinvoiceID = redinvoiceID;
    }
}
