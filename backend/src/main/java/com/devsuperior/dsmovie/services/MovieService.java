package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.DTO.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)  //deixa mais eficiente no banco de dados
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = repository.findAll(pageable);
        Page<MovieDTO> page = result.map(movie -> new MovieDTO(movie));
        return page;
    }

    @Transactional(readOnly = true)  //deixa mais eficiente no banco de dados
    public MovieDTO findById(Long id) {
        Movie movie = repository.findById(id).get();
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }



}
