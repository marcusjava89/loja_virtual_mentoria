package loja.estudo.spring.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jdev.mentoria.lojavirtual.enums.TipoEndereco;

@Entity
@Table(name="endereco")
@SequenceGenerator(name= "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1, initialValue = 1)
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	private Long id;
	
	private String ruaLogra;
	private String cep;
	private String numero;
	private String cmplemento;
	private String bairro;
	private String uf;
	private String cidade;
	
	/*Muitos endereços podem ter como entidade alvo uma pessoa.*/
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk") )
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	
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
	private String getCmplemento() {
		return cmplemento;
	}
	private void setCmplemento(String cmplemento) {
		this.cmplemento = cmplemento;
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
	private TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	private void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
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