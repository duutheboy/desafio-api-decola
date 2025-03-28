package br.com.eduardobezerra.desafio_simplify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eduardobezerra.desafio_simplify.entity.Categoria;

@Repository // Entidade e o tipo do Id
public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {

}