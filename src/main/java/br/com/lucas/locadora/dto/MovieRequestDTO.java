package br.com.lucas.locadora.dto;

import java.util.List;

public class MovieRequestDTO {

	private int page;
	private List<MovieDTO> results;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<MovieDTO> getResults() {
		return results;
	}
	public void setResults(List<MovieDTO> results) {
		this.results = results;
	}
}
