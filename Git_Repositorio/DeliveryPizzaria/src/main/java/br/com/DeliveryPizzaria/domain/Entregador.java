package br.com.DeliveryPizzaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entregador")
public class Entregador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column(length = 80, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
	

}
