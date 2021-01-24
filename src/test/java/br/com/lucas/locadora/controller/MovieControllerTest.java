package br.com.lucas.locadora.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

	@Autowired
	private MockMvc mockMvc;
	private URI uri;

	void deveRetornar200SeExistirFilme() throws Exception {

		uri = new URI("/movies");

		mockMvc
			.perform(MockMvcRequestBuilders.get(uri)
											.queryParam("page", "1")
											.contentType(APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(OK.value()));
	}
	
	void deveRetornar200SeExistirFilmeComId() throws Exception {
		uri = new URI("/movies/464052");

		mockMvc
			.perform(MockMvcRequestBuilders.get(uri)
											.contentType(APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(OK.value()));
	}
	
	@Test
	void deveRetornar401SeNaoExistirFilmeComId() throws Exception {
		uri = new URI("/movies/0");
		
		mockMvc
			.perform(MockMvcRequestBuilders.get(uri)
											.contentType(APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(NOT_FOUND.value()));
	}

}
