package com.vidly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
