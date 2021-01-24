package br.com.lucas.locadora.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.lucas.locadora.dto.MovieDTO;
import br.com.lucas.locadora.dto.MovieRequestDTO;
import feign.FeignException;

@FeignClient( name = "${movie.api.name}", url = "${movie.api.url}" )
public interface MovieClient {

	@GetMapping("/discover/movie?api_key=${movie.api.key}&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=false&page={page}")
	public MovieRequestDTO getMovies(@PathVariable(required = true) int page);

	@GetMapping("/movie/{id}?api_key=${movie.api.key}&language=en-US")
	public MovieDTO getMovieDetails(@PathVariable(required = true) int id) throws FeignException;
}
