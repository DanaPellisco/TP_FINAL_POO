package ar.edu.unju.escminas.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escminas.config.EmfSingleton;
import ar.edu.unju.escminas.dao.IMedicoDao;
import ar.edu.unju.escminas.modelo.Medico;


public class MedicoDaoImp implements IMedicoDao{
	
private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void guardarMedico(Medico medico) {
		manager.getTransaction().begin();
		manager.persist(medico);
		manager.getTransaction().commit();		
	}
	
	@Override
	public Medico buscarMedico(int matricula) {
		// TODO Auto-generated method stub
		return manager.find(Medico.class, matricula);
	}

	@Override
	public List<Medico> obtenerMedico() {
		@SuppressWarnings("unchecked")
		List<Medico> medico = (List<Medico>) manager.createQuery("SELECT e FROM Medico e").getResultList();
		return medico;
	}

}
