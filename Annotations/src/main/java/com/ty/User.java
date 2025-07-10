package com.ty;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user_info") // to provide custom name to table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq") // to auto generate the id
	@SequenceGenerator(name = "my_seq", initialValue = 49, allocationSize = 10)
	private int uid;

	@Column(name = "user_name") // custom column name
	private String name;

	@Column(updatable = false, nullable = false) // constraints
	private String email;

	@Column(unique = true, length = 10)
	private long phone;

	@CreationTimestamp // to store data and time at which record is inserted
	@Column(updatable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp // to store data and time at which record is updated
	private LocalDateTime updatedDate;

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
