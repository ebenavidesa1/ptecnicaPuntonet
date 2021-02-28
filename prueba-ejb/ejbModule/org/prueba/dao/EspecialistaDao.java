package org.prueba.dao;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.prueba.model.Especialista;
import org.prueba.model.Estadoticket;
import org.prueba.model.Ticket;
//import javax.inject.Inject;
@Stateless
public class EspecialistaDao extends DaoFacade<Especialista>{
	
	Logger logger = Logger.getLogger(EspecialistaDao.class.getName());
	
	public EspecialistaDao() {
		super(Especialista.class);
	}
	
	@PersistenceContext(unitName = "factElect")
   // @Inject
	private EntityManager em;		

	@Override
	protected EntityManager getEntityManager() {		
		return em;
	}	

}
