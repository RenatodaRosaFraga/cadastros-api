package br.com.senac.api.service;

import br.com.senac.api.dto.ProdutoRequestDTO;
import br.com.senac.api.model.Produto;
import br.com.senac.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto criar (ProdutoRequestDTO produto) {
        Produto produtoPersist = new Produto();
        produtoPersist.setNome(produto.getNome());
        produtoPersist.setDescricao(produto.getDescricao());

        return produtoRepository.save(produtoPersist);

    }

    public Produto atualizar(Long id, ProdutoRequestDTO produto) throws Exception {
        if (produtoRepository.existsById(id) == false) {
            throw new Exception("Registro não encontrado");
        }

        Produto produtoPersist = new Produto();
        produtoPersist.setNome(produto.getNome());
        produtoPersist.setDescricao(produto.getDescricao());
        produtoPersist.setId(id);

        return produtoRepository.save(produtoPersist);
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)){
            throw new RuntimeException("Registro não encontrado");
        }

        produtoRepository.deleteById(id);

    }

    private Produto produtoRequestDTOParaProduto(ProdutoRequestDTO in){
        Produto out = new Produto();
        out.setDescricao(in.getNome());
        out.setNome(in.getNome());

        return out;
    }

}
