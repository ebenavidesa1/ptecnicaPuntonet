package org.prueba.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.prueba.dao.EstadoticketDao;
import org.prueba.dao.TicketDao;
import org.prueba.model.Estadoticket;
import org.prueba.model.Ticket;
import org.pueba.service.IEstadoticketService;
import org.pueba.service.ITicketService;

@Stateless
public class EstadoticketServiceImpl implements IEstadoticketService {

	Logger logger = Logger.getLogger(EstadoticketServiceImpl.class.getName());

	public Date FECHA_ACTUAL = new Date();

	@EJB
	EstadoticketDao estadoDao;

	
	@Override
	public List<Estadoticket> ConsultarTodos() throws Exception {
		// TODO Auto-generated method stub
		return estadoDao.consultarTodos();
	}
	
	@Override
	public Estadoticket ConsultaPorId(int idEspecialista) throws Exception {
		return estadoDao.consultarPorId(idEspecialista);
	}
	
	

}
