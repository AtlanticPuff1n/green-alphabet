package com.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String SKU;
    private BigDecimal price;
    private Integer quantity;
}
