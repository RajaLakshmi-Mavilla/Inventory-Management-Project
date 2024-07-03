package com.example.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventory.entity.RestockOrder;

@Repository
public interface RestockOrderRepository extends JpaRepository<RestockOrder, Long> {
}
