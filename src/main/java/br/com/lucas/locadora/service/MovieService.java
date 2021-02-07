package br.com.lucas.locadora.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.lucas.locadora.client.MovieClient;
import br.com.lucas.locadora.controller.MovieController;
import br.com.lucas.locadora.dto.MovieDTO;

@Service
public class MovieService {

	private final MovieClient movieClient;
	private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);

	public MovieService(MovieClient movieClient) {
		this.movieClient = movieClient;
		LOG.info(" Instanciando o objeto MovieService ");
	}

	public List<MovieDTO> getMoviesFromAPI(final int page) {
		return movieClient.getMovies(page).getResults();
	}

	public MovieDTO getDetailsByIdFromApi(final int id) {
		return movieClient.getMovieDetails(id);
	}		

}
