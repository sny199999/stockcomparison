package com.dyh.stockcomparison.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class DfcfEastmoney implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "最新价")
    private String f2;

    @ApiModelProperty(value = "涨跌幅")
    private String f3;

    @ApiModelProperty(value = "涨跌金额")
    private String f4;
 @ApiModelProperty(value = "成交量手")
    private String f5;



    @ApiModelProperty(value = "股票代码")
    private String f12;

    @ApiModelProperty(value = "股票名称")
    private String f14;

    @ApiModelProperty(value = "第一次创建时间")
    private Date date;

    @ApiModelProperty(value = "修改时间")
    private Date utdate;

    private String ten;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }


    public String getF5() {
        return f5;
    }

    public void setF5(String f5) {
        this.f5 = f5;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getF12() {
        return f12;
    }

    public void setF12(String f12) {
        this.f12 = f12;
    }

    public String getF14() {
        return f14;
    }

    public void setF14(String f14) {
        this.f14 = f14;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getUtdate() {
        return utdate;
    }

    public void setUtdate(Date utdate) {
        this.utdate = utdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", f2=").append(f2);
        sb.append(", f3=").append(f3);
        sb.append(", f4=").append(f4);
        sb.append(", f5=").append(f5);
        sb.append(", f12=").append(f12);
        sb.append(", f14=").append(f14);
        sb.append(", date=").append(date);
        sb.append(", utdate=").append(utdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}