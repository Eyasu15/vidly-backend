package com.vidly.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
	

}
