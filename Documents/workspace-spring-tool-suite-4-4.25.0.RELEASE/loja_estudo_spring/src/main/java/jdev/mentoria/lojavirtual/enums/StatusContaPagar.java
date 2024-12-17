package jdev.mentoria.lojavirtual.enums;

public enum StatusContaPagar {

		COBRANCA("cobrança"),
		VENCIDA("vencida"),
		ABERTA("aberta"),
		QUITADA("quitada"),
		NEGOCIADA("renegociada");

		private String descricao;

		private StatusContaPagar(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
		@Override
		public String toString() {
			return this.descricao;
		}
		
}