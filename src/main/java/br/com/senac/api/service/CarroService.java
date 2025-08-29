package br.com.senac.api.service;

import br.com.senac.api.dto.CarroRequestDTO;
import br.com.senac.api.model.Carro;
import br.com.senac.api.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public Carro criar(CarroRequestDTO carro) {
        Carro carroPersist = new Carro();
        carroPersist.setMarca(carro.getMarca());
        carroPersist.setModelo(carro.getModelo());

        return carroRepository.save(carroPersist);
    }

    public Carro atualizar(Long id, CarroRequestDTO carro) throws Exception {
        if(carroRepository.existsById(id) == false) {
            throw new Exception("Registro não encontrado");
        }

        Carro carroPersist = new Carro();
        carroPersist.setModelo(carro.getModelo());
        carroPersist.setMarca(carro.getMarca());
        carroPersist.setId(id);

        return carroRepository.save(carroPersist);

    }

    public void deletar(Long id) {
        if (!carroRepository.existsById(id)) {
            throw new RuntimeException("Registro não encontrado");
        }

        carroRepository.deleteById(id);
    }

    private Carro carroRequestDTOParaCarro(CarroRequestDTO in){
        Carro out = new Carro();
        out.setMarca(in.getMarca());
        out.setModelo(in.getModelo());

        return out;

    }

}
