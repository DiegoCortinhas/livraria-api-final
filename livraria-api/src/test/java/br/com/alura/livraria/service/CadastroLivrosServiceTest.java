package br.com.alura.livraria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.livraria.dto.CadastroLivrosDto;
import br.com.alura.livraria.dto.CadastroLivrosFormDto;
import br.com.alura.livraria.repository.CadastroAutoresRepository;
import br.com.alura.livraria.repository.CadastroLivrosRepository;

@ExtendWith(MockitoExtension.class)
class CadastroLivrosServiceTest {
	
	@Mock
	private CadastroLivrosRepository cadastroLivrosRepository;
	@Mock
	private CadastroAutoresRepository cadastroAutoresRepository;
	
	@InjectMocks
	private CadastroLivrosService service;
	
	private CadastroLivrosFormDto criarLivrosFormDto(String titulo, Integer quantidade, Long id) {
		CadastroLivrosFormDto formDto = new CadastroLivrosFormDto(
				titulo, 
				LocalDate.now(), 
				quantidade, 
				id,
				1L);
		return formDto;
	}
	
	@Test
	void deveriaCadastrarUmLivro() {
		
		CadastroLivrosFormDto formDto = criarLivrosFormDto("A culpa é das Estrelas",570,2l);
		CadastroLivrosDto dto = service.cadastrar(formDto);
		
		Mockito.verify(cadastroLivrosRepository).save(Mockito.any());
		
		assertEquals(formDto.getTitulo(), dto.getTitulo());
		assertEquals(formDto.getNumeroPaginas(), dto.getNumeroPaginas());
		assertEquals(formDto.getDataLancamento(), dto.getDataLancamento());
	}

			
	@Test
	void naoDeveriaCadastrarUmLivroComAutorInexistente() {
		
		CadastroLivrosFormDto formDto = criarLivrosFormDto("A culpa é das Estrelas",570,999999l);
		
		Mockito
		.when(cadastroAutoresRepository.getById(formDto.getCadastroAutorId()))
		.thenThrow(EntityNotFoundException.class);
		
		assertThrows(IllegalArgumentException.class,() -> service.cadastrar(formDto));
		
	}

}
