package br.com.DeliveryPizzaria.domain;

public enum SituacaoCliente {
	CADASTRADO(1, "Cadastrado"),
	DESATIVADO(2, "Desativado");
	
	
	private int id;
	private String descricao;
	
	private SituacaoCliente(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static SituacaoCliente toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		for(SituacaoCliente o : SituacaoCliente.values()) {
			if(o.getId() == id.intValue()) {
				return o;
			}
		}
		throw new IllegalArgumentException("ID inválido: " + id);
	}
	
}
