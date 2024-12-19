package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;

import jakarta.persistence.Column;
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
import jdev.mentoria.lojavirtual.NotaFiscalCompra;

@Entity
@Table(name = "nota_item_produto")
@SequenceGenerator(name = "seq_nota_item_produto", sequenceName = "seq_nota_item_produto", 
allocationSize = 1, initialValue = 1)
public class NotaItemProduto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_item_produto")
	private Long id;
	
	@Column(nullable = false)
	private Double quantidade;
	
	@ManyToOne(targetEntity = Produto.class)
	@JoinColumn(name = "produto_id", nullable = false, 
	foreignKey = @ForeignKey(name = "produto_fk", value = ConstraintMode.CONSTRAINT))
	private Produto produto;
	
	@ManyToOne(targetEntity = NotaFiscalCompra.class)
	@JoinColumn(name = "nota_fiscal_compra_id", nullable = false, 
	foreignKey = @ForeignKey(name = "nota_fiscal_compra_fk", value = ConstraintMode.CONSTRAINT))
	private NotaFiscalCompra notaFiscalCompra;

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private Double getQuantidade() {
		return quantidade;
	}

	private void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	private Produto getProduto() {
		return produto;
	}

	private void setProduto(Produto produto) {
		this.produto = produto;
	}

	private NotaFiscalCompra getNotaFiscalCompra() {
		return notaFiscalCompra;
	}

	private void setNotaFiscalCompra(NotaFiscalCompra notaFiscalCompra) {
		this.notaFiscalCompra = notaFiscalCompra;
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
		NotaItemProduto other = (NotaItemProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
