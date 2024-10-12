package jdev.mentoria.lojavirtual.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity /*Vai ser tabela no banco de dados.*/
@Table(name = "marca_produto")
/*Definir sequenciador para o Hibernate não fazer isso sozinho, o que pode bagunçar o projeto e deixar confuso.*/
@SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
public class MarcaProduto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
	private Long id;
	private String nomeDesc;

	private Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	private String getNomeDesc() {
		return nomeDesc;
	}
	private void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}
	
	
	
}
