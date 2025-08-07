package com.et.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.et.entity.Expense;
import com.et.entity.User;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	List<Expense> findByUserAndCreatedDateBetween(User user, LocalDate from, LocalDate to);
}
