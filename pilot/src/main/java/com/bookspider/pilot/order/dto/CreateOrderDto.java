package com.bookspider.pilot.order.dto;

import com.bookspider.pilot.orderitem.dto.OrderItemDto;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {

    private Long ordererId;

    private List<OrderItemDto> orderItemDtoList;
}
