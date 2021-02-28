package org.prueba.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.prueba.dao.TicketDao;
import org.prueba.model.Especialista;
import org.prueba.model.Ticket;
import org.pueba.service.ITicketService;

@Stateless
public class TicketServiceImpl implements ITicketService {

	Logger logger = Logger.getLogger(TicketServiceImpl.class.getName());

	public Date FECHA_ACTUAL = new Date();

	@EJB
	TicketDao ticketDao;

	@Override
	public Ticket guardarTicket(Ticket ticket) {
		Ticket respuesta = new Ticket();
	
		try {
			respuesta = ticketDao.guardar(ticket);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta = null;
		}
		return respuesta;
	}
	
	@Override
	public List<Ticket> ConsultaLIKE(String nombreCampo, String like) throws Exception {
		return ticketDao.consultarLike(nombreCampo, like);
	}
	
	@Override
	public List<Ticket> ConsultarTodos() throws Exception {
		// TODO Auto-generated method stub
		return ticketDao.consultarTodos();
	}
	
	@Override
	public List<Ticket> ConsultaPersonalizada(String consulta) {
		// TODO Auto-generated method stub
		List<Ticket> respuesta = null;
		try {
			respuesta = ticketDao.busquedaPersonalizada(consulta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return respuesta;
	}

	
	@Override
	public void eliminarTicket(Ticket ticket) {
		Ticket respuesta = new Ticket();
	
		try {
			ticketDao.eliminar(ticket);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//respuesta = null;
		}
	}

	

}
