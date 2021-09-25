package br.com.alura.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livraria.dto.CadastroAutoresDto;
import br.com.alura.livraria.dto.CadastroAutoresFormDto;
import br.com.alura.livraria.modelo.CadastroAutores;

@Service
public class CadastroAutoresService {
	
	private List<CadastroAutores> cadastros = new ArrayList();
	private ModelMapper modelMapper = new ModelMapper();
	
	
	public List<CadastroAutoresDto> listar() {
		return cadastros
				.stream()
				.map(c -> modelMapper.map(c, CadastroAutoresDto.class))
				.collect(Collectors.toList());
		
	}

	public void cadastrar(@Valid CadastroAutoresFormDto dto) {
		CadastroAutores cadastro = modelMapper.map(dto,CadastroAutores.class);
		cadastros.add(cadastro);
		
	}
	
}
