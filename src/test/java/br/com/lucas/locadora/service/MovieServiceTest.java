package br.com.lucas.locadora.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lucas.locadora.dto.MovieDTO;
import br.com.lucas.locadora.dto.movie.valoraluguel.ValorAluguel;
import br.com.lucas.locadora.dto.movie.valoraluguel.impl.ValorAluguelFilmeLancamento;
import br.com.lucas.locadora.service.movie.tipofilme.TipoFilme;
import br.com.lucas.locadora.service.movie.tipofilme.impl.TipoFilmeLancamento;
import br.com.lucas.locadora.service.movie.tipofilme.impl.TipoFilmeRecente;

@SpringBootTest
public class MovieServiceTest {

	@Autowired
	private MovieService movieService;
	
	
	@Test
	public void teste() {
		MovieDTO movieDTO = movieService.getMoviesFromAPI(1).get(0);
		
		TipoFilme tipoFilme = new TipoFilmeLancamento(
								new TipoFilmeRecente());
		movieDTO.setTipoFilme(tipoFilme.calcular(movieDTO));
		
		ValorAluguel valorAluguel = new ValorAluguelFilmeLancamento();
		valorAluguel.calcular(movieDTO);
		
		System.out.println(movieDTO.getTipoFilme());
	}
}
