package br.com.alura.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livraria.dto.CadastroAutoresDto;
import br.com.alura.livraria.dto.CadastroAutoresFormDto;
import br.com.alura.livraria.dto.CadastroLivrosDto;
import br.com.alura.livraria.dto.CadastroLivrosFormDto;
import br.com.alura.livraria.service.CadastroAutoresService;
import br.com.alura.livraria.service.CadastroLivrosService;

@RestController
@RequestMapping("/livros")
public class CadastroLivrosController {
	
	@Autowired
	private CadastroLivrosService service;
	
	
	@GetMapping
	public List <CadastroLivrosDto> listar(){
		return service.listar();
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid CadastroLivrosFormDto dto) {
		service.cadastrar(dto);
	}
		
	
}
