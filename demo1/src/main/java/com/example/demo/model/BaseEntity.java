package com.example.demo.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private String baseName;
    public String getBaseName() {
        return baseName;
    }
    public void setBaseName(String userName) {
        this.baseName = userName;
    }

}

