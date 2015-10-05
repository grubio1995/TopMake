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
	
	@Override
	public String toString() {
		return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		GenericDomain other = (GenericDomain) obj;
		
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		}
		else if (!codigo.equals(other.codigo)) {
			return false;
		}
		
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
