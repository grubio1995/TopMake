package br.com.topmake.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Compra;

public class CompraDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		Compra compra = new Compra();
		Date d = new Date();
		compra.setDataCompra(d);
		BigDecimal bd = new BigDecimal(150.0);
		compra.setPrecoTotal(bd);
		CompraDAO compraDAO = new CompraDAO();
		compraDAO.salvar(compra);	
	}

	@Test
	@Ignore
	public void listar(){
		CompraDAO compraDAO = new CompraDAO();
		List<Compra> resultado = compraDAO.listar();
		System.out.println("Registros tabela Compras:");
		for(Compra compra : resultado){
			System.out.println("==========================================");
			System.out.println("Bairro:" + compra.getDataCompra());	
			System.out.println("Celular:" + compra.getPrecoTotal());	
			System.out.println("==========================================");
		}
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 3L;
		
		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.buscar(codigo);
		if(compra == null){
			System.out.println("Nenhuma Compra encontrada");
		}else{
			System.out.println("Data da compra: " + compra.getDataCompra());
			System.out.println("Preço Total: " + compra.getPrecoTotal());
		}
	
	}
	
	
	@Test
	@Ignore
	public void excluir(){
		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.buscar(4L);
		
		compraDAO.excluir(compra);
		System.out.println("Compra Excluida");
		System.out.println("Data da compra: " + compra.getDataCompra());
		System.out.println("Preço Total: " + compra.getPrecoTotal());
	
	}
	
	@Test
	@Ignore
	public void editar(){

		CompraDAO compraDAO = new CompraDAO();
		Compra compra = compraDAO.buscar(3L);
				
		System.out.println("Compra a ser editado");
		System.out.println("Data da compra: " + compra.getDataCompra());
		System.out.println("Preço Total: " + compra.getPrecoTotal());
		
		Date d = new Date();
		compra.setDataCompra(d);
		BigDecimal b = new BigDecimal(1200.00);
		compra.setPrecoTotal(b);
		compraDAO.editar(compra);

		System.out.println("Compra editado");

	}	
}
