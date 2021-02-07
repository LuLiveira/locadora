package br.com.lucas.locadora.dto;

public class GenreDTO {
	
	private Long id;
	private String nome;

	public GenreDTO(Long id) {
		this.id = id;
	}
	
	public GenreDTO(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
