package org.prueba.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.prueba.dao.EspecialistaDao;
import org.prueba.model.Especialista;
import org.pueba.service.IEspecialistaService;

@Stateless
public class EspecialistaServiceImpl implements IEspecialistaService {

	Logger logger = Logger.getLogger(EspecialistaServiceImpl.class.getName());

	public Date FECHA_ACTUAL = new Date();

	@EJB
	EspecialistaDao especialistaDao;


	@Override
	public List<Especialista> ConsultaLIKE(String nombreCampo, String like) throws Exception {
		return especialistaDao.consultarLike(nombreCampo, like);
	}
	

	

}
