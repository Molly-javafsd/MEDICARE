package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Medicine;
import com.example.demo.repo.MedicineRepo;

@Service
public class MedicineDAO {
	@Autowired
	MedicineRepo repo;
	
	public Medicine insert(Medicine m) {
		return repo.save(m);
	}
	
	public Medicine update(Medicine u) {
		Medicine uu=repo.findById(u.getMid()).orElse(null);
		uu.setMName(u.getMName());
		uu.setCategory(u.getCategory());
		uu.setDescription(u.getDescription());
		uu.setMPrice(u.getMPrice());
		uu.setStatus(u.getStatus());
		uu.setOffer(u.getOffer());
		return repo.save(uu);
	}
		
	public List<Medicine> delete(Medicine m){
		repo.delete(m);
		return repo.findAll();
	}
	public Medicine findById(int id) {
		return repo.getById(id);
	}
	
	public List<Medicine> findAllMeds(){
		return repo.findAll();
	}
	
	public List<Medicine> searchByNameOrCategory(String keyword){
		return repo.searchByNameOrCategory(keyword);
	}
	public List<Medicine> searchByNameOrCategoryuser(String keyword){
		return repo.searchByNameOrCategoryuser(keyword);
	}
	public List<Medicine> showToUser(){
		return repo.showToUser();
	}
	
	public List<Medicine> filterByCat(String keyword){
		return repo.filterByCat(keyword);
	}
	public List<Medicine> filterByCatuser(String keyword){
		return repo.filterByCatuser(keyword);
	}
		//get list in ascending order
	public List<Medicine> getAllAsc(){
		
		return repo.findAll(Sort.by(Sort.Direction.ASC, "mPrice"));
	}
public List<Medicine> getAllAscuser(){
		
		return repo.sortASC();
	}
	//get list in descending order
     public List<Medicine> getAllDesc(){
 		
 		return repo.findAll(Sort.by(Sort.Direction.DESC, "mPrice"));
 	}
     public List<Medicine> getAllDescuser(){
  		
  		return repo.sortDESC();
  	}
	
	
	
	}
	
	

