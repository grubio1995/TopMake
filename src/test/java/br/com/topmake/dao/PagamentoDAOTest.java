package br.com.topmake.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import br.com.topmake.domain.Pagamento;

public class PagamentoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		String pagamentoMetodo = "Boleto";
		String pagamentoNomeTitular = "Teste de nome de titular";
		String pagamentoNumeroAgencia = "1033-2";
		String pagamentoNumeroCartao = "1234567890123456";
		String pagamentoNumeroConta = "1234-5";
		String pagamentoSituacao = "Aprovado";
		
		Pagamento pagamento = new Pagamento();
		pagamento.setMetodo(pagamentoMetodo);
		pagamento.setNomeTitular(pagamentoNomeTitular);
		pagamento.setNumeroAgencia(pagamentoNumeroAgencia);
		pagamento.setNumeroCartao(pagamentoNumeroCartao);
		pagamento.setNumeroConta(pagamentoNumeroConta);
		pagamento.setSituacao(pagamentoSituacao);
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		pagamentoDAO.salvar(pagamento);
		System.out.println("Pagamento salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar(){
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		List<Pagamento> resultado = pagamentoDAO.listar();
		
		System.out.println("Total de pagamentos encontrados: " + resultado.size());
		
		for(Pagamento pagamento : resultado) {
			System.out.println(pagamento.getCodigo() + " - " + pagamento.getMetodo()
				+ " - " + pagamento.getSituacao() + " - " + pagamento.getNomeTitular()
				+ " - " + pagamento.getNumeroCartao() + " - " + pagamento.getNumeroConta()
				+ " - " + pagamento.getNumeroAgencia());
		}
	}
	@Test
	@Ignore
	public void buscar() {
		Integer pagamentoCodigo = 3;
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		Pagamento pagamento = pagamentoDAO.buscar(pagamentoCodigo);
		
		if (pagamento == null) {
			System.out.println("Nenhum pagamento encontrado!");
		}
		else {
			System.out.println("Pagamento encontrado!");
			System.out.println(pagamento.getCodigo() + " - " + pagamento.getMetodo()
				+ " - " + pagamento.getSituacao() + " - " + pagamento.getNomeTitular()
				+ " - " + pagamento.getNumeroCartao() + " - " + pagamento.getNumeroConta()
				+ " - " + pagamento.getNumeroAgencia());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Integer pagamentoCodigo = 3;
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		Pagamento pagamento = pagamentoDAO.buscar(pagamentoCodigo);

		if (pagamento == null) {
			System.out.println("Nenhum pagamento encontrado!");
		}
		else {
			pagamentoDAO.excluir(pagamento);
			System.out.println("Pagamento removido com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Integer pagamentoCodigo = 4;
		String pagamentoMetodo = "Cartão";
		String pagamentoNomeTitular = "Carol";
		String pagamentoNumeroCartao = "1234567812345678";
		String pagamentoNumeroConta = "1234-5";
		String pagamentoNumeroAgencia = "0907";
		String pagamentoSituacao = "Reprovado";
		
		PagamentoDAO pagamentoDAO = new PagamentoDAO();
		Pagamento pagamento = pagamentoDAO.buscar(pagamentoCodigo);
		
		if (pagamento == null) {
			System.out.println("Nenhum pagamento encontrado!");
		}
		else {
			pagamento.setMetodo(pagamentoMetodo);
			pagamento.setNomeTitular(pagamentoNomeTitular);
			pagamento.setNumeroCartao(pagamentoNumeroCartao);
			pagamento.setNumeroConta(pagamentoNumeroConta);
			pagamento.setNumeroAgencia(pagamentoNumeroAgencia);
			pagamento.setSituacao(pagamentoSituacao);
			
			pagamentoDAO.editar(pagamento);
			System.out.println("Pagamento editado com sucesso!");
		}	
	}
		
}
