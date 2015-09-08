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
		pagamento.setMetodo("Cartao");
		pagamento.setNomeTitular("Erick Luz");
		pagamento.setNumeroAgencia("XXXX-X");
		pagamento.setNumeroCartao("XXXX-XXXX-XXXX-XX");
		pagamento.setNumeroConta("XXXXX-XX");
		pagamento.setSituacao("Pendente");
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		pagamentoDAO.salvar(pagamento);	
	}

	@Test
	public void listar(){
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		List<Pagamento> resultado = pagamentoDAO.listar();
		System.out.println("Registros tabela Pagamento:");
		for(Pagamento pagamento : resultado){
			System.out.println("Metodo:" + pagamento.getMetodo());
			System.out.println("Titular:" + pagamento.getNomeTitular());
			System.out.println("Agencia:" + pagamento.getNumeroAgencia());
			System.out.println("Cartão:" + pagamento.getNumeroCartao());
			System.out.println("Conta:" + pagamento.getNumeroConta());
			System.out.println("Situação:" + pagamento.getSituacao());
			
		}
	}
}
