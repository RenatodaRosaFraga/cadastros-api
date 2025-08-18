package br.com.senac.api.service;

import br.com.senac.api.model.Pessoa;
import br.com.senac.api.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }
}
