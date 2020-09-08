package com.vidly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidly.models.Movie;
import com.vidly.models.MovieBlobs;

public interface MovieBlobsRepository extends JpaRepository<MovieBlobs, Long>{

}
