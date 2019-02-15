package com.maoyan.hi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class User {
    private Integer id;
    private String name;
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setsId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setsName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
