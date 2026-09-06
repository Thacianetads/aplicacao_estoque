package com.dev.todolist.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

@Document(collection = "estoque")
public class Produto {
    @Id
    private String id;
    private String nome;
    private String codigo;
    private int estoque;
    private String fornecedor;
    private BigDecimal preco;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getnome() {
        return nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
    public String getcodigo(){
        return codigo;
    }
    public void setcodigo(String codigo){
        this.codigo = codigo;
    }
    public int getestoque(){
        return estoque;
    }
    public void setestoque(int estoque){
        this.estoque = estoque;
    }
    public String getfornecedor(){
        return fornecedor;
    }
    public void setfornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }
    public BigDecimal getpreco(){
        return preco;
    }
    public void setpreco(BigDecimal preco){
        this.preco = preco;
    }
}
