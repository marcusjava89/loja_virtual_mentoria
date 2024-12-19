package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cup_desc")
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", allocationSize = 1, initialValue = 1)
public class CupDesc implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
	private Long id;
	
	/*Nome do cupom será pré definido pelo dev, para não confundir clientes mais simples.*/
	private String codDesc;
	private BigDecimal valorRealDesc;
	private BigDecimal valorPorcentDesc;
	
	/*Atributo abaixo não está no diagrama de classes*/
	@Temporal(TemporalType.DATE)
	private Date dataValidadeCupom;

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private String getCodDesc() {
		return codDesc;
	}

	private void setCodDesc(String codDesc) {
		this.codDesc = codDesc;
	}

	private BigDecimal getValorRealDesc() {
		return valorRealDesc;
	}

	private void setValorRealDesc(BigDecimal valorRealDesc) {
		this.valorRealDesc = valorRealDesc;
	}

	private BigDecimal getValorPorcentDesc() {
		return valorPorcentDesc;
	}

	private void setValorPorcentDesc(BigDecimal valorPorcentDesc) {
		this.valorPorcentDesc = valorPorcentDesc;
	}

	private Date getDataValidadeCupom() {
		return dataValidadeCupom;
	}

	private void setDataValidadeCupom(Date dataValidadeCupom) {
		this.dataValidadeCupom = dataValidadeCupom;
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
		CupDesc other = (CupDesc) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
}
