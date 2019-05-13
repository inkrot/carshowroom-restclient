package com.mera.inkrot.restclient.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OptionDto extends Dto implements Serializable {

    private String name;

    public OptionDto() {
    }

    public OptionDto(Long id) {
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getId() + " - " + getName();
    }
}
