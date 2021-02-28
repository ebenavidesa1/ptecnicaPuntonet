package org.pueba.service;

import java.util.List;

/**
*
* @Stateless
* @LocalBean
*/
import javax.ejb.Local;

import org.prueba.model.Especialista;
import org.prueba.model.Ticket;

@Local
public interface ITicketService {

	List<Ticket> ConsultaLIKE(String nombreCampo, String like) throws Exception;
	
	List<Ticket> ConsultarTodos() throws Exception;
	
	List<Ticket> ConsultaPersonalizada(String consulta);
	
	Ticket guardarTicket(Ticket ticketModel) throws Exception;
	
	void eliminarTicket(Ticket ticketModel) throws Exception;

}
