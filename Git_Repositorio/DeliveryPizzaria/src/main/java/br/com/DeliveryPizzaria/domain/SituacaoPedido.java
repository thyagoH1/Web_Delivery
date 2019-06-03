package br.com.DeliveryPizzaria.domain;


public enum SituacaoPedido {
	
	ACEITO(1, "Aprovado"),
	RECUSADO(2, "Recusado"),
	ESPERA(3, "Espera");
	
	private int codigo;
	private String descricao;
	
	private SituacaoPedido(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static SituacaoPedido toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(SituacaoPedido o : SituacaoPedido.values()) {
			if(o.getCodigo() == codigo.intValue()) {
				return o;
			}
		}
		throw new IllegalArgumentException("Código inválido: " + codigo);
	}
}
