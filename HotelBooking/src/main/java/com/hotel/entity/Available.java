package com.hotel.entity;

import java.time.LocalDate;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Available {

	@Id
	@GeneratedValue
	private Long id;

	private Map<LocalDate, Boolean> availability;
}
