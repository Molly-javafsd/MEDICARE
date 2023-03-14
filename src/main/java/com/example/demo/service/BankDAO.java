package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BankDetails;
import com.example.demo.repo.BankRepo;

@Service
public class BankDAO {
@Autowired
BankRepo brepo;

public List<BankDetails> insertAll(List<BankDetails> bd) {
	return brepo.saveAll(bd);
}

public BankDetails insert(BankDetails bd) {
	return brepo.save(bd);
}

public int getBalance(int bid) {
	return brepo.getBalance(bid);
}
}
