package br.com.DeliveryPizzaria.domain;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_pedido")
	@JsonFormat(pattern = "HH:mm:ss")
	private Date horaPedido;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_entrega")
	@JsonFormat(pattern = "HH:mm:ss")
	private Date horaEntrega;

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getHoraPedido() {
		return horaPedido;
	}


	public void setHoraPedido(Date horaPedido) {
		this.horaPedido = horaPedido;
	}


	public Date getHoraEntrega() {
		return horaEntrega;
	}


	public void setHoraEntrega(Date horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
	


}
