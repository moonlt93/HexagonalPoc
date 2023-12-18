package com.bookspider.pilot.order.controller;

import com.bookspider.pilot.order.domain.Orders;
import com.bookspider.pilot.order.dto.CreateOrderDto;
import com.bookspider.pilot.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public Long createOrder(@RequestBody CreateOrderDto createOrderDto) {
        return orderService.createOrder(createOrderDto);
    }

    @GetMapping("/orders")
    public List<Orders> getOrderList() {
        return orderService.getOrderList();
    }

}
