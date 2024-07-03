package com.example.inventory.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.inventory.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.inventory.entity.*;
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.addSupplier(supplier));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier updatedSupplier) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, updatedSupplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeSupplier(@PathVariable Long id) {
        supplierService.removeSupplier(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @PostMapping("/restock")
    public ResponseEntity<RestockOrder> placeRestockOrder(@RequestBody RestockOrder restockOrder) {
        return ResponseEntity.ok(supplierService.placeRestockOrder(restockOrder));
    }
}
