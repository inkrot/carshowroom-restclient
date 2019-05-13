package com.mera.inkrot.restclient.dto;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDto extends Dto implements Serializable {

    private String customerName;
    private String modelName;
    private String brandName;
    private StatusDto status;
    @XmlElementWrapper(name = "options")
    @XmlElement(name = "option")
    private Set<OptionDto> options;

    public OrderDto(Long id, String customerName, String carName, String brandName, StatusDto status, Set<OptionDto> options) {
        setId(id);
        this.customerName = customerName;
        this.modelName = carName;
        this.brandName = brandName;
        this.status = status;
        this.options = options;
    }

    public OrderDto() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
                "\n\t- Клиент: " + customerName +
                "\n\t- Модель авто: " + modelName +
                "\n\t- Бренд авто: " + brandName +
                "\n\t- Статус: " + status +
                "\n\t- Опции: " + (options.size() > 0 ? options : "-");
    }
}
