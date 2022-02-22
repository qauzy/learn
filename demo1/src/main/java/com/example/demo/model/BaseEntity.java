package com.example.demo.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String baseName;
    public String getBaseName() {
        return baseName;
    }
    public void setBaseName(String userName) {
        this.baseName = userName;
    }

}

