package ar.edu.unju.escminas.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escminas.config.EmfSingleton;
import ar.edu.unju.escminas.dao.IPacienteDao;
import ar.edu.unju.escminas.modelo.Paciente;


public class PacienteDaoImp implements IPacienteDao{
	
private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void guardarPaciente(Paciente paciente) {
		manager.getTransaction().begin();
		manager.persist(paciente);
		manager.getTransaction().commit();		
	}
	
	@Override
	public Paciente buscarPaciente(int dni) {
		// TODO Auto-generated method stub
		return manager.find(Paciente.class, dni);
	}

	@Override
	public List<Paciente> obtenerPaciente() {
		@SuppressWarnings("unchecked")
		List<Paciente> paciente = (List<Paciente>) manager.createQuery("SELECT e FROM Paciente e").getResultList();
		return paciente;
	}

}
