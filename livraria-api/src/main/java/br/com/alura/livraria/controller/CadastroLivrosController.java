package br.com.alura.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livraria.dto.CadastroLivrosDto;
import br.com.alura.livraria.dto.CadastroLivrosFormDto;
import br.com.alura.livraria.service.CadastroLivrosService;

@RestController
@RequestMapping("/livros")
public class CadastroLivrosController {
	
	@Autowired
	private CadastroLivrosService service;
	
	
	@GetMapping
	public Page <CadastroLivrosDto> listar(@PageableDefault(size=10) Pageable paginacao){
		return service.listar(paginacao);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid CadastroLivrosFormDto dto) {
		service.cadastrar(dto);
	}
		
	
}
