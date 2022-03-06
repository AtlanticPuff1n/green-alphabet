package com.orderservice.controller.api;

import com.orderservice.dto.OrderDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public interface OrderControllerApi {

    @ApiOperation(value = "Make an order")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Order successfully placed")
            }
    )
    @PostMapping
    String addOrder(@RequestBody OrderDTO orderDto);
}
