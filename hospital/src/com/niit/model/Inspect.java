package com.niit.model;


import java.util.Date;

public class Inspect {
    private int inspectId;
    private String inspectName;
    private String description;
    private double cost;
    private Date createTime;

    public int getInspectId() {
        return inspectId;
    }

    public void setInspectId(int inspectId) {
        this.inspectId = inspectId;
    }

    public String getInspectName() {
        return inspectName;
    }

    public void setInspectName(String inspectName) {
        this.inspectName = inspectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
