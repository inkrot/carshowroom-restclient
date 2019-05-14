package com.mera.inkrot.restclient.dto;

import java.io.Serializable;

public class StatusDto extends Dto implements Serializable {

    private String code;

    private String name;

    public StatusDto(Long id, String code) {
        setId(id);
        this.code = code;
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