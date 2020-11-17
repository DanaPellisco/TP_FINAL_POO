package ar.edu.unju.escminas.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reserva")
public class Reserva implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name ="ID")
	private Long id;
	@Column (name ="FECHA_HORA")
	private LocalDateTime fechaHora;
	@Column (name ="CONSULTORIO")
	private int consultorio;
	
	@ManyToOne
	@JoinColumn(name="MEDICO")
	private Medico medico;
	@ManyToOne
	@JoinColumn(name="PACIENTE")
	private Paciente paciente;
	
	public Reserva() {
		
	}

	public Reserva(LocalDateTime fechaHora, Paciente paciente, Medico medico, int consultorio) {
		super();
		this.fechaHora = fechaHora;
		this.paciente = paciente;
		this.medico = medico;
		this.consultorio = consultorio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public int getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(int consultorio) {
		this.consultorio = consultorio;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaHora=" + fechaHora + ", paciente=" + paciente + ", medico=" + medico
				+ ", consultorio=" + consultorio + "]";
	}
	

}
