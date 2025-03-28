package br.com.eduardobezerra.desafio_simplify.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.eduardobezerra.desafio_simplify.entity.Categoria;
import br.com.eduardobezerra.desafio_simplify.repository.CategoriaRepository;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    // Injetando dependencia via construtor
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> criarCategorias(List<Categoria> categorias) {
        return categoriaRepository.saveAll(categorias);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria atualizarCategoria(Categoria categoriaAtualizada) {
        return categoriaRepository.save(categoriaAtualizada);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}