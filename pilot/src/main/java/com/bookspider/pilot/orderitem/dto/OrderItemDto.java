package com.bookspider.pilot.orderitem.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long itemId;
    private Double unitPrice;
    private Double totalPrice;
    private Double vat;
}
