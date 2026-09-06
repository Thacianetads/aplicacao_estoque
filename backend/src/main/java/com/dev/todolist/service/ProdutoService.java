package com.dev.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dev.todolist.entity.Produto;
import com.dev.todolist.exception.ProdutoNotFoundException;
import com.dev.todolist.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    
    public List<Produto> create(Produto produto){
        produtoRepository.save(produto);
        return read();
    }

    public List<Produto> read(){
        Sort sort = Sort.by("codigo").descending().and(
            Sort.by("nome").ascending());
        return produtoRepository.findAll(sort);
    }

    public List<Produto> update(Produto produto){
        
        Optional<Produto> existingProduto = produtoRepository.findById(produto.getId());

        if (existingProduto.isPresent()){
            Produto updatedProduto = existingProduto.get();

            // Atualiza apenas os campos que foram enviados
            if(produto.getnome() != null) updatedProduto.setnome(produto.getnome());
             
            // Atualiza o codigo se não for nula
            if (produto.getcodigo() != null) updatedProduto.setcodigo(produto.getcodigo());

            // Salva o Todo atualizado no banco
            produtoRepository.save(updatedProduto);
            return read();
        }else{
            throw new ProdutoNotFoundException("Produto not found with id : "+ produto.getId());
        }

        
    }

    public List<Produto> delete(String id){
        produtoRepository.deleteById(id);
        return read();
    }

    public Produto getById(String id) {

        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("Produto not found with id: " + id));
}
}
