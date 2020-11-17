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
@Table(name="Medico")
public class Medico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name ="ID")
	private Long id;
	@Column (name ="MATRICULA")
	private int matricula;
	@Column (name ="DNI")
	private int dni;
	@Column (name ="NOMBRE")
	private String nombre;
	@Column (name ="APELLIDO")
	private String apellido;
	@Column (name ="TELEFONO")
	private String telefono;
	
	
	@ManyToOne
	@JoinColumn(name="ESPECIALIDAD")
	private Especialidad especialidad;
	
	public Medico() {
		
	}

	

	public Medico(int matricula, int dni, String nombre, String apellido, String telefono, Especialidad especialidad) {
		super();
		this.matricula = matricula;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Especialidad [id=" + id + ", matricula=" + matricula + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", telefono=" + telefono + ", especialidad=" + especialidad + "]";
	}
	

}
