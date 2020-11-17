package ar.edu.unju.escminas.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escminas.config.EmfSingleton;
import ar.edu.unju.escminas.dao.IReservaDao;
import ar.edu.unju.escminas.modelo.Reserva;

public class ReservaDaoImp implements IReservaDao{
	
private static EntityManager manager = EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void guardarReserva(Reserva reserva) {
		manager.getTransaction().begin();
		manager.persist(reserva);
		manager.getTransaction().commit();		
	}

	@Override
	public void borrarReserva(Reserva reserva) {
		manager.getTransaction().begin();
		manager.remove(reserva);
		manager.getTransaction().commit();		
	}
	
	@Override
	public Reserva buscarReserva(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Reserva.class, id);
	}

	@Override
	public List<Reserva> obtenerReserva() {
		@SuppressWarnings("unchecked")
		List<Reserva> reserva = (List<Reserva>) manager.createQuery("SELECT e FROM Reserva e").getResultList();
		return reserva;
	}

}
