package com.et.service;

import org.springframework.stereotype.Service;

import com.et.repository.ExpenseRepository;

@Service
public class ExpenseServiceImp implements ExpenseService {

	private ExpenseRepository expenseRepository;

	public ExpenseServiceImp(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

}
