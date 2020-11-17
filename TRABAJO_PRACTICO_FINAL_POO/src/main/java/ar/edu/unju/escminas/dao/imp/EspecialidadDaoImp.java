package ar.edu.unju.escminas.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escminas.config.EmfSingleton;
import ar.edu.unju.escminas.dao.IEspecialidadDao;
import ar.edu.unju.escminas.modelo.Especialidad;


public class EspecialidadDaoImp implements IEspecialidadDao{
	
private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void guardarEspecialidad(Especialidad especialidad) {
		manager.getTransaction().begin();
		manager.persist(especialidad);
		manager.getTransaction().commit();		
	}
	
	@Override
	public Especialidad buscarEspecialidad(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Especialidad.class, id);
	}

	@Override
	public List<Especialidad> obtenerEspecialidad() {
		@SuppressWarnings("unchecked")
		List<Especialidad> especialidades = (List<Especialidad>) manager.createQuery("SELECT e FROM Especialidad e").getResultList();
		return especialidades;
	}

}
