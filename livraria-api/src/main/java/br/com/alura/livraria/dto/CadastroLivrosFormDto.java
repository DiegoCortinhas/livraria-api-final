package br.com.alura.livraria.dto;


import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.modelmapper.internal.bytebuddy.asm.Advice.AllArguments;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CadastroLivrosFormDto {
	
	@NotBlank 
	@Size(min = 10)
	private String titulo;
	
	@PastOrPresent
	private LocalDate dataLancamento;
	
	@NotNull
	@Min(100)
	private Integer numeroPaginas;
	
	/*
	@NotNull
	private CadastroAutoresDto autor;
	*/
	
	@JsonAlias("cadastro_autor_id")
	private Long cadastroAutorId;
	
}
