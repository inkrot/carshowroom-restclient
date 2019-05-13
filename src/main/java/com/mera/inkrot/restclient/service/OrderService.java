package com.mera.inkrot.restclient.service;

import com.mera.inkrot.restclient.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    OrderDto getOrder(Long id);

    OrderDto updateOrder(Long id, OrderDto orderDto);

    OrderDto saveOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();
}
