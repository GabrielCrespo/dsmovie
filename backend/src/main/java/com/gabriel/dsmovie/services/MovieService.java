package com.gabriel.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.dsmovie.dto.MovieDTO;
import com.gabriel.dsmovie.entities.Movie;
import com.gabriel.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> movies = repository.findAll(pageable);
		Page<MovieDTO> page = movies.map(movie -> new MovieDTO(movie));
		return page;
	}

	public MovieDTO findById(Long id) {
		Movie movie = repository.findById(id).get();
		return new MovieDTO(movie);
	}

}
