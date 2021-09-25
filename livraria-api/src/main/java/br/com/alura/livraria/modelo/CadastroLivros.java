package br.com.alura.livraria.modelo;

import java.time.LocalDate;

import br.com.alura.livraria.dto.CadastroAutoresDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CadastroLivros {
	
	private String titulo;
	private LocalDate dataLancamento;
	private int numeroPaginas;
	private CadastroAutoresDto autor;
	
	
}
