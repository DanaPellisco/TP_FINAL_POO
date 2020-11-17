package ar.edu.unju.escminas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Paciente")
public class Paciente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name ="ID")
	private Long id;
	@Column (name ="DNI")
	private int dni;
	@Column (name ="NOMBRE")
	private String nombre;
	@Column (name ="APELLIDO")
	private String apellido;
	@Column (name ="EDAD")
	private int edad;
	@Column (name ="TELEFONO")
	private String teléfono;
	
	@ManyToOne
	@JoinColumn(name="OBRA_SOCIAL")
	private ObraSocial obraSocial;
	
	public Paciente() {
		
	}

	public Paciente(int dni, String nombre, String apellido, int edad, ObraSocial obraSocial, String teléfono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.obraSocial = obraSocial;
		this.teléfono = teléfono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad="
				+ edad + ", obraSocial=" + obraSocial + ", teléfono=" + teléfono + "]";
	}


}
