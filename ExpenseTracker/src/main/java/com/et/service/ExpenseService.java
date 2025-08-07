package com.et.service;

import java.util.List;

import com.et.entity.Expense;
import com.et.entity.User;

public interface ExpenseService {

	String addExpense(Expense expense);

	List<Expense> filter(User user, String fromDate, String toDate);

}
