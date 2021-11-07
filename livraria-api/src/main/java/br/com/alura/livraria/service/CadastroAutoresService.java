package br.com.alura.livraria.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.livraria.dto.CadastroAutoresDto;
import br.com.alura.livraria.dto.CadastroAutoresFormDto;
import br.com.alura.livraria.modelo.CadastroAutores;
import br.com.alura.livraria.repository.CadastroAutoresRepository;

@Service
public class CadastroAutoresService {
	
	@Autowired
	private CadastroAutoresRepository cadastroAutoresRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
		
	public List<CadastroAutoresDto> listar() {
		List<CadastroAutores> cadastroAutores = cadastroAutoresRepository.findAll();
		
		return cadastroAutores
				.stream()
				.map(c -> modelMapper.map(c, CadastroAutoresDto.class))
				.collect(Collectors.toList());
		
	}

	public void cadastrar(@Valid CadastroAutoresFormDto dto) {
		CadastroAutores cadastro = modelMapper.map(dto,CadastroAutores.class);
		
		cadastroAutoresRepository.save(cadastro);
		
	}
	
}
