package com.doudou.bill.common.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="request")
public class XmlModel {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }
}
