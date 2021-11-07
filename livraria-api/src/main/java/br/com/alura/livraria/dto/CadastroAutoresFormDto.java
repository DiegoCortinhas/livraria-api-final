package br.com.alura.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CadastroAutoresFormDto {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String email;
	
	@Past
	private LocalDate dataNascimento;
	
	@NotBlank
	private String miniCurriculo;
	
		
}
