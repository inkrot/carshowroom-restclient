package com.mera.inkrot.restclient.command;

import com.mera.inkrot.restclient.dto.OptionDto;
import com.mera.inkrot.restclient.dto.OrderDto;
import com.mera.inkrot.restclient.dto.StatusDto;
import com.mera.inkrot.restclient.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.security.Key;
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

    // add-order --customer "Shell Customer" --model "Camry" --brand "Toyota" --options 1,2
    @ShellMethod(key = "add-order", value = "Add order")
    public String addOrder(@ShellOption String customer,
                           @ShellOption String model,
                           @ShellOption String brand,
                           @ShellOption("--options") long[] optionsIds) {
        OrderDto orderDto = new OrderDto(null, customer, model, brand, null, formatOptionsIdsArrayToSet(optionsIds));
        return orderService.saveOrder(orderDto).toString();
    }

    // update-order --id 1 --customer "New"
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
        OrderDto orderDto = new OrderDto(id, customer, model, brand, new StatusDto(statusId), formatOptionsIdsArrayToSet(optionsIds));
        //System.out.println(orderDto.toString());
        return orderService.updateOrder(id, orderDto).toString();
    }

    @ShellMethod(key = "get-all-orders", value = "Get all orders")
    public String getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        String ordersStr = orders.toString();
        return ordersStr.substring(1, ordersStr.length() - 1);
    }

    @ShellMethod(key = "get", value = "Get order by id (test)")
    public OrderDto getOrder(@ShellOption Long id) {
        return orderService.getOrder(id);
    }
}
