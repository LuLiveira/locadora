package br.com.lucas.locadora.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucas.locadora.client.MovieClient;
import br.com.lucas.locadora.dto.MovieDTO;

@Service
public class MovieService {

	private final MovieClient movieClient;

	public MovieService(MovieClient movieClient) {
		this.movieClient = movieClient;
	}

	public List<MovieDTO> getMoviesFromAPI(final int page) {
		return movieClient.getMovies(page).getResults();
	}

	public MovieDTO getDetailsByIdFromApi(final int id) {
		return movieClient.getMovieDetails(id);
	}		

}
