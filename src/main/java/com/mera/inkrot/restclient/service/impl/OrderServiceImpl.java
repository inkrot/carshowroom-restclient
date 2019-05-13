package com.mera.inkrot.restclient.service.impl;

import com.mera.inkrot.restclient.dto.OrderDto;
import com.mera.inkrot.restclient.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private WebClient webClient;

    @Autowired
    public OrderServiceImpl() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/rest/order")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        return webClient.post()
                .body(Mono.just(orderDto), OrderDto.class)
                .retrieve().bodyToMono(OrderDto.class)
                .block();
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        return webClient.post()
                .uri("/{id}", id)
                .body(Mono.just(orderDto), OrderDto.class)
                .retrieve().bodyToMono(OrderDto.class)
                .block();
    }


    @Override
    //Test
    public OrderDto getOrder(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve().bodyToMono(OrderDto.class)
                .block();
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return webClient.get()
                .retrieve().bodyToFlux(OrderDto.class)
                .collectList()
                .block();
    }
}
