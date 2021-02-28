package org.prueba.dao;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.prueba.model.Ticket;
//import javax.inject.Inject;
@Stateless
public class TicketDao extends DaoFacade<Ticket>{
	
	Logger logger = Logger.getLogger(TicketDao.class.getName());
	
	public TicketDao() {
		super(Ticket.class);
	}
	
	@PersistenceContext(unitName = "factElect")
   // @Inject
	private EntityManager em;		

	@Override
	protected EntityManager getEntityManager() {		
		return em;
	}	

}
