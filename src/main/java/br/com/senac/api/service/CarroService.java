package br.com.senac.api.service;

import br.com.senac.api.model.Carro;
import br.com.senac.api.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public List<Carro> findAll() {
        return repository.findAll();
    }

    public Carro save(Carro carro) {
        return repository.save(carro);
    }
}
