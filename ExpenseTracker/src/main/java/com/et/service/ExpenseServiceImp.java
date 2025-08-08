package com.et.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.et.entity.Expense;
import com.et.entity.User;
import com.et.repository.ExpenseRepository;

@Service
public class ExpenseServiceImp implements ExpenseService {

	private ExpenseRepository expenseRepository;

	public ExpenseServiceImp(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	@Override
	public String addExpense(Expense expense) {
		expenseRepository.save(expense);
		return "Expense Added Successfully";
	}

	@Override
	public List<Expense> filter(User user, String fromDate, String toDate) {

		LocalDate fDate = LocalDate.parse(fromDate);
		LocalDate tDate = LocalDate.parse(toDate);

		List<Expense> expenses = expenseRepository.findByUserAndCreatedDateBetween(user, fDate, tDate);

		return expenses;
	}

	@Override
	public Expense findById(Integer eid) {
		return expenseRepository.findById(eid).get();
	}

	@Override
	public String updateExpense(Expense expense) {
		Expense ex = findById(expense.getEid());
		ex.setAmount(expense.getAmount());
		ex.setDescription(expense.getDescription());
		ex.setName(expense.getName());
		ex.setUpdateDate(expense.getUpdateDate());
		String name = expenseRepository.save(ex).getName();
		return name + " Expense Updated Successfully";
	}

	@Override
	public String deleteExpense(Integer eid) {
		expenseRepository.deleteById(eid);
		return "expense with id : " + eid + " is deleted.";
	}

}
