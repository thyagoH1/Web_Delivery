package br.com.DeliveryPizzaria.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(length = 80, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int preco;
	
	@Column(name = "sabor", nullable = false)
	private String sabor;
	
	@Column(name = "quantidade", nullable = false)
	private int quantidade;
	
	@Column(name = "recheio", nullable = false)
	private int recheio;
	

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

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public int getRecheio() {
		return recheio;
	}

	public void setRecheio(int recheio) {
		this.recheio = recheio;
	}

	
	

}
