package jdev.mentoria.lojavirtual.model;

/*Pessoa é uma super classe com duas filhas, no banco de dados as chaves estranageiras pessoa não são criadas.
 *Devemos fazer manunteção no banco criando funções e triggers.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator; 

@Entity
/*Usando essa estratégia não iremos usar a anotação @PrimaryKeyColumn nas classes filhas para não dar erro.*/
/*A anotação é feita, pois Pessoa é uma super CLasse.*/
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
	
	/*Dados pessoais são obrigatórios para contato com o cliente em caso de problema na venda. Também em caso de mar-
	 *keting*/
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String telefone;
	
	/*Pessoa pode ter uma lista de endereços, seja pessoa física ou jurídica.*/
	/*Atributos que apontam para outra tabela recebem uma anotação.*/
	/*Atributo endereco não está no diagrama de classes e foi posto depois. Não obrigatório colocar esse atributo.*/
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/*apontando para a chave estrangeira pessoa em Endereco*/
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
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