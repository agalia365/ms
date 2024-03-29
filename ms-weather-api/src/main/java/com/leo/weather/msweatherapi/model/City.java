package com.leo.weather.msweatherapi.model;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {
    private String id;
    private String name;
    private List<County> countyList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<County> getCountyList() {
        return countyList;
    }

    public void setCountyList(List<County> countyList) {
        this.countyList = countyList;
    }
}
