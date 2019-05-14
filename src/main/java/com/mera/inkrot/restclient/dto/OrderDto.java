package com.mera.inkrot.restclient.dto;

import java.io.Serializable;
import java.util.Set;

public class OrderDto extends Dto implements Serializable {

    private CustomerDto customer;
    private String modelName;
    private String brandName;
    private StatusDto status;
    private Set<OptionDto> options;

    public OrderDto(Long id, CustomerDto customer, String carName, String brandName, StatusDto status, Set<OptionDto> options) {
        setId(id);
        this.customer = customer;
        this.modelName = carName;
        this.brandName = brandName;
        this.status = status;
        this.options = options;
    }

    public OrderDto() {
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    public Set<OptionDto> getOptions() {
        return options;
    }

    public void setOptions(Set<OptionDto> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "\nЗаказ №" + getId() +
                "\n\t- Клиент: " + customer.getName() + "(id: " + customer.getId() + ")" +
                "\n\t- Модель авто: " + modelName +
                "\n\t- Бренд авто: " + brandName +
                "\n\t- Статус: " + status +
                "\n\t- Опции: " + (options.size() > 0 ? options : "-");
    }
}