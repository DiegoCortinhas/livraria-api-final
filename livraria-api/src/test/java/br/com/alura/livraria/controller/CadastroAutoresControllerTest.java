package br.com.alura.livraria.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class CadastroAutoresControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	
	@Test
	void naoDeveriaCadastrarAutoresComDadosIncompletos() throws Exception {
		String json = "{}";
		mvc
		.perform(post("/autores")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	void deveriaCadastrarAutoresComDadosCompletos() throws Exception {
		String json = "{\"nome\":\"Diego Cortinhas\",\"email\":\"diegoc@email.com\",\"dataNascimento\":\"1988-03-07\",\"miniCurriculo\":\"Escritor\"}";
		mvc
		.perform(post("/autores")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json))
		.andExpect(status().isCreated())
		.andExpect(header().exists("Location"))
		.andExpect(content().json(json));
	}
	

}
