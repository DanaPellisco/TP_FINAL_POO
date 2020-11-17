package ar.edu.unju.escminas.dao;

import java.util.List;


import ar.edu.unju.escminas.modelo.Reserva;

public interface IReservaDao {
	
	public void guardarReserva(Reserva reserva);
	public Reserva buscarReserva(Long id);
	public void borrarReserva(Reserva reserva);
	public List<Reserva> obtenerReserva();


}
