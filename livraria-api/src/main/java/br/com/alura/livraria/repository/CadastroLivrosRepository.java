package br.com.alura.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livraria.dto.ItemLivrariaDto;
import br.com.alura.livraria.modelo.CadastroLivros;

public interface CadastroLivrosRepository extends JpaRepository<CadastroLivros, Long> {
	
	@Query("select new br.com.alura.livraria.dto.ItemLivrariaDto("
			+ "a.nome, "
			+ "count(l), "
			+ "(count(l) * 1.0 / (select count(l2) * 1.0 from CadastroLivros l2))) "
			+ "from CadastroLivros l "
			+ "join l.cadastroAutor a "
			+ "group by a.nome")
	
	List<ItemLivrariaDto> relatorioQuantidadeLivros();

	
}
