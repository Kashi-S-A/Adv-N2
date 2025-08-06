package com.et.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;

	@Column(unique = true, nullable = false)
	@Size(min = 4, max = 20, message = "username between 4 and 20 chars")
	private String username;

	private String password;

	private String fullName;

	@Column(unique = true)
	private String email;

	@OneToMany(mappedBy = "user")
	private List<Expense> expenses;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updateDate;
}
