package com.mera.inkrot.restclient.dto;

public class StatusCustomerDto {

    private StatusDto status;
    private CustomerDto customer;

    public StatusCustomerDto() {
    }

    public StatusCustomerDto(StatusDto status, CustomerDto customer) {
        this.status = status;
        this.customer = customer;
    }

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "StatusCustomerDto{" +
                "status=" + status +
                ", customer=" + customer +
                '}';
    }
}
