package jdev.mentoria.lojavirtual.enums;

public enum StatusContaReceber {
	COBRANCA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	QUITADA("Quitada");
	
	private String decricao;

	private StatusContaReceber(String decricao) {
		this.decricao = decricao;
	}
	
	public String getDecricao() {
		return decricao;
	}
	
	@Override
	public String toString() {
		return this.decricao;
	}
}
