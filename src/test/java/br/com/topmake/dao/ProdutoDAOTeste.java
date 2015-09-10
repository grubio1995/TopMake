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
	//@Ignore
	public void salvar(){
		Produto produto = new Produto();
		produto.setCor("TESTE");
		produto.setDescricao("TESTE");
		produto.setNome("TESTE");
		BigDecimal bd = new BigDecimal(999.99);
		produto.setPreco(bd);
		Short s = 12;
		produto.setQtd(s);
		s = 6;
		produto.setQtdMinima(s);
		LinhaDAO linhaDAO = new LinhaDAO();
		Linha linha = linhaDAO.buscar(2L);
		produto.setLinha(linha);
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(2L);
		produto.setCategoria(categoria);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);	
	}

	@Test
	@Ignore
	public void listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		System.out.println("Registros tabela Produtos:");
		for(Produto produto : resultado){
			System.out.println("=================================================");
			System.out.println("Nome:" + produto.getNome());
			System.out.println("Descrição:" + produto.getDescricao());
			System.out.println("Cor:" + produto.getCor());
			System.out.println("Quantidade:" + produto.getQtd());
			System.out.println("Qtd Minima:" + produto.getQtdMinima());
			System.out.println("Preço:" + produto.getPreco());
			System.out.println("=================================================");
		}
	}

	@Test
	@Ignore
	public void buscar(){
		Long codigo = 2L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		if(produto == null){
			System.out.println("Nenhum produto encontrado");
		}else{
			System.out.println("Código do produto: " + produto.getCodigo());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Cor: " + produto.getCor());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Quantidade: " + produto.getQtd());
			System.out.println("Quantidade minima: " + produto.getQtdMinima());
			System.out.println("Categoria: " + produto.getCategoria().getCodigo());
			System.out.println("Linha: " + produto.getLinha().getCodigo());
		}
	}

	@Test
	@Ignore
	public void excluir(){

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(3L);
		produtoDAO.excluir(produto);

		System.out.println("Produto removido");
		System.out.println("Código do produto: " + produto.getCodigo());
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Cor: " + produto.getCor());
		System.out.println("Preço: " + produto.getPreco());
		System.out.println("Descrição: " + produto.getDescricao());
		System.out.println("Quantidade: " + produto.getQtd());
		System.out.println("Quantidade minima: " + produto.getQtdMinima());
		System.out.println("Categoria: " + produto.getCategoria().getCodigo());
		System.out.println("Linha: " + produto.getLinha().getCodigo());
		
	}
	
	@Test
	@Ignore
	public void editar(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(2L);

		System.out.println("Produto a ser editado");
		System.out.println("Código do produto: " + produto.getCodigo());
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Cor: " + produto.getCor());
		System.out.println("Preço: " + produto.getPreco());
		System.out.println("Descrição: " + produto.getDescricao());
		System.out.println("Quantidade: " + produto.getQtd());
		System.out.println("Quantidade minima: " + produto.getQtdMinima());
		System.out.println("Categoria: " + produto.getCategoria().getDescricao());
		System.out.println("Linha: " + produto.getLinha().getClassificacao());

		produto.setNome("Base em pó");
		produto.setCor("Verde");
		produto.setDescricao("Com cheiro");
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(2L);
		produto.setCategoria(categoria);
		LinhaDAO linhaDAO = new LinhaDAO();
		Linha linha = linhaDAO.buscar(2L);
		produto.setLinha(linha);
		produtoDAO.editar(produto);	
		System.out.println("Produto editado");
	
	}
	
}
