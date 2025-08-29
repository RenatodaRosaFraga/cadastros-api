package br.com.senac.api.controller;

import br.com.senac.api.dto.CarroRequestDTO;
import br.com.senac.api.model.Carro;
import br.com.senac.api.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/Listar")
    public ResponseEntity <List<Carro>> listarTodos() {
        return ResponseEntity.ok(carroService.listarTodos());
    }

    @PostMapping("/Criar")
    public ResponseEntity<Carro> criar(@RequestBody CarroRequestDTO carro) {
        try {
            return ResponseEntity.ok(carroService.criar(carro));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    

    @PutMapping("/Atualizar/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable Long id, @RequestBody CarroRequestDTO carro) {

        try {
            return ResponseEntity.ok(carroService.atualizar(id, carro));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/Deletar/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        try {
            carroService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
