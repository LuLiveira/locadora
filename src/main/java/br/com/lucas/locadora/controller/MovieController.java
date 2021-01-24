package br.com.lucas.locadora.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.locadora.dto.MovieDTO;
import br.com.lucas.locadora.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);
	
	private MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping
	public ResponseEntity<List<MovieDTO>> getMovies(@RequestParam(required = true) int page) {
		LOG.info("Inicio getMoviesAPI " + System.currentTimeMillis());

		List<MovieDTO> moviesFromAPI = movieService.getMoviesFromAPI(page);
		
		LOG.info("Fim getMoviesAPI " + System.currentTimeMillis());
		
		return ResponseEntity.ok(moviesFromAPI);
	}
	
	@GetMapping("/{id}")
	public void getDetailsByIdFromApi(@PathVariable(required = true) int id) {
		movieService.getDetailsByIdFromApi(id);
	}
}
