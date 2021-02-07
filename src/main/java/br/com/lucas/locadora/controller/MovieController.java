package br.com.lucas.locadora.controller;

import static java.lang.System.currentTimeMillis;

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
	
	public MovieController(MovieService movieService) throws InterruptedException {
		this.movieService = movieService;
		LOG.info(" Instanciando o objeto MovieController ");
	}

	@GetMapping
	public ResponseEntity<List<MovieDTO>> getMovies(@RequestParam(required = true) final int page) {
		LOG.info(this.toString());

		LOG.info("Inicio getMoviesAPI " + currentTimeMillis());

		var moviesFromAPI = movieService.getMoviesFromAPI(page);
		
		LOG.info("Fim getMoviesAPI " + currentTimeMillis());
		
		return ResponseEntity.ok(moviesFromAPI);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getDetailsByIdFromApi(@PathVariable(required = true) final int id) {
		return ResponseEntity.ok(movieService.getDetailsByIdFromApi(id));
	}
}
