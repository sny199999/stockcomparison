package com.dyh.stockcomparison.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class StatisticalDfday implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "5")
    private Double five;

    @ApiModelProperty(value = "10tian ")
    private Double ten;

    @ApiModelProperty(value = "15天")
    private Double fifteen;

    private Double twenty;

    @ApiModelProperty(value = "df关联id")
    private Integer dfId;

    private Date date;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFive() {
        return five;
    }

    public void setFive(Double five) {
        this.five = five;
    }

    public Double getTen() {
        return ten;
    }

    public void setTen(Double ten) {
        this.ten = ten;
    }

    public Double getFifteen() {
        return fifteen;
    }

    public void setFifteen(Double fifteen) {
        this.fifteen = fifteen;
    }

    public Double getTwenty() {
        return twenty;
    }

    public void setTwenty(Double twenty) {
        this.twenty = twenty;
    }

    public Integer getDfId() {
        return dfId;
    }

    public void setDfId(Integer dfId) {
        this.dfId = dfId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", five=").append(five);
        sb.append(", ten=").append(ten);
        sb.append(", fifteen=").append(fifteen);
        sb.append(", twenty=").append(twenty);
        sb.append(", dfId=").append(dfId);
        sb.append(", date=").append(date);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}