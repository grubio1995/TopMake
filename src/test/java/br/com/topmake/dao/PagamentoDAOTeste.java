package br.com.topmake.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Pagamento;

public class PagamentoDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		Pagamento pagamento = new Pagamento();
		pagamento.setMetodo("TESTE");
		pagamento.setNomeTitular("Ze TESTE");
		pagamento.setNumeroAgencia("AAAAA-A");
		pagamento.setNumeroCartao("TESTE-TESTE-TESTE-AA");
		pagamento.setNumeroConta("TESTE-SS");
		pagamento.setSituacao("TESTE");

		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		pagamentoDAO.salvar(pagamento);	
	}

	@Test
	@Ignore
	public void listar(){
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		List<Pagamento> resultado = pagamentoDAO.listar();
		System.out.println("Registros tabela Pagamento:");
		for(Pagamento pagamento : resultado){
			System.out.println("==============================================");
			System.out.println("Metodo:" + pagamento.getMetodo());
			System.out.println("Titular:" + pagamento.getNomeTitular());
			System.out.println("Agencia:" + pagamento.getNumeroAgencia());
			System.out.println("Cartão:" + pagamento.getNumeroCartao());
			System.out.println("Conta:" + pagamento.getNumeroConta());
			System.out.println("Situação:" + pagamento.getSituacao());
			System.out.println("==============================================");
		}
	}
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 3L;
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		Pagamento pagamento = pagamentoDAO.buscar(codigo);
		
		if(pagamento == null){
			System.out.println("Nenhum pagamento encontrado");
		}else{
			System.out.println("Pagamento encontrado:");
			System.out.println(pagamento.getCodigo() + " - " + pagamento.getMetodo() +
		 " - " + pagamento.getSituacao() + " - " + pagamento.getNomeTitular() + " - " 
		 + pagamento.getNumeroCartao() + " - " +
		 " - " + pagamento.getNumeroConta() + " - " + pagamento.getNumeroAgencia());
		}
	}

	@Test
	@Ignore
	public void excluir(){
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		Pagamento pagamento = pagamentoDAO.buscar(3L);

		if(pagamento == null){
			System.out.println("Nenhum pagamento encontrado");
		}else{
			System.out.println("Pagamento removido:");
			System.out.println(pagamento.getCodigo() + " - " + pagamento.getMetodo() +
		 " - " + pagamento.getSituacao() + " - " + pagamento.getNomeTitular() + " - " 
		 + pagamento.getNumeroCartao() + " - "  +
		 " - " + pagamento.getNumeroConta() + " - " + pagamento.getNumeroAgencia());
		}

		pagamentoDAO.excluir(pagamento);

	}

	@Test
	@Ignore
	public void editar(){
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		Pagamento pagamento = pagamentoDAO.buscar(4L);
		
		if(pagamento == null){
			System.out.println("Nenhum pagamento encontrado");
		}else{
			System.out.println("Pagamento a ser editado");
			System.out.println(pagamento.getCodigo() + " - " + pagamento.getMetodo() +
		 " - " + pagamento.getSituacao() + " - " + pagamento.getNomeTitular() + " - " 
		 + pagamento.getNumeroCartao() + " - " +
		 " - " + pagamento.getNumeroConta() + " - " + pagamento.getNumeroAgencia());

			pagamento.setMetodo("Cartao");
			pagamento.setSituacao("Ativo");
			pagamento.setNomeTitular("Carol");
			pagamento.setNumeroCartao("756896087990");
			pagamento.setNumeroConta("34567");
			pagamento.setNumeroAgencia("0907");
			pagamentoDAO.editar(pagamento);

		}	
	}
		
}
