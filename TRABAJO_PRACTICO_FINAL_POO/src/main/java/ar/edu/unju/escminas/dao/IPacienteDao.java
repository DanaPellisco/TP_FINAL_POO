package ar.edu.unju.escminas.dao;

import java.util.List;

import ar.edu.unju.escminas.modelo.Paciente;



public interface IPacienteDao {
	
	public void guardarPaciente(Paciente paciente);
	public Paciente buscarPaciente(int dni);
	public List<Paciente> obtenerPaciente();

}
