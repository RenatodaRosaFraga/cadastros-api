package br.com.senac.api.controller;

import br.com.senac.api.model.Produto;
import br.com.senac.api.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.findAll();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return service.save(produto);
    }
}
