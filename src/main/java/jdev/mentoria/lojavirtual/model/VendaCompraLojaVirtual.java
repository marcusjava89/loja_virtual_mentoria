package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vd_cp_loja_virt")
@SequenceGenerator(name = "seq_vd_cp_loja_virt", sequenceName = "seq_vd_cp_loja_virt", 
allocationSize = 1, initialValue = 1)
public class VendaCompraLojaVirtual implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vd_cp_loja_virt")
	private Long id;
	
	/*A cada associação feita rodar o projeto para achar onde está o erro, caso tenha.*/
	/*Como Pessoa é uma classe abstrata a gente coloca a entidade alvo.*/
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, 
	foreignKey = @ForeignKey(name = "pessoa_fk", value = ConstraintMode.CONSTRAINT))
	private Pessoa pessoa;
	
	/*Não precisa colocar a classe alvo porque Endereco não é uma classe abstrata.*/
	/*O nome da join column é o nome do atributo e não da classe.*/
	@ManyToOne
	@JoinColumn(name = "endereco_entrega_id", nullable = false, 
	foreignKey = @ForeignKey(name = "endereco_entrega_fk", value = ConstraintMode.CONSTRAINT))
	private Endereco enderecoEntrega;

	@ManyToOne
	@JoinColumn(name = "endereco_cobranca_id", nullable = false, 
	foreignKey = @ForeignKey(name = "endereco_cobranca_fk", value = ConstraintMode.CONSTRAINT))
	private Endereco enderecoConbranca;
	
	@Column(nullable = false)
	private BigDecimal valorTotal; 
	private BigDecimal valorDesconto;
	
 	@ManyToOne
	@JoinColumn(name = "forma_pagamento_id", nullable = false, 
	foreignKey = @ForeignKey(name = "forma_pagamento_fk", value = ConstraintMode.CONSTRAINT))
	private FormaPagamento formaPagamento; 
	
	/*A anotação @OneToOne também tem uma coluna de junção.*/
	@OneToOne /*uma venda tem uma nota fiscal.*/
	@JoinColumn(name = "nota_fiscal_venda_id", nullable = false, 
	foreignKey = @ForeignKey(name = "nota_fiscal_venda_fk", value = ConstraintMode.CONSTRAINT))
	private NotafiscalVenda notafiscalVenda; 
	/*fazer a associação na nota fiscal venda para saber de qual venda vem a nota.*/
	
	
	@ManyToOne
	@JoinColumn(name = "cupom_desc_id", /*Pode não ter um cupom de desconto.*/ 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cupom_desc_fk"))
	private CupDesc cupDesc;
	
	@Column(nullable = false)
	private BigDecimal valorFret;
	
	@Column(nullable = false)	
	private Integer diaEntrega;

	@Column(nullable = false) /*Previsão*/
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE) /*Previsão*/
	private Date dataEntrega;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Endereco getEnderecoConbranca() {
		return enderecoConbranca;
	}

	public void setEnderecoConbranca(Endereco enderecoConbranca) {
		this.enderecoConbranca = enderecoConbranca;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public NotafiscalVenda getNotafiscalVenda() {
		return notafiscalVenda;
	}

	public void setNotafiscalVenda(NotafiscalVenda notafiscalVenda) {
		this.notafiscalVenda = notafiscalVenda;
	}

	public CupDesc getCupDesc() {
		return cupDesc;
	}

	public void setCupDesc(CupDesc cupDesc) {
		this.cupDesc = cupDesc;
	}

	public BigDecimal getValorFret() {
		return valorFret;
	}

	public void setValorFret(BigDecimal valorFret) {
		this.valorFret = valorFret;
	}

	public Integer getDiaEntrega() {
		return diaEntrega;
	}

	public void setDiaEntrega(Integer diaEntrega) {
		this.diaEntrega = diaEntrega;
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
		VendaCompraLojaVirtual other = (VendaCompraLojaVirtual) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	private Date getDataVenda() {
		return dataVenda;
	}

	private void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	private Date getDataEntrega() {
		return dataEntrega;
	}

	private void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
}