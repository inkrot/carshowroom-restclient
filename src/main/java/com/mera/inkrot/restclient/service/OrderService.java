package com.mera.inkrot.restclient.service;

import com.mera.inkrot.restclient.dto.OrderDto;
import com.mera.inkrot.restclient.dto.StatusCustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    void setWebClient(String host);

    OrderDto getOrder(Long id);

    OrderDto saveOrder(OrderDto orderDto);

    OrderDto updateOrder(Long id, OrderDto orderDto);

    String deleteOrder(Long id);

    List<OrderDto> getAllOrders();

    List<OrderDto> getAllOrdersByStatusAndCustomer(StatusCustomerDto statusCustomerDto);
}
