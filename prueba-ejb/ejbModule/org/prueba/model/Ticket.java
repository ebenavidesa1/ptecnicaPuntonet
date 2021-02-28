package org.prueba.model;
// Generated 27/02/2021 23:11:15 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * Ticket generated by hbm2java
 */
@Entity
@Table(name = "Ticket", schema = "dbo", catalog = "Prueba")
public class Ticket implements java.io.Serializable {

	private int idTicket;
	private Estadoticket estadoticket;
	private Especialista especialista;
	private String numTicket;
	private String descripcion;
	private Date fechaVencimiento;
	private String observacion;
	private String prioridad;
	private int estado;

	public Ticket() {
	}

	public Ticket(int idTicket) {
		this.idTicket = idTicket;
	}

	public Ticket(int idTicket, Estadoticket estadoticket, Especialista especialista, String numTicket,
			String descripcion, Date fechaVencimiento, String observacion, String prioridad,int estado) {
		this.idTicket = idTicket;
		this.estadoticket = estadoticket;
		this.especialista = especialista;
		this.numTicket = numTicket;
		this.descripcion = descripcion;
		this.fechaVencimiento = fechaVencimiento;
		this.observacion = observacion;
		this.prioridad=prioridad;
		this.estado=estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdTicket", unique = true, nullable = false)
	public int getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdEstadoticket")
	public Estadoticket getEstadoticket() {
		return this.estadoticket;
	}

	public void setEstadoticket(Estadoticket estadoticket) {
		this.estadoticket = estadoticket;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdEspecialista")
	public Especialista getEspecialista() {
		return this.especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	@Column(name = "NumTicket", length = 50)
	@Size(max = 50)
	public String getNumTicket() {
		return this.numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	@Column(name = "Descripcion", length = 60)
	@Size(max = 60)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaVencimiento", length = 10)
	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Column(name = "Observacion", length = 500)
	@Size(max = 500)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Column(name = "Prioridad", length = 10)
	@Size(max = 10)
	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	@Column(name = "estado")
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	

}
