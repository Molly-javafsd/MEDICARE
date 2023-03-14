package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.BankDetails;
import com.example.demo.model.Category;
import com.example.demo.model.Status;
import com.example.demo.service.AdminDAO;
import com.example.demo.service.BankDAO;
import com.example.demo.service.CategoryDAO;
import com.example.demo.service.StatusDAO;

@RestController
public class PostmanController {
	@Autowired
	AdminDAO dao;
	@Autowired
	BankDAO bdao;
	@Autowired
	CategoryDAO cdao;
	@Autowired
	StatusDAO sdao;
	
	@PostMapping("/insertadminbypostman")
	public Admin insert(@RequestBody Admin e) {
		return dao.insert(e);
	}
	@PostMapping("/insertbankbypostman")
	public List<BankDetails> insertbank(@RequestBody List<BankDetails> bd){
		return bdao.insertAll(bd);
	}
	@PostMapping("/insertCategoryByPostman")
	public Category insert(@RequestBody Category c) {
		return cdao.insert(c);
	}
	@PostMapping("/insertAllCategoryByPostman")
	public List<Category> insertAllCat(@RequestBody List<Category> c) {
		return cdao.insertAll(c);
	}
	@PostMapping("/insertAllStatusByPostman")
	public List<Status> insertAllSt(@RequestBody List<Status> c) {
		return sdao.insertAllSt(c);
	}
	@GetMapping("/getCategory")
	public List<Category> getAllCat(){
		return cdao.findAllCat();
	}
	@PutMapping("/updateCat")
	public Category updateCat(@RequestBody Category c) {
		return cdao.update(c);
	}
	@PutMapping("/updateStatus")
	public Status updateSt(@RequestBody Status c) {
		return sdao.update(c);
	}
	
}
