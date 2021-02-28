package org.prueba.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.prueba.model.Ticket;

public abstract class DaoFacade<T> {

	Logger logger = Logger.getLogger(DaoFacade.class.getName());

	private Class<T> classEntity;

	public DaoFacade(Class<T> classEntity) {
		this.classEntity = classEntity;
	}

	protected abstract EntityManager getEntityManager();

	public T guardar(T entidad) throws Exception {
		return getEntityManager().merge(entidad);
	}

	public void actualizar(T entidad) {
		try {
			getEntityManager().merge(entidad);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error al actializar la entidad [DaoFacade] " + e);
		}

	}

	public void eliminar(T entidad) throws Exception {
		getEntityManager().remove(getEntityManager().merge(entidad));
	}

	public T consultarPorId(Object id) throws Exception {
		return getEntityManager().find(classEntity, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> consultarTodos() throws Exception {
		return getEntityManager().createQuery("Select alias from " + classEntity.getSimpleName() + " alias")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> consultarLike(String nombreCampo, Object like) throws Exception {
		return getEntityManager().createQuery("Select alias from " + classEntity.getSimpleName() + " alias Where alias."
				+ nombreCampo + " like '%" + like + "%'").getResultList();
	}
	
	public T consultarPorCampo(Object id) throws Exception {
		return getEntityManager().find(classEntity, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket> busquedaPersonalizada(String sentencia) throws Exception {
		String busqueda = "Select alias from Ticket alias where (alias.";
		return getEntityManager().createQuery(busqueda + sentencia).getResultList();
	}


}
