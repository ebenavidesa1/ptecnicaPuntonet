package org.pueba.service;

import java.util.List;

/**
*
* @Stateless
* @LocalBean
*/
import javax.ejb.Local;

import org.prueba.model.Especialista;

@Local
public interface IEspecialistaService {
	
	List<Especialista> ConsultaLIKE(String nombreCampo, String like) throws Exception;
}
