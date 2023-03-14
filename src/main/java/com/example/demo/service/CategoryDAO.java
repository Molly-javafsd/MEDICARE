package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Medicine;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryDAO {
@Autowired
CategoryRepo repo;

public Category insert(Category c) {
	return repo.save(c);
}
public Category update(Category u) {
	Category uu=repo.findById(u.getCatid()).orElse(null);
	uu.setCategoryName(u.getCategoryName());
	return repo.save(uu);
}
public List<Category> insertAll(List<Category> c){
	return repo.saveAll(c);
}
public List<Category> findAllCat(){
	return repo.findAll();
}
}
