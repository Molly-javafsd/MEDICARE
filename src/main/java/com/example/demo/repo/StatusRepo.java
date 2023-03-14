package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Status;

public interface StatusRepo extends JpaRepository<Status, Integer>{

}
