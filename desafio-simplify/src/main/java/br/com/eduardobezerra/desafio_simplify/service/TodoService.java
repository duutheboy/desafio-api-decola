package br.com.eduardobezerra.desafio_simplify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.eduardobezerra.desafio_simplify.entity.Todo;
import br.com.eduardobezerra.desafio_simplify.repository.TodoRepository;

@Service // Passivo de injeção
public class TodoService {
    private TodoRepository todoRepository;


    // Injetando dependencia via construtor
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Após qualquer operação : Retorna a lista de tarefas

    public List<Todo> create(List<Todo> todo){
        todoRepository.saveAll(todo);
        return list();
    }

    public List<Todo> list()  {
        Sort sort = Sort.by(Sort.Order.desc("prioridade")).and(Sort.by(Sort.Order.asc("nome")));
        return todoRepository.findAll(sort);
    }

    public Optional<Todo> buscarTodoPorId(Long id) {
        return todoRepository.findById(id);
    }


    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}
