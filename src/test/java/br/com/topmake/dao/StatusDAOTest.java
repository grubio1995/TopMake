package br.com.topmake.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.topmake.domain.Status;

public class StatusDAOTest {
	@Test
	@Ignore
	public void salvar() {
		String statusDescricao = "Aguardando pagamento";
		
		Status status = new Status();
		status.setDescricao(statusDescricao);
		
		StatusDAO statusDAO = new StatusDAO();
		statusDAO.Salvar(status);
		System.out.println("Status salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void listar() {
		StatusDAO statusDAO = new StatusDAO();
		List<Status> resultado = statusDAO.Listar();
		
		System.out.println("Total de status encontrados: " + resultado.size());
		
		for (Status status : resultado) {
			System.out.println(status.getCodigo() + " - " + status.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Integer statusCodigo = 1;
		
		StatusDAO statusDAO = new StatusDAO();
		Status status = statusDAO.Buscar(statusCodigo);
		
		if (status == null) {
			System.out.println("Nenhum status encontrado!");
		}
		else {
			System.out.println("Status encontrado!");
			System.out.println(status.getCodigo() + " - " + status.getDescricao());
		}
		
	}
	
	@Test
	@Ignore
	public void excluir() {
		Integer statusCodigo = 1;
		
		StatusDAO statusDAO = new StatusDAO();
		Status status = statusDAO.Buscar(statusCodigo);
		
		if (status == null) {
			System.out.println("Nenhum status encontrado!");
		}
		else {
			statusDAO.Excluir(status);
			System.out.println("Status removido com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Integer statusCodigo = 2;
		String statusDescricao = "Aguardando pagamento";
		
		StatusDAO statusDAO = new StatusDAO();
		Status status = statusDAO.Buscar(statusCodigo);
		
		if (status == null) {
			System.out.println("Nenhum status encontrado!");
		}
		else {
			status.setDescricao(statusDescricao);
			
			statusDAO.Editar(status);
			System.out.println("Status editado com sucesso!");
		}		
	}
}
