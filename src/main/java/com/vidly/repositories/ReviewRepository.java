package com.vidly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
