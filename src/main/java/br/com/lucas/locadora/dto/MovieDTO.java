package br.com.lucas.locadora.dto;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.lucas.locadora.dto.enums.TipoFilmeEnum;

public class MovieDTO {

	private Long id;
	private String title;
	private boolean adult;
	private List<String> genreIds;
	private String originalTitle;
	private String overview;
	private String posterPath;
	private LocalDate dataLancamento;
	private BigDecimal valorAluguel;
	private TipoFilmeEnum tipoFilme;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean isAdult() {
		return adult;
	}

	@JsonProperty(value = "original_title")
	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getOverview() {
		return overview;
	}

	@JsonProperty(value="poster_path")
	public String getPosterPath() {
		return posterPath;
	}

	@JsonProperty(value = "genre_ids")
	public List<GenreDTO> getGenreIds() {
		if(this.genreIds != null && !this.genreIds.isEmpty())
			this.genreIds.stream().map(id -> new GenreDTO(Long.valueOf(id))).collect(toList());
		return Collections.emptyList();
	}

	@JsonProperty(value = "release_date")
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public TipoFilmeEnum getTipoFilme() {
		return tipoFilme;
	}

	public void setTipoFilme(TipoFilmeEnum tipoFilme) {
		this.tipoFilme = tipoFilme;
	}
}
