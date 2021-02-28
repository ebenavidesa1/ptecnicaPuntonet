package org.prueba.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.prueba.model.Especialista;
import org.prueba.model.Estadoticket;
import org.prueba.model.Ticket;
import org.pueba.service.IEspecialistaService;
import org.pueba.service.IEstadoticketService;
import org.pueba.service.ITicketService;

@Named
@ViewScoped
public class TicketMB implements Serializable {

	private static final long serialVersionUID = -4394417273607508214L;
	private String numticket;
	private String descripcion;
	private String estado;
	private String identifEspecialista;
	private String prioridad;
	private String observacion;
	private Date fechavencimiento;
	private Integer idEstadticket;
	private Especialista especialista;
	private Estadoticket estadoticket;
	private Ticket ticket;
	private List<Estadoticket> listEstados;
	private List<Ticket> listTickets;
	private List<Especialista> listEspecialistas;
	private boolean editar;

	@EJB
	ITicketService ticketService;

	@EJB
	IEstadoticketService estadoService;

	@EJB
	IEspecialistaService especialistaService;

	@PostConstruct
	public void init() {
		especialista = new Especialista();
		estadoticket = new Estadoticket();
		ticket = new Ticket();
		numticket = "";
		descripcion = "";
		estado = "";
		prioridad = "";
		observacion = "";
		identifEspecialista = "";
		fechavencimiento = new Date();
		editar = false;
		listEstados = new ArrayList<>();
		listTickets = new ArrayList<>();
		listEspecialistas = new ArrayList<>();
		cargarEstados();
		mostrarTickets();

	}

	public String getNumticket() {
		return numticket;
	}

	public void setNumticket(String numticket) {
		this.numticket = numticket;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getIdentifEspecialista() {
		return identifEspecialista;
	}

	public void setIdentifEspecialista(String identifEspecialista) {
		this.identifEspecialista = identifEspecialista;
	}

	public Integer getIdEstadticket() {
		return idEstadticket;
	}

	public void setIdEstadticket(Integer idEstadticket) {
		this.idEstadticket = idEstadticket;
	}

	public List<Estadoticket> getListEstados() {
		return listEstados;
	}

	public void setListEstados(List<Estadoticket> listEstados) {
		this.listEstados = listEstados;
	}

	public Especialista getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public Estadoticket getEstadoticket() {
		return estadoticket;
	}

	public void setEstadoticket(Estadoticket estadoticket) {
		this.estadoticket = estadoticket;
	}

	public List<Ticket> getListTickets() {
		return listTickets;
	}

	public void setListTickets(List<Ticket> listTickets) {
		this.listTickets = listTickets;
	}

	// Métodos
	public void limpiar() {
		ticket = new Ticket();
		especialista = new Especialista();
		estadoticket = new Estadoticket();
		numticket = "";
		descripcion = "";
		estado = "";
		prioridad = "";
		observacion = "";
		identifEspecialista = "";
		fechavencimiento = new Date();
		editar = false;

	}

	public void mostrarTickets() {
		try {
			listTickets = ticketService.ConsultaPersonalizada("estado=1)");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void cargarEstados() {
		try {
			listEstados = estadoService.ConsultarTodos();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void buscarEspecialista() {
		try {
			listEspecialistas = especialistaService.ConsultaLIKE("identificacion", identifEspecialista);
			if (listEspecialistas.size() > 0) {
				especialista = listEspecialistas.get(0);
			}else {
				especialista=new Especialista();
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void guardarTicket() {
		if (editar == false) {
			ticket = new Ticket();
		}

		try {
			ticket.setNumTicket(numticket);

			// buscar estado
			Estadoticket busqEstado = estadoService.ConsultaPorId(idEstadticket);
			if (busqEstado != null) {
				ticket.setEstadoticket(busqEstado);
			}

			ticket.setEspecialista(especialista);
			ticket.setDescripcion(descripcion);
			ticket.setFechaVencimiento(fechavencimiento);
			ticket.setObservacion(observacion);
			ticket.setPrioridad(prioridad);
			ticket.setEstado(1);

			Ticket ticketRespuesta = ticketService.guardarTicket(ticket);
			if (ticketRespuesta != null) {
				System.out.println("Guardó ticket");
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Ticket Guardado Correctamente");
				FacesContext.getCurrentInstance().addMessage(null, message);
				mostrarTickets();
				limpiar();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editarTicket(Ticket entradaticket) {
		editar = true;
		ticket = new Ticket();
		ticket = entradaticket;
		numticket = entradaticket.getNumTicket();
		descripcion = entradaticket.getDescripcion();
		idEstadticket = entradaticket.getEstadoticket().getIdEstado();
		estadoticket = entradaticket.getEstadoticket();
		prioridad = entradaticket.getPrioridad();
		identifEspecialista = entradaticket.getEspecialista().getIdentificacion();
		especialista = entradaticket.getEspecialista();
		fechavencimiento = entradaticket.getFechaVencimiento();
		observacion = entradaticket.getObservacion();

	}

	public void eliminarTicket(Ticket entradaticket) {
		editar = true;
		ticket = new Ticket();
		ticket = entradaticket;
		System.out.println("Entro a eliminar");
		try {
			ticket.setEstado(0);
			Ticket ticketRespuesta = ticketService.guardarTicket(ticket);
			if (ticketRespuesta != null) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Se eliminó el registro correctamente");
				FacesContext.getCurrentInstance().addMessage(null, message);
				mostrarTickets();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

		}
	}

}
