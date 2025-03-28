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

    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria atualizarCategoria(Long id, Categoria categoriaAtualizada) {
        return categoriaRepository.findById(id)
            .map(categoriaExistente -> {
                categoriaExistente.setNome(categoriaAtualizada.getNome());
                categoriaExistente.setDescricao(categoriaAtualizada.getDescricao());
                return categoriaRepository.save(categoriaExistente);
            })
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}