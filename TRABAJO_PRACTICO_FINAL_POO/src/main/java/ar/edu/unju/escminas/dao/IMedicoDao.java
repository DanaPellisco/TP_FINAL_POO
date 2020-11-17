package ar.edu.unju.escminas.dao;

import java.util.List;

import ar.edu.unju.escminas.modelo.Medico;


public interface IMedicoDao {
	
	public void guardarMedico(Medico medico);
	public Medico buscarMedico(int matricula);
	public List<Medico> obtenerMedico();

}
