package com.dev.todolist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.todolist.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {}
