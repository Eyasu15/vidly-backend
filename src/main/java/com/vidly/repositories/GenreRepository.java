package com.vidly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
