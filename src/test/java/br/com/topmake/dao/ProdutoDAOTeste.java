package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Produto;
import br.com.topmake.domain.Linha;
import br.com.topmake.domain.Categoria;

public class ProdutoDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		Produto produto = new Produto();
		produto.setCor("Verde");
		produto.setDescricao("Novo");
		produto.setNome("Vi ai Pi");
		BigDecimal bd = new BigDecimal(12.2);
		produto.setPreco(bd);
		Short s = 12;
		produto.setQtd(s);
		s = 6;
		produto.setQtdMinima(s);
		Linha linha = new Linha();
		produto.setLinha(linha);
		Categoria categoria = new Categoria();
		produto.setCategoria(categoria);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);	
	}

	@Test
	public void listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		System.out.println("Registros tabela Produtos:");
		for(Produto produto : resultado){
			System.out.println("Nome:" + produto.getNome());
			System.out.println("Descrição:" + produto.getDescricao());
			System.out.println("Cor:" + produto.getCor());
			System.out.println("Quantidade:" + produto.getQtd());
			System.out.println("Qtd Minima:" + produto.getQtdMinima());
			System.out.println("Preço:" + produto.getPreco());
			
		}
	}
}
