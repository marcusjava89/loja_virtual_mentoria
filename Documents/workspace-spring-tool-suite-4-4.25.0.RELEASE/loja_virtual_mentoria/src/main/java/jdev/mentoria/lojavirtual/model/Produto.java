package jdev.mentoria.lojavirtual.model;

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
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;
	private String tipoUnidade;
	private String nome;
	/*Não está no diagrama. Para ter um status ativo ou não. Começa pelo true. Boolean pode ser true, false ou null.
	 *Se não definirmos ele começa como null.*/
	private Boolean ativo = Boolean.TRUE;
	
	/*No diagrama descricao está como text e não String. Com a definição do tipo text o length se faz desnecessário.*/
	@Column(columnDefinition = "text", length = 2000)
	private String descricao;
	
	/*Nota item nota produto atributo - Associar*/
	/*Definimos os atributos com valores iniciais que eles devem ter.*/
	/*Se não informamos certos dados eles podem ser definidos como nulo*/
	/*O banco de dados consegue ler o CamelCase e separa as palavras.*/
	private Double peso;
	private Double largura;
	private Double altura;
	private Double profundidade;
	private BigDecimal valorVenda = BigDecimal.ZERO; /*Começa no zero.*/
	private Integer QtdEstoque = 0;
	private Integer QtdeAlertaEstoque = 0;
	private String linkYoutube;	
	private Boolean alertaQtdeEstoque = Boolean.FALSE; /*Começa desligado.*/
	private Integer qtdeClique = 0;
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
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
		return QtdEstoque;
	}
	private void setQtdEstoque(Integer qtdEstoque) {
		QtdEstoque = qtdEstoque;
	}
	private Integer getQtdeAlertaEstoque() {
		return QtdeAlertaEstoque;
	}
	private void setQtdeAlertaEstoque(Integer qtdeAlertaEstoque) {
		QtdeAlertaEstoque = qtdeAlertaEstoque;
	}
	private String getLinkYoutube() {
		return linkYoutube;
	}
	private void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}
	private Boolean getAlertaQtdeEstoque() {
		return alertaQtdeEstoque;
	}
	private void setAlertaQtdeEstoque(Boolean alertaQtdeEstoque) {
		this.alertaQtdeEstoque = alertaQtdeEstoque;
	}
	private Integer getQtdeClique() {
		return qtdeClique;
	}
	private void setQtdeClique(Integer qtdeClique) {
		this.qtdeClique = qtdeClique;
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
