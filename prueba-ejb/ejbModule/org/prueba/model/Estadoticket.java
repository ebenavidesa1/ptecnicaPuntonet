package org.prueba.model;
// Generated 27/02/2021 23:11:15 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Estadoticket generated by hbm2java
 */
@Entity
@Table(name = "Estadoticket", schema = "dbo", catalog = "Prueba")
public class Estadoticket implements java.io.Serializable {

	private int idEstado;
	private String nombre;
	private String descripcion;
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public Estadoticket() {
	}

	public Estadoticket(int idEstado) {
		this.idEstado = idEstado;
	}

	public Estadoticket(int idEstado, String nombre, String descripcion, Set<Ticket> tickets) {
		this.idEstado = idEstado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tickets = tickets;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdEstado", unique = true, nullable = false)
	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	@Column(name = "Nombre", length = 10)
	@Size(max = 10)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Descripcion", length = 60)
	@Size(max = 60)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadoticket")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
