package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.OrderSummary;

public interface OrderRepo extends JpaRepository<OrderSummary, Integer>{
	
}
