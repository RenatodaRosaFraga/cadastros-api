package br.com.senac.api.controller;

import br.com.senac.api.model.Pessoa;
import br.com.senac.api.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pessoa> listar() {
        return service.findAll();
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return service.save(pessoa);
    }
}
