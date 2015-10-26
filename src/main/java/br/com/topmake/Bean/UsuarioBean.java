package br.com.topmake.Bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.topmake.dao.UsuarioDAO;
import br.com.topmake.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	
	private Usuario usuario;
	private List<Usuario>usuarios;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void salvar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			usuario.setTipoUsuario('C'); // fixo pois os usuários cadastrados são somente clientes, só haverá uma revendedora que será a Carol
			usuarioDAO.merge(usuario);
			
			usuario = new Usuario();
			usuarios = usuarioDAO.listar();

			Messages.addGlobalInfo("Usuário salvo com sucesso");
			
			novo();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuário");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		usuario = new Usuario();
	}
	
	@PostConstruct
	public void listar(){
		
		try{
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os usuários");
		}
	}
	
	public void excluir(ActionEvent evento){
		
		try{
			
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);

			usuario = new Usuario();
			usuarios = usuarioDAO.listar();

			Messages.addGlobalInfo("Usuário excluído com sucesso");
			
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o usuário");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){

		try{

			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar editar o usuário");
			erro.printStackTrace();
		}
	}
	
}
