package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Status;
import com.example.demo.repo.StatusRepo;

@Service
public class StatusDAO {
@Autowired
StatusRepo repo;

public List<Status> insertAllSt(List<Status> s) {
	return repo.saveAll(s);
}
public List<Status> findAllSt(){
	return repo.findAll();
}
public Status update(Status u) {
	Status uu=repo.findById(u.getStatId()).orElse(null);
	uu.setCurrentStatus(u.getCurrentStatus());
	return repo.save(uu);
}
}
