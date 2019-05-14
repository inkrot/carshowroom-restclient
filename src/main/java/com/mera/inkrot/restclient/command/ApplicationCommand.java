package com.mera.inkrot.restclient.command;

import com.mera.inkrot.restclient.dto.*;
import com.mera.inkrot.restclient.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ShellComponent
public class ApplicationCommand {

    @Autowired
    OrderService orderService;

    private Set<OptionDto> formatOptionsIdsArrayToSet(long[] optionsIds) {
        Set<OptionDto> options = new HashSet<>();
        for (long id : optionsIds)
            options.add(new OptionDto(id));
        return options;
    }

    // Example: add-order --customer "Shell Customer" --model "Camry" --brand "Toyota" --options 1,2
    @ShellMethod(key = "add-order", value = "Add order")
    public String addOrder(@ShellOption String customer,
                           @ShellOption String model,
                           @ShellOption String brand,
                           @ShellOption(value = "--options", defaultValue = "") long[] optionsIds) {
        OrderDto orderDto = new OrderDto(null, new CustomerDto(customer), model, brand, null, formatOptionsIdsArrayToSet(optionsIds));
        return orderService.saveOrder(orderDto).toString();
    }

    // Example: update-order --id 1 --customer "New"
    @ShellMethod(key = "update-order", value = "Update order")
    public String updateOrder(@ShellOption Long id,
                              @ShellOption(defaultValue = "") String customer,
                              @ShellOption(defaultValue = "") String model,
                              @ShellOption(defaultValue = "") String brand,
                              @ShellOption(value = "--status", defaultValue = "-1") Long statusId,
                              @ShellOption(value = "--options", defaultValue = "") long[] optionsIds) {
        if (customer.isEmpty()) customer = null;
        if (model.isEmpty()) model = null;
        if (brand.isEmpty()) brand = null;
        if (statusId == -1) statusId = null;
        OrderDto orderDto = new OrderDto(id, new CustomerDto(customer), model, brand, new StatusDto(statusId, null), formatOptionsIdsArrayToSet(optionsIds));
        //System.out.println(orderDto.toString());
        return orderService.updateOrder(id, orderDto).toString();
    }

    // Example: delete-order 50
    @ShellMethod(key = "delete-order", value = "Delete order by id (test)")
    public String deleteOrder(@ShellOption Long id) {
        return orderService.deleteOrder(id);
    }

    // Example: get-all-orders
    @ShellMethod(key = "get-all-orders", value = "Get all orders")
    public String getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        String ordersStr = orders.toString();
        return ordersStr.substring(1, ordersStr.length() - 1);
    }

    // Example: get-all-orders-sc --sid 1 --scode "BEING_PROCESSED" --cid 1 --cname "New Customer"
    @ShellMethod(key = "get-all-orders-sc", value = "Get all orders by status and customer")
    public String getAllOrdersByStatusAndCustomer(@ShellOption(value = "--sid", defaultValue = "-1") Long statusId,
                                                  @ShellOption(value = "--scode", defaultValue = "") String statusCode,
                                                  @ShellOption(value = "--cid", defaultValue = "-1") Long customerId,
                                                  @ShellOption(value = "--cname", defaultValue = "") String customerName) {
        if (statusId == -1) statusId = null;
        if (statusCode.isEmpty()) statusCode = null;
        if (customerId == -1) customerId = null;
        if (customerName.isEmpty()) customerName = null;
        StatusCustomerDto statusCustomerDto = new StatusCustomerDto(
                new StatusDto(statusId, statusCode),
                new CustomerDto(customerId, customerName)
        );
        List<OrderDto> orders = orderService.getAllOrdersByStatusAndCustomer(statusCustomerDto);
        String ordersStr = orders.toString();
        return ordersStr.substring(1, ordersStr.length() - 1);
    }

    // Example: get-order 1
    @ShellMethod(key = "get-order", value = "Get order by id (test)")
    public OrderDto getOrder(@ShellOption Long id) {
        return orderService.getOrder(id);
    }
}
