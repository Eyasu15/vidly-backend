package com.vidly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.models.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long>{

}
