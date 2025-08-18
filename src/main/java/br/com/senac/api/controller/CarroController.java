package br.com.senac.api.controller;

import br.com.senac.api.model.Carro;
import br.com.senac.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Carro> listar() {
        return service.findAll();
    }

    @PostMapping
    public Carro criar(@RequestBody Carro carro) {
        return service.save(carro);
    }
}
