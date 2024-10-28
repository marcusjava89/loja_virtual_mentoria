package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
public class Endereco  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	private Long id;
	private String ruaLogra;
	private String cep;
	private String numero; /*Pode ter letra na parte do número do endereço por isso String.*/ 
	private String complemento;
	private String bairro;
	private String uf;
	private String cidade;
	
	/*Define a relação de muitos para um no banco de dados, muitos endereços podem ser de uma pessoa. Também deixar 
	 *claro a entidade alvo que é Pessoa.*/
	@ManyToOne(targetEntity = Pessoa.class)
	/*Criou-se uma coluna para essa chav estrangeira.*/
	@JoinColumn(name = "pessoa_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;
	
	/*pessoa é um atributo relacionado a outra tabela, então é uma chave estrangeira e pela anotação destaca-se isso.*/

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private String getRuaLogra() {
		return ruaLogra;
	}

	private void setRuaLogra(String ruaLogra) {
		this.ruaLogra = ruaLogra;
	}

	private String getCep() {
		return cep;
	}

	private void setCep(String cep) {
		this.cep = cep;
	}

	private String getNumero() {
		return numero;
	}

	private void setNumero(String numero) {
		this.numero = numero;
	}

	private String getComplemento() {
		return complemento;
	}

	private void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	private String getBairro() {
		return bairro;
	}

	private void setBairro(String bairro) {
		this.bairro = bairro;
	}

	private String getUf() {
		return uf;
	}

	private void setUf(String uf) {
		this.uf = uf;
	}

	private String getCidade() {
		return cidade;
	}

	private void setCidade(String cidade) {
		this.cidade = cidade;
	}

	private Pessoa getPessoa() {
		return pessoa;
	}

	private void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}