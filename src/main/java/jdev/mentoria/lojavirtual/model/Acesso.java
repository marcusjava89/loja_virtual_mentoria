package jdev.mentoria.lojavirtual.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1, initialValue = 1)
/*Implementa GrantedAuthority, aqui será feito os acessos dos usuários, também do usuário master.*/
public class Acesso implements GrantedAuthority{
	/*GrantedAuthority implementa Serializable, por isso o serialVersionUID.*/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
	private Long id;
	private String descricao; // ROLE_ADMIN ou ROLE_SECRETARIO

	/*Método sempre é implementado quando se implementa GrantedAuthority. Mudar retorno.*/
	/*Ele está pprocurando o método setAuthority que não existe e por isso o erro no teste. Para corrigir colocamos
	 *@JsonIgnore. Ele aponta erro em authority no log.*/
	@JsonIgnore
	@Override
	public String getAuthority() {
		return this.descricao; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acesso other = (Acesso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}