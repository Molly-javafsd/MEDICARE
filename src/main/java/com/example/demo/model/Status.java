package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statId;
	private String currentStatus;
}
