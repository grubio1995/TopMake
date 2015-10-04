package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Produto;
import br.com.topmake.domain.Linha;
import br.com.topmake.domain.Categoria;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Integer linhaCodigo = 2;
		Integer categoriaCodigo = 2;
		BigDecimal produtoPrecoVenda = new BigDecimal(999.99);
		String produtoNome = "Maquiagem";
		String produtoDescricao = "Maquiagem para o rosto";
		String produtoCor = "Pele";
		Short produtoQtd = 12;
		Short produtoQtdMinima = 6;
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscar(categoriaCodigo);
		
		if (categoria == null) {
			System.out.println("Nenhuma categoria encontrado!");
		}
		else {
			LinhaDAO linhaDAO = new LinhaDAO();
			Linha linha = linhaDAO.buscar(linhaCodigo);
			
			if (linha == null) {
				System.out.println("Nenhuma linha encontrado!");
			}
			else {
				Produto produto = new Produto();
				produto.setNome(produtoNome);
				produto.setDescricao(produtoDescricao);
				produto.setCor(produtoCor);
				produto.setPrecoVenda(produtoPrecoVenda);
				produto.setCategoria(categoria);
				produto.setLinha(linha);
				produto.setQtd(produtoQtd);
				produto.setQtdMinima(produtoQtdMinima);
				
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoDAO.salvar(produto);
				System.out.println("Produto salvo com sucesso!");
			}			
		}
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		
		System.out.println("Total de produtos encontrados: " + resultado.size());
		
		for(Produto produto : resultado) {
			System.out.println("=================================================");
			System.out.println("Código do produto: " + produto.getCodigo());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Cor: " + produto.getCor());
			System.out.println("Preço: " + produto.getPrecoVenda());
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Quantidade: " + produto.getQtd());
			System.out.println("Quantidade mínima: " + produto.getQtdMinima());
			System.out.println("Categoria: " + produto.getCategoria().getCodigo());
			System.out.println("Linha: " + produto.getLinha().getCodigo());
			System.out.println("=================================================");
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Integer produtoCodigo = 2;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(produtoCodigo);
		
		if (produto == null) {
			System.out.println("Nenhum produto encontrado!");
		}
		else {
			System.out.println("Código do produto: " + produto.getCodigo());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Cor: " + produto.getCor());
			System.out.println("Preço: " + produto.getPrecoVenda());
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Quantidade: " + produto.getQtd());
			System.out.println("Quantidade mínima: " + produto.getQtdMinima());
			System.out.println("Categoria: " + produto.getCategoria().getCodigo());
			System.out.println("Linha: " + produto.getLinha().getCodigo());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Integer produtoCodigo = 3;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(produtoCodigo);
		
		if (produto == null) {
			System.out.println("Nenhum produto encontrado!");
		}
		else {
			produtoDAO.excluir(produto);
			System.out.println("Produto removido com sucesso!");			
		}		
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer produtoCodigo = 2;
		Integer categoriaCodigo = 2;
		Integer linhaCodigo = 2;
		String produtoNome = "Base em pó";
		String produtoCor = "Verde";
		String produtoDescricao = "Com cheiro";
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(produtoCodigo);
		
		if (produto == null) {
			System.out.println("Nenhum produto encontrado!");
		}
		else {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			Categoria categoria = categoriaDAO.buscar(categoriaCodigo);		
			
			if (categoria == null) {
				System.out.println("Nenhuma categoria encontrado!");
			}
			else {
				LinhaDAO linhaDAO = new LinhaDAO();
				Linha linha = linhaDAO.buscar(linhaCodigo);
				
				if (linha == null) {
					System.out.println("Nenhuma linha encontrado!");
				}
				else {
					produto.setNome(produtoNome);
					produto.setCor(produtoCor);
					produto.setDescricao(produtoDescricao);		
					produto.setCategoria(categoria);
					produto.setLinha(linha);
					
					produtoDAO.editar(produto);
					System.out.println("Produto editado com sucesso!");				
				}
			}
			
		}
		
	}	
	
}
