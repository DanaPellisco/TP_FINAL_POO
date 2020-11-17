package ar.edu.unju.escminas.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escminas.config.EmfSingleton;
import ar.edu.unju.escminas.dao.IObraSocialDao;
import ar.edu.unju.escminas.modelo.ObraSocial;


public class ObraSocialDaoImp implements IObraSocialDao {
	
private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void guardarObraSocial(ObraSocial obraSocial) {
		manager.getTransaction().begin();
		manager.persist(obraSocial);
		manager.getTransaction().commit();		
	}
	
	@Override
	public ObraSocial buscarObraSocial(Long id) {
		// TODO Auto-generated method stub
		return manager.find(ObraSocial.class, id);
	}

	@Override
	public List<ObraSocial> obtenerObraSocial() {
		@SuppressWarnings("unchecked")
		List<ObraSocial> obraSocial = (List<ObraSocial>) manager.createQuery("SELECT e FROM ObraSocial e").getResultList();
		return obraSocial;
	}

}
