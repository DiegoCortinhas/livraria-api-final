package br.com.alura.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livraria.dto.CadastroLivrosDto;
import br.com.alura.livraria.dto.CadastroLivrosFormDto;
import br.com.alura.livraria.modelo.CadastroLivros;

@Service
public class CadastroLivrosService {
	
	private List<CadastroLivros> cadastros = new ArrayList();
	private ModelMapper modelMapper = new ModelMapper();

	public List<CadastroLivrosDto> listar() {
		return cadastros
				.stream()
				.map(c -> modelMapper.map(c, CadastroLivrosDto.class))
				.collect(Collectors.toList());
	}

	public void cadastrar(@Valid CadastroLivrosFormDto dto) {
		CadastroLivros cadastro = modelMapper.map(dto, CadastroLivros.class);
		cadastros.add(cadastro);
	}
	
}
