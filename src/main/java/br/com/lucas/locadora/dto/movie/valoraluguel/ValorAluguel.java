package br.com.lucas.locadora.dto.movie.valoraluguel;

import java.math.BigDecimal;

import br.com.lucas.locadora.dto.MovieDTO;

public abstract class ValorAluguel {

	public abstract BigDecimal calcular(MovieDTO movieDTO);
}
