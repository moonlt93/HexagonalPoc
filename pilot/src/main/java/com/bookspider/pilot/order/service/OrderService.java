package com.bookspider.pilot.order.service;

import com.bookspider.pilot.item.domain.Item;
import com.bookspider.pilot.member.domain.Member;
import com.bookspider.pilot.order.domain.Orders;
import com.bookspider.pilot.order.dto.CreateOrderDto;
import com.bookspider.pilot.order.repository.OrderRepository;
import com.bookspider.pilot.orderitem.domain.OrderItem;
import com.bookspider.pilot.orderitem.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Long createOrder(CreateOrderDto createOrderDto) {

        Orders order = Orders.builder()
                .orderer(mapToMember(createOrderDto.getOrdererId()))
                .items(createOrderDto.getOrderItemDtoList()
                        .stream()
                        .map(this::mapOrderItemDtoToOrderItem)
                        .toList())
                .build();

        Orders createdOrder = orderRepository.save(order);
        return createdOrder.getId();
    }

    public List<Orders> getOrderList() {
        return orderRepository.findAllOrderWithItemList();
    }


    private Member mapToMember(Long memberId) {
        return Member.builder()
                .id(memberId)
                .build();
    }

    private OrderItem mapOrderItemDtoToOrderItem(OrderItemDto orderItemDto) {
        Item item = Item.builder()
                .id(orderItemDto.getItemId())
                .build();

        return OrderItem.builder()
                .vat(orderItemDto.getVat())
                .item(item)
                .unitPrice(orderItemDto.getUnitPrice())
                .totalPrice(orderItemDto.getTotalPrice())
                .build();
    }
}
