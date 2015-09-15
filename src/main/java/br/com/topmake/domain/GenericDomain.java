package br.com.topmake.domain;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") //Ignorar aviso.
@MappedSuperclass //Não gerar tabela.
public class GenericDomain implements Serializable {
	@Id //Chave primária.
	@GeneratedValue(strategy = GenerationType.AUTO) //Controle automático de ID no BD.
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
