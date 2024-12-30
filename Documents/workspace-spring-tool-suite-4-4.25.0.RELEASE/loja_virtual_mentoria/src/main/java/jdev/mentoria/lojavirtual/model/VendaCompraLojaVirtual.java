package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

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
	/*Como Pessoa é uma classe abstrata a gente coloca a classe alvo.*/
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
	
	private BigDecimal valorTotal; 
	private BigDecimal valorDesconto;
	
	/*Uma forma de pagamento pode aparecer em várias vendas. Mais uma vez sem entidade alvo.*/
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
	@JoinColumn(name = "cupom_desc_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cupom_desc_fk"))
	private CupDesc cupDesc;
	
	private BigDecimal valorFret;
	private Integer diaEntrega;

	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private Pessoa getPessoa() {
		return pessoa;
	}

	private void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	private Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	private void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	private Endereco getEnderecoConbranca() {
		return enderecoConbranca;
	}

	private void setEnderecoConbranca(Endereco enderecoConbranca) {
		this.enderecoConbranca = enderecoConbranca;
	}

	private BigDecimal getValorTotal() {
		return valorTotal;
	}

	private void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	private BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	private void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	private FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	private void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	private NotafiscalVenda getNotafiscalVenda() {
		return notafiscalVenda;
	}

	private void setNotafiscalVenda(NotafiscalVenda notafiscalVenda) {
		this.notafiscalVenda = notafiscalVenda;
	}

	private CupDesc getCupDesc() {
		return cupDesc;
	}

	private void setCupDesc(CupDesc cupDesc) {
		this.cupDesc = cupDesc;
	}

	private BigDecimal getValorFret() {
		return valorFret;
	}

	private void setValorFret(BigDecimal valorFret) {
		this.valorFret = valorFret;
	}

	private Integer getDiaEntrega() {
		return diaEntrega;
	}

	private void setDiaEntrega(Integer diaEntrega) {
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