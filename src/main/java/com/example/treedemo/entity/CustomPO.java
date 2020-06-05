package com.example.treedemo.entity;

import lombok.Data;

import java.util.List;

@Data
public class CustomPO {
    private int id;//自己的id
    private int pId;//父级id
    private String pName;//名称

    private List<CustomPO> child;

    public CustomPO(int pId, int pPId, String pPName, List<CustomPO> pChild) {
        id = pId;
        this.pId = pPId;
        pName = pPName;
        child = pChild;
    }
}