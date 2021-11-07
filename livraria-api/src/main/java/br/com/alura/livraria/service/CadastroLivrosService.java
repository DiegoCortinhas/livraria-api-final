package br.com.alura.livraria.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.livraria.dto.CadastroLivrosDto;
import br.com.alura.livraria.dto.CadastroLivrosFormDto;
import br.com.alura.livraria.modelo.CadastroLivros;
import br.com.alura.livraria.repository.CadastroLivrosRepository;

@Service
public class CadastroLivrosService {
	
	@Autowired
	private CadastroLivrosRepository cadastroLivrosRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public List<CadastroLivrosDto> listar() {
		List<CadastroLivros> cadastroLivros = cadastroLivrosRepository.findAll();
		
		return cadastroLivros
				.stream()
				.map(c -> modelMapper.map(c, CadastroLivrosDto.class))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public void cadastrar(@Valid CadastroLivrosFormDto dto) {
		CadastroLivros cadastro = modelMapper.map(dto, CadastroLivros.class);
		cadastro.setId(null);
		cadastroLivrosRepository.save(cadastro);
		
	}
	
}
