package br.com.alura.livraria.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livraria.dto.CadastroAutoresDto;
import br.com.alura.livraria.dto.CadastroAutoresFormDto;
import br.com.alura.livraria.modelo.CadastroAutores;
import br.com.alura.livraria.service.CadastroAutoresService;

@RestController
@RequestMapping("/autores")
public class CadastroAutoresController {
	
	@Autowired
	private CadastroAutoresService service;
	
	@GetMapping
	public List <CadastroAutoresDto> listar(){
		return service.listar();
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid CadastroAutoresFormDto dto) {
		service.cadastrar(dto);
	}
}
