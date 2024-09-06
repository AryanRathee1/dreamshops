package com.aryan.dreamshops.service.order;

import com.aryan.dreamshops.dto.OrderDto;
import com.aryan.dreamshops.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
