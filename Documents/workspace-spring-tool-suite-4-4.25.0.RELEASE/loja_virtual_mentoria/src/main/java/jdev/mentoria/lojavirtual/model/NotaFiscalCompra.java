package jdev.mentoria.lojavirtual;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
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
import jdev.mentoria.lojavirtual.model.ContaPagar;
import jdev.mentoria.lojavirtual.model.Pessoa;

@Entity
@Table(name = "nota_fiscal_compra")
@SequenceGenerator(name = "seq_nota_fiscal_compra", sequenceName = "seq_nota_fiscal_compra", 
allocationSize = 1, initialValue = 1)
public class NotaFiscalCompra implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_compra")
	private Long id;
	
	private String numeroNota;
	private String serieNota;
	private String descricaoObs;
	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;
	private BigDecimal valorIcms;
	
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, 
	foreignKey = @ForeignKey(name = "pessoa_fk", value = ConstraintMode.CONSTRAINT))
	private Pessoa pessoa;
	
	/*Aqui não colocamos entidade alvo, talvez porque no diagrama era de um para um.*/
	@ManyToOne()
	@JoinColumn(name = "conta_pagar_id", nullable = false, 
	foreignKey = @ForeignKey(name = "conta_pagar_fk", value = ConstraintMode.CONSTRAINT))
	private ContaPagar contaPagar;

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private String getNumeroNota() {
		return numeroNota;
	}

	private void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	private String getSerieNota() {
		return serieNota;
	}

	private void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

	private String getDescricaoObs() {
		return descricaoObs;
	}

	private void setDescricaoObs(String descricaoObs) {
		this.descricaoObs = descricaoObs;
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

	private BigDecimal getValorIcms() {
		return valorIcms;
	}

	private void setValorIcms(BigDecimal valorIcms) {
		this.valorIcms = valorIcms;
	}

	private Date getDataCompra() {
		return dataCompra;
	}

	private void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	private Pessoa getPessoa() {
		return pessoa;
	}

	private void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	private ContaPagar getContaPagar() {
		return contaPagar;
	}

	private void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
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
		NotaFiscalCompra other = (NotaFiscalCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
