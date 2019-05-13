package com.mera.inkrot.restclient.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="status")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatusDto extends Dto implements Serializable {

    private String code;

    private String name;

    public StatusDto(Long id) {
        setId(id);
    }

    public StatusDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
