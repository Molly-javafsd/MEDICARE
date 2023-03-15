package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderSummary;
import com.example.demo.repo.OrderRepo;

@Service
public class OrderDAO {
	@Autowired
	OrderRepo repo;
	
	public OrderSummary insert(OrderSummary o) {
		return repo.save(o);
	}
	public List<OrderSummary> getAll(){
		return repo.findAll();
	}
	public void deleteAll() {
		repo.deleteAll();
	}

}
