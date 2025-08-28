package br.com.senac.api.service;

import br.com.senac.api.dto.PessoaRequestDTO;
import br.com.senac.api.model.Pessoa;
import br.com.senac.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa criar(PessoaRequestDTO pessoa) {

        Pessoa pessoaPersist = this.pessoaRequestDTOParaPessoa(pessoa);
        pessoaPersist.setNome(pessoa.getNome());
        pessoaPersist.setSobrenome(pessoa.getSobrenome());

        return pessoaRepository.save(pessoaPersist);

    }

    public Pessoa atualizar (Long id, PessoaRequestDTO pessoa) throws Exception {
        if (!pessoaRepository.existsById(id)) {
            throw new RuntimeException("Registro não encontrado");
        }

        Pessoa pessoaPersist = this.pessoaRequestDTOParaPessoa(pessoa);

        pessoaPersist.setId(id);

        return pessoaRepository.save(pessoaPersist);

    }

    private Pessoa pessoaRequestDTOParaPessoa(PessoaRequestDTO in){
        Pessoa out = new Pessoa();
        out.setNome(in.getNome());
        out.setSobrenome(in.getSobrenome());

        return out;
    }

}
