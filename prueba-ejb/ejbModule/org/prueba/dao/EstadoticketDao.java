package org.prueba.dao;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.prueba.model.Estadoticket;
import org.prueba.model.Ticket;
//import javax.inject.Inject;
@Stateless
public class EstadoticketDao extends DaoFacade<Estadoticket>{
	
	Logger logger = Logger.getLogger(EstadoticketDao.class.getName());
	
	public EstadoticketDao() {
		super(Estadoticket.class);
	}
	
	@PersistenceContext(unitName = "factElect")
   // @Inject
	private EntityManager em;		

	@Override
	protected EntityManager getEntityManager() {		
		return em;
	}	

}
