package br.com.alura.livraria.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		
	public Page<CadastroAutoresDto> listar(Pageable paginacao) {
		Page<CadastroAutores> cadastroAutores = cadastroAutoresRepository.findAll(paginacao);
		
		return cadastroAutores
				.map(c -> modelMapper.map(c, CadastroAutoresDto.class));
		
	}

	public void cadastrar(@Valid CadastroAutoresFormDto dto) {
		CadastroAutores cadastro = modelMapper.map(dto,CadastroAutores.class);
		
		cadastroAutoresRepository.save(cadastro);
		
	}
	
}
