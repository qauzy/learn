package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class UserEntity extends BaseEntity  {

    /**
     *
     */

    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String userSex;
    public SonEntity son;
    public ArrayList<String> gifts;
    public ArrayList<String> gifts2;
    public HashMap<String,String> others;
    public HashMap<String,String> others2;
    public Long getId() {
        return id;
    }
    public ArrayList<String> getGifts() {
        return gifts;
    }
    public void setGifts(ArrayList<String> gifts) {
        this.gifts = gifts;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserSex() {
        return userSex;
    }
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

}