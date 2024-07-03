package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository ProdutoRepository;

    public Produto criarProduto(Produto produto) {
        return ProdutoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return ProdutoRepository.findAll();
    }

    public Optional<Produto> consultarProduto(Integer id) {
        return ProdutoRepository.findById(id);
    }

    public Produto atualizarProduto(Integer id, Produto produto) {
        Optional<Produto> produtoExistente = ProdutoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            Produto prod = produtoExistente.get();
            prod.setNome(produto.getNome());
            prod.setPreco(produto.getPreco());
            return ProdutoRepository.save(prod);
        }
        return null;
    }

    public void excluirProduto(Integer id) {
        ProdutoRepository.deleteById(id);
    }
}
