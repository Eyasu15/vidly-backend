package com.vidly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
