package com.hotel.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
