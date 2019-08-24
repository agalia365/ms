package com.leo.weather.msweathercity.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City implements Serializable {
    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "county")
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
