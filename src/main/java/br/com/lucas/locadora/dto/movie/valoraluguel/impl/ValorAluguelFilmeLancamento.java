package br.com.lucas.locadora.dto.movie.valoraluguel.impl;

import java.math.BigDecimal;

import br.com.lucas.locadora.dto.MovieDTO;
import br.com.lucas.locadora.dto.enums.TipoFilmeEnum;
import br.com.lucas.locadora.dto.movie.valoraluguel.ValorAluguel;

public class ValorAluguelFilmeLancamento extends ValorAluguel {

	@Override
	public BigDecimal calcular(MovieDTO movieDTO) {
		if(TipoFilmeEnum.LANCAMENTO.equals(movieDTO.getTipoFilme())) {
			return new BigDecimal("10");
		}
		return BigDecimal.ZERO;
	}

}
