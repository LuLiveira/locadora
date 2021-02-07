package br.com.lucas.locadora.service.movie.tipofilme;

import java.time.LocalDate;

import br.com.lucas.locadora.dto.MovieDTO;
import br.com.lucas.locadora.dto.enums.TipoFilmeEnum;

public abstract class TipoFilme {
	
	protected TipoFilme proximo;
	protected LocalDate hoje;
	protected LocalDate lancamento;
	
	public TipoFilme(TipoFilme tipoFilme) {
		proximo = tipoFilme;
	}

	public abstract TipoFilmeEnum calcular(MovieDTO movieDTO);
}
