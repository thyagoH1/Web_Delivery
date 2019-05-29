package br.com.DeliveryPizzaria.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bebida")
public class Bebida implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(length = 80, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int preco;
	
	@Column(name = "quantidade", nullable = false)
	private int quantidade;
	
	@Column(name = "quant_litros", nullable = false)
	private int qlitros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQlitros() {
		return qlitros;
	}

	public void setQlitros(int qlitros) {
		this.qlitros = qlitros;
	}
	
	

}
