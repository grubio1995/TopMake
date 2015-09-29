package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Compra;

public class CompraDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Compra compra = new Compra();
		Date compraData = new Date();		
		BigDecimal compraPrecoTotal = new BigDecimal(150.0);
		
		compra.setDataCompra(compraData);
		compra.setPrecoTotal(compraPrecoTotal);
		
		CompraDAO compraDAO = new CompraDAO();
		compraDAO.Salvar(compra);
		System.out.println("Compra salva com sucesso!");
	}
	
	@Test
	@Ignore
	public void listar() {
		CompraDAO compraDAO = new CompraDAO();
		List<Compra> resultado = compraDAO.Listar();
		
		System.out.println("Total de compras encontradas: " + resultado.size());
		
		for(Compra compra : resultado) {
			System.out.println(compra.getCodigo() + " - " + compra.getDataCompra() + " - " + compra.getPrecoTotal());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Integer compraCodigo = 3;
		
		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.Buscar(compraCodigo);
		
		if(compra == null) {
			System.out.println("Nenhuma compra encontrada!");
		}
		else {
			System.out.println(compra.getCodigo() + " - " + compra.getDataCompra() + " - " + compra.getPrecoTotal());
		}
	}	
	
	@Test
	@Ignore
	public void excluir() {
		Integer compraCodigo = 4;
		
		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.Buscar(compraCodigo);
		
		if(compra == null) {
			System.out.println("Nenhuma compra encontrada!");
		}
		else {
			compraDAO.Excluir(compra);
			System.out.println("Compra removida com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer compraCodigo = 3;
		Date compraData = new Date();
		BigDecimal compraPrecoTotal = new BigDecimal(1200.00);		
		
		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.Buscar(compraCodigo);
		
		if (compra == null) {
			System.out.println("Nenhuma compra encontrada!");
		}
		else {
			compra.setDataCompra(compraData);
			compra.setPrecoTotal(compraPrecoTotal);
			
			compraDAO.Editar(compra);
			System.out.println("Compra editada com sucesso!");
		}
	}	
}
