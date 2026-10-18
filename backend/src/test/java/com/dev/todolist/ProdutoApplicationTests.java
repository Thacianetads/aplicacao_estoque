package com.dev.todolist;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.todolist.entity.Produto;
import com.dev.todolist.repository.ProdutoRepository;

@SpringBootTest
class ProdutoApplicationTests {

	@Autowired
    private ProdutoRepository produtoRepository;

	@Test
	void cadastrarProduto() throws Exception {
		Produto produto = new Produto();
			produto.setId("1");
        	produto.setnome("Arroz");
        	produto.setcodigo("ABC-001");
        	produto.setestoque(50);
        	produto.setfornecedor("Fornecedor A");
        	produto.setpreco(new BigDecimal("10.50"));

		// Salva o produto e armazena o retorno na variável 'save'
        var save = produtoRepository.save(produto);
        
        System.out.println("Produto salvo com sucesso! ID: " + save.getId());
			
		}

}
