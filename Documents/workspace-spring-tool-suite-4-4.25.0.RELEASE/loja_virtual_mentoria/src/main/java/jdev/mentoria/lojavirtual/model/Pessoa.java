package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator; 

@Entity
/*Usando essa estratégia não iremos usar a anotação @PrimaryKeyColumn nas classes filhas para não dar erro.*/
/*Faz sentido uma anotação que define o tipo de herança que teremos, visto que é uma super CLasse.*/
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
/*As classes filhas herdam o @SequenceGenerator, não precisando colocar nelas.*/
@SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1, initialValue = 1)
public abstract class Pessoa  implements Serializable{
	/*Essa classe não é criada no banco de dados e as classes filhas são. Nas classes filhas não precisaremos imple-
	 *mentar Serialização por conta da herança. Como consequência coloca-se em cada classe filha o serialVersion.*/

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	
	/*Uma pessoa pode ter uma lista de endereços, seja pessoa física ou jurídica.*/
	/*Atributos que apontam para outra tabela recebem uma anotação.*/
	/*Atributo endereco não está no diagrama de classes e foi posto depois. Não obrigatório colocar esse atributo.*/
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/*apontando para a chave estrangeira pessoa em Endereco*/
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	private List<Endereco> getEnderecos() {
		return enderecos;
	}
	private void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	private Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	private String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	private String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	private String getTelefone() {
		return telefone;
	}
	private void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}