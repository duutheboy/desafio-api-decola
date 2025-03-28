package br.com.eduardobezerra.desafio_simplify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eduardobezerra.desafio_simplify.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
