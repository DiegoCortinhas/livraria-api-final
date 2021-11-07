package br.com.alura.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.livraria.modelo.CadastroLivros;

public interface CadastroLivrosRepository extends JpaRepository<CadastroLivros, Long> {

	
}
