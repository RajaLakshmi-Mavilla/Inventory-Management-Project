package com.example.inventory.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.inventory.entity.*;
import com.example.inventory.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.inventory.entity.Item;
@Service
public class ReportService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Item> generateStockReport() {
        return itemRepository.findAll();
    }

    public List<Order> generateOrderReport() {
        return orderRepository.findAll();
    }

    public List<Supplier> generateSupplierReport() {
        return supplierRepository.findAll();
    }
}
