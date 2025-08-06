package com.et.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.et.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
