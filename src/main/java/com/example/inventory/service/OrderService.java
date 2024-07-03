package com.example.inventory.service;
import com.example.inventory.entity.Order;
import com.example.inventory.entity.OrderItem;
import com.example.inventory.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventory.repository.*;



import java.math.BigDecimal;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StockService stockService;

   public Order createOrder(Order order) {
    for (OrderItem orderItem : order.getOrderItems()) {
        Item item = stockService.getItemById(orderItem.getItemId());
        if (item.getQuantity() < orderItem.getQuantity()) {
            throw new RuntimeException("Insufficient stock for item: " + item.getName());
        }
        item.setQuantity(item.getQuantity() - orderItem.getQuantity());
        stockService.updateItem(item.getId(), item);
        orderItem.setPrice(item.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
    }
    return orderRepository.save(order);
}

      

    public Order updateOrder(Long id, Order updatedOrder) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(updatedOrder.getStatus());
        return orderRepository.save(order);
    }

    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        for (OrderItem orderItem : order.getOrderItems()) {
            Item item = stockService.getItemById(orderItem.getItemId());
            item.setQuantity(item.getQuantity() + orderItem.getQuantity());
            stockService.updateItem(item.getId(), item);
        }
        orderRepository.deleteById(id);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
