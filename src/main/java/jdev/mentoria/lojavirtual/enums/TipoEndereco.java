package jdev.mentoria.lojavirtual.enums;

public enum TipoEndereco {
	/*Por padrão devemos ter o atributo descricao, o construtor com esse atributo, getter, sem setter, e toString.*/
	/*O ";" apenas no final. Separamos por ",".*/
	COBRANCA("cobrança"),
	ENTREGA("entrega");
	
	/*Esse atributo deve ser colocado sempre que tivermos um enum para colocarmos no construtor.*/
	private String descricao;

	/*E sempre temos que ter um construtor no Enum, com a descricao.*/
	TipoEndereco(String descricao) {
		this.descricao = descricao;
	}

	private String getDescricao() {
		return descricao;
	}

	/*Mudamos o retorno para this.descricao*/
	@Override
	public String toString() {
		return this.descricao;
	}
	
}
