package org.pueba.service;

import java.util.List;

/**
*
* @Stateless
* @LocalBean
*/
import javax.ejb.Local;

import org.prueba.model.Estadoticket;

@Local
public interface IEstadoticketService {

	List<Estadoticket> ConsultarTodos() throws Exception;
	
	Estadoticket ConsultaPorId(int idEspecialista) throws Exception;

}
