package com.dev.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.todolist.entity.Produto;
import com.dev.todolist.service.ProdutoService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    List <Produto> create(@RequestBody Produto produto){
        return produtoService.create(produto);
    }
    @GetMapping
    List <Produto> read(){
        return produtoService.read();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable String id) {
        return produtoService.getById(id);
    }


    @PutMapping
    List <Produto> update(@RequestBody Produto produto){
        return produtoService.update(produto);
    }
    @DeleteMapping("{id}")
    List <Produto> delete(@PathVariable String id){
        return produtoService.delete(id);
    }
    
}
