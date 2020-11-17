package ar.edu.unju.escminas.dao;

import java.util.List;


import ar.edu.unju.escminas.modelo.ObraSocial;

public interface IObraSocialDao {
	
	public void guardarObraSocial(ObraSocial obraSocial);
	public ObraSocial buscarObraSocial(Long id);
	public List<ObraSocial> obtenerObraSocial();

}
