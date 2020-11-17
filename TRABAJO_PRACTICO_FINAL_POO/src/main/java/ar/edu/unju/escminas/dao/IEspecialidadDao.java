package ar.edu.unju.escminas.dao;

import java.util.List;

import ar.edu.unju.escminas.modelo.Especialidad;

public interface IEspecialidadDao {
	
	public void guardarEspecialidad(Especialidad especialidad);
	public Especialidad buscarEspecialidad(Long id);
	public List<Especialidad> obtenerEspecialidad();

}
