package br.com.senac.api.service;

import br.com.senac.api.model.Produto;
import br.com.senac.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }
}
