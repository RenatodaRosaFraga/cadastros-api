package br.com.senac.api.controller;

import br.com.senac.api.dto.ProdutoRequestDTO;
import br.com.senac.api.model.Carro;
import br.com.senac.api.model.Produto;
import br.com.senac.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/Listar")
    public ResponseEntity <List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @PostMapping("Criar")
    public ResponseEntity<Produto> criar(@RequestBody ProdutoRequestDTO produto) {
        try {
            return ResponseEntity.ok(produtoService.criar(produto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/Atualizar/{id}")
    public ResponseEntity<Produto> atualizar (@PathVariable Long id, @RequestBody ProdutoRequestDTO produto) {

        try {
            return ResponseEntity.ok(produtoService.atualizar(id, produto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @DeleteMapping("Deletar/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        try {
            produtoService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
