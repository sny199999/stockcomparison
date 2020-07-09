package com.dyh.stockcomparison.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SubKd implements Serializable {
    private int id;

    @ApiModelProperty(value = "日期")
    private Date data;

    @ApiModelProperty(value = "当前价格")
    private String currentAmount;

    @ApiModelProperty(value = "成交量")
    private String volume;

    @ApiModelProperty(value = "成交金额")
    private String turnover;

    @ApiModelProperty(value = "K线每天对应的主表id")
    private int stId;

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(String currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", data=").append(data);
        sb.append(", currentAmount=").append(currentAmount);
        sb.append(", volume=").append(volume);
        sb.append(", turnover=").append(turnover);
        sb.append(", stId=").append(stId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}