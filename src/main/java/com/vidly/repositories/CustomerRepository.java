package com.vidly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
