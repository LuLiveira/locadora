package br.com.lucas.locadora.service.movie.tipofilme.impl;


import java.time.LocalDate;

import br.com.lucas.locadora.dto.MovieDTO;
import br.com.lucas.locadora.dto.enums.TipoFilmeEnum;
import br.com.lucas.locadora.service.movie.tipofilme.TipoFilme;

public class TipoFilmeLancamento extends TipoFilme {

	public TipoFilmeLancamento(TipoFilme tipoFilme) {
		super(tipoFilme);
	}

	@Override
	public TipoFilmeEnum calcular(MovieDTO movieDTO) {
		hoje = LocalDate.now();
		lancamento = movieDTO.getDataLancamento();
		
		if(hoje.minusMonths(3).isAfter(lancamento)) {
			return TipoFilmeEnum.LANCAMENTO;
		}
		
		return proximo.calcular(movieDTO);
		
	}

}
