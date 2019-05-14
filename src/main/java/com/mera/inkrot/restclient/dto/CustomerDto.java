package com.mera.inkrot.restclient.dto;

import java.io.Serializable;

public class CustomerDto extends Dto implements Serializable {

    private String name;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name) {
        setId(id);
        this.name = name;
    }

    public CustomerDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StatusDto{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
