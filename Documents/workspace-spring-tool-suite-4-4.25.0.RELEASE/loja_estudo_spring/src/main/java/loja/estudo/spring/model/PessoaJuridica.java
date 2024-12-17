package loja.estudo.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String inscEstadual;
	private String inscMunicipal;
	private String nomeFantasia;
	private String razaoSocial;
	private String categoria;
	
	private String getCnpj() {
		return cnpj;
	}
	private void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	private String getInscEstadual() {
		return inscEstadual;
	}
	private void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	private String getInscMunicipal() {
		return inscMunicipal;
	}
	private void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}
	private String getNomeFantasia() {
		return nomeFantasia;
	}
	private void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	private String getRazaoSocial() {
		return razaoSocial;
	}
	private void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	private String getCategoria() {
		return categoria;
	}
	private void setCategoria(String categoria) {
		this.categoria = categoria;
	}
		
}