package com.example.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.inventory.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.inventory.entity.*;
@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private RestockOrderRepository restockOrderRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setName(updatedSupplier.getName());
        supplier.setContactInfo(updatedSupplier.getContactInfo());
        return supplierRepository.save(supplier);
    }

    public void removeSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public RestockOrder placeRestockOrder(RestockOrder restockOrder) {
        return restockOrderRepository.save(restockOrder);
    }
}
