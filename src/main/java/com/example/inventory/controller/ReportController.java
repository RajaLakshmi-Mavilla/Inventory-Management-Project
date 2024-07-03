package com.example.inventory.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.inventory.entity.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.inventory.service.*;
import java.util.List;
import com.example.inventory.entity.Item;
@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/stock")
    public ResponseEntity<List<Item>> generateStockReport() {
        return ResponseEntity.ok(reportService.generateStockReport());
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> generateOrderReport() {
        return ResponseEntity.ok(reportService.generateOrderReport());
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> generateSupplierReport() {
        return ResponseEntity.ok(reportService.generateSupplierReport());
    }
}

