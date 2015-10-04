package br.com.topmake.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import br.com.topmake.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAO<Entidade> {
	
	//Classe atual.
	private Class<Entidade> classe;
	
	//Verificar qual entidade está acessando a classe.
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}	
	
	//Salvar um registro.
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		}
		catch(RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		}
		finally {
			sessao.close();
		}
	}
	
	//Listar todos os registros.
	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try{
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		}
		catch(RuntimeException erro) {
			throw erro;
		}
		finally {
			sessao.close();
		}
	}
	
	//Buscar um registro.
	@SuppressWarnings("unchecked")
	public Entidade buscar(Integer intCodigo) {
		Long codigo = intCodigo.longValue();
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		}
		catch(RuntimeException erro) {
			throw erro;
		}
		finally {
			sessao.close();
		}
	}
	
	//Excluir um registro.
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		}
		catch(RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		}
		finally {
			sessao.close();
		}
	}
		
	//Editar um registro.
	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		}
		catch(RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		}
		finally {
			sessao.close();
		}
		
		
	}
	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
