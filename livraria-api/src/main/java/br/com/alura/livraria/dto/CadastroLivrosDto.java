package br.com.alura.livraria.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CadastroLivrosDto {
	private String titulo;
	private LocalDate dataLancamento;
	private int numeroPaginas;
	private CadastroAutoresDto autor;
}
