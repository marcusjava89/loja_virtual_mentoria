package loja.estudo.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", initialValue = 1, allocationSize = 1)
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;
	
	private String tipoUnidade;
	private String nome;
	private Boolean ativo = Boolean.TRUE;
	/*Grande quantidade de caracteres*/
	@Column(columnDefinition = "text")
	private String descricao;
	
	/*Vamos criar a classe nota item produto ainda para associar*/
	
	private Double peso;
	private Double largura;
	private Double altura;
	private Double profundidade;
	private BigDecimal valorVenda = BigDecimal.ZERO; /*começa no zero.*/
	private Integer qtdEstoque = 0;
	private Integer qtdAlertaEstoque = 0;
	private String linkYoutube;
	private Boolean alertaQtdeEtoque = Boolean.FALSE;
	private Integer qtdClique = 0;
	
	private Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	private String getTipoUnidade() {
		return tipoUnidade;
	}
	private void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}
	private String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	private Boolean getAtivo() {
		return ativo;
	}
	private void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	private String getDescricao() {
		return descricao;
	}
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	private Double getPeso() {
		return peso;
	}
	private void setPeso(Double peso) {
		this.peso = peso;
	}
	private Double getLargura() {
		return largura;
	}
	private void setLargura(Double largura) {
		this.largura = largura;
	}
	private Double getAltura() {
		return altura;
	}
	private void setAltura(Double altura) {
		this.altura = altura;
	}
	private Double getProfundidade() {
		return profundidade;
	}
	private void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}
	private BigDecimal getValorVenda() {
		return valorVenda;
	}
	private void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	private Integer getQtdEstoque() {
		return qtdEstoque;
	}
	private void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	private Integer getQtdAlertaEstoque() {
		return qtdAlertaEstoque;
	}
	private void setQtdAlertaEstoque(Integer qtdAlertaEstoque) {
		this.qtdAlertaEstoque = qtdAlertaEstoque;
	}
	private String getLinkYoutube() {
		return linkYoutube;
	}
	private void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}
	private Boolean getAlertaQtdeEtoque() {
		return alertaQtdeEtoque;
	}
	private void setAlertaQtdeEtoque(Boolean alertaQtdeEtoque) {
		this.alertaQtdeEtoque = alertaQtdeEtoque;
	}
	private Integer getQtdClique() {
		return qtdClique;
	}
	private void setQtdClique(Integer qtdClique) {
		this.qtdClique = qtdClique;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
