package com.example.inventory.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.inventory.entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.service.*;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(stockService.addItem(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        return ResponseEntity.ok(stockService.updateItem(id, updatedItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeItem(@PathVariable Long id) {
        stockService.removeItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getItemById(id));
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(stockService.getAllItems());
    }
}
