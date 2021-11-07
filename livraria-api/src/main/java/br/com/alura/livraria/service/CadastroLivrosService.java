package br.com.alura.livraria.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public Page<CadastroLivrosDto> listar(Pageable paginacao) {
		Page<CadastroLivros> cadastroLivros = cadastroLivrosRepository.findAll(paginacao);
		return cadastroLivros.map(c -> modelMapper.map(c, CadastroLivrosDto.class));
	}
	
	@Transactional
	public void cadastrar(@Valid CadastroLivrosFormDto dto) {
		CadastroLivros cadastro = modelMapper.map(dto, CadastroLivros.class);
		cadastro.setId(null);
		cadastroLivrosRepository.save(cadastro);
		
	}
	
}
