package com.dev.todolist.exception;

public class ProdutoNotFoundException extends RuntimeException{

    public ProdutoNotFoundException(String message){
        super (message);
    }    
}
