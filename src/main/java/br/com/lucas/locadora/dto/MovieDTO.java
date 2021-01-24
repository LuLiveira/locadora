package br.com.lucas.locadora.dto;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDTO {

	private Long id;
	private String title;
	private boolean adult;
	private List<String> genreIds;
	private String originalTitle;
	private String overview;
	private String posterPath;

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
		return this.genreIds.stream().map(id -> new GenreDTO(id)).collect(toList());
	}

}
