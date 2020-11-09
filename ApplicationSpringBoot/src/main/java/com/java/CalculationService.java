package com.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CalculationService {

	@Autowired
	private CalculationRepository repo;
	
	public List<Calculation> listAll() {
		return repo.findAll();
	}
	
	public void save(Calculation cal) {
		repo.save(cal);
	}
	
	public Calculation get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
