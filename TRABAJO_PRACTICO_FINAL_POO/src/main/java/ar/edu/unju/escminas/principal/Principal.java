package ar.edu.unju.escminas.principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ar.edu.unju.escminas.dao.IEspecialidadDao;
import ar.edu.unju.escminas.dao.IMedicoDao;
import ar.edu.unju.escminas.dao.IObraSocialDao;
import ar.edu.unju.escminas.dao.IPacienteDao;
import ar.edu.unju.escminas.dao.IReservaDao;
import ar.edu.unju.escminas.dao.imp.EspecialidadDaoImp;
import ar.edu.unju.escminas.dao.imp.MedicoDaoImp;
import ar.edu.unju.escminas.dao.imp.ObraSocialDaoImp;
import ar.edu.unju.escminas.dao.imp.PacienteDaoImp;
import ar.edu.unju.escminas.dao.imp.ReservaDaoImp;
import ar.edu.unju.escminas.modelo.Especialidad;
import ar.edu.unju.escminas.modelo.Medico;
import ar.edu.unju.escminas.modelo.ObraSocial;
import ar.edu.unju.escminas.modelo.Paciente;
import ar.edu.unju.escminas.modelo.Reserva;



public class Principal {
	
	public static EntityManager manager;
	public static EntityManagerFactory emf;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		IEspecialidadDao especialidadDao= new EspecialidadDaoImp();
		IMedicoDao medicoDao = new MedicoDaoImp();
		IPacienteDao pacienteDao= new PacienteDaoImp();
		IObraSocialDao obraSocialDao = new ObraSocialDaoImp();
		IReservaDao reservaDao = new ReservaDaoImp();
		
		List<Especialidad> especialidades  = especialidadDao.obtenerEspecialidad();
		List<ObraSocial> obraSociales  = obraSocialDao.obtenerObraSocial();
		List<Paciente> pacientes  = pacienteDao.obtenerPaciente();
		List<Medico> medicos  = medicoDao.obtenerMedico();
		
		Scanner sc = new Scanner (System.in);
		int op=0;
		char ex;
		boolean resp = true;
		
		do {
			System.out.println("---------------------------MENU----------------------------");
			System.out.println("1. Dar de alta una especialidad.");
			System.out.println("2. Dar de alta un nuevo médico.");
			System.out.println("3. Dar de alta una obra social.");
			System.out.println("4. Dar de alta un paciente.");
			System.out.println("5. Dar de alta una reserva.");
			System.out.println("6. Consultar las reservas de un médico.");
			System.out.println("7. Mostrar datos de los pacientes de un médico.");
			System.out.println("8. Listar paciente según obra social.");
			System.out.println("9. Listar todas las reservas.");
			System.out.println("10. Eliminar una reserva ingresando el id.");
			System.out.println("11. Listar todos los médicos.");
			System.out.println("12. Listar todas las especialidades.");
			System.out.println("13. Listar todas las obras sociales");
			System.out.println("14. Listar todos los pacientes.");
			
			System.out.println("Ingrese una opción: ");
			op=sc.nextInt();
			
		switch(op) {
		case 1:{
			
			
			Especialidad especialidad= new Especialidad();
			System.out.println("Ingrese Datos del Especialidad:  ");
			System.out.println("Nombre: ");
			especialidad.setNombre(sc.next());
			especialidadDao.guardarEspecialidad(especialidad);
			
			System.out.println("Desea realizar otra operacion? s/n");
			ex = sc.next().charAt(0);
			if(ex == 'n') {
				resp=false;
			
			
			}
			}break;
		case 2:{
			
			Medico medico= new Medico();
			System.out.println("Ingrese Datos del Médico:  ");
			System.out.println("Nombre: ");
			medico.setNombre(sc.next());
			System.out.println("Apellido: ");
			medico.setApellido(sc.next());
			System.out.println("Matricula: ");
			medico.setMatricula(sc.nextInt());
			System.out.println("Dni: ");
			medico.setDni(sc.nextInt());
			System.out.println("Teléfono: ");
			medico.setTelefono(sc.next());
			System.out.println("Seleccione una Especialidad: ");
			int o=1;
			for(Especialidad esp : especialidades) {
				System.out.println(o+". " +esp.getId() + " " + esp.getNombre());
				o++;
			}
			//Se debe ingresar el id de la especialidad
			System.out.println("Especialidad elegida");
			Long cod;
			cod=sc.nextLong();
			Especialidad aux= especialidadDao.buscarEspecialidad(cod);
			medico.setEspecialidad(aux) ;
			//medico.setEspecialidad(especialidades.get(sc.nextInt() - 1));
			
			medicoDao.guardarMedico(medico);
			
			System.out.println("Desea realizar otra operacion? s/n");
			ex = sc.next().charAt(0);
			if(ex == 'n') {
				resp=false;
			
			}
		}break;
		case 3:{
			
			ObraSocial unaObraSocial= new ObraSocial();
			System.out.println("Ingrese la Obra Social:  ");
			System.out.println("Nombre: ");
			unaObraSocial.setNombre(sc.next());
			System.out.println("Direccion: ");
			unaObraSocial.setDireccion(sc.next());
			obraSocialDao.guardarObraSocial(unaObraSocial);
				
			System.out.println("Desea realizar otra operacion? s/n");
			ex = sc.next().charAt(0);
			if(ex == 'n') {
				resp=false;
			
			}
		}break;
			
		case 4:{
			
			Paciente unPaciente= new Paciente();
			System.out.println("Ingrese Datos del Paciente:  ");
			System.out.println("Nombre: ");
			unPaciente.setNombre(sc.next());
			System.out.println("Apellido: ");
			unPaciente.setApellido(sc.next());
			System.out.println("Edad: ");
			unPaciente.setEdad(sc.nextInt());
			System.out.println("Dni: ");
			unPaciente.setDni(sc.nextInt());
			System.out.println("Teléfono: ");
			unPaciente.setTeléfono(sc.next());
			System.out.println("Seleccione una Obra Social: ");
			int o=1;
			for(ObraSocial os : obraSociales) {
				System.out.println(o+". " + os.getId() + " " + os.getNombre());
				o++;
			}
			//Se debe ingresar el id de la obra social
			System.out.println("Obra Social elegida");
			Long cod1;
			cod1=sc.nextLong();
			ObraSocial aux= obraSocialDao.buscarObraSocial(cod1);
			unPaciente.setObraSocial(aux);
			
			pacienteDao.guardarPaciente(unPaciente);
			
			System.out.println("Desea realizar otra operacion? s/n");
			ex = sc.next().charAt(0);
			if(ex == 'n') {
				resp=false;
			
			}
		}break;
			
		case 5:{
			
			int dia, mes, anio, h, m;
			//int s=0;
			LocalDate fecha;
			LocalTime hora;
			
			Reserva unaReserva= new Reserva();
			System.out.println("Ingrese Datos de la Reserva:  ");
			System.out.println("Fecha: ");
			
			System.out.println("Ingrese Día: ");
			dia = sc.nextInt();
			System.out.println("Ingrese Mes: ");
			mes = sc.nextInt();
			System.out.println("Ingrese Año: ");
			anio = sc.nextInt();
			fecha = LocalDate.of(anio, mes, dia);
			//unaNota.setFechaNota(fechaN);
			System.out.println("Ingrese Hora: ");
			h = sc.nextInt();
			System.out.println("Ingrese Minutos: ");
			m = sc.nextInt();
	        hora=LocalTime.of(h, m);
	        LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);
	        unaReserva.setFechaHora(fechaHora);
			
			System.out.println("Seleccione un Paciente: ");
			int o=1;
			for(Paciente pa : pacientes ) {
				System.out.println(o+". " + pa.getDni() + " " + pa.getNombre());
				o++;
			}
			//Se debe ingresar el dni del paciente
			System.out.println("Ingrese el DNI del paciente");
			int dni;
			dni=sc.nextInt();
			Paciente aux= pacienteDao.buscarPaciente(dni);
			unaReserva.setPaciente(aux);
			
			System.out.println("Seleccione un Medico: ");
			int j=1;
			for(Medico med : medicos ) {
				System.out.println(o+". " + med.getMatricula()  + " " + med.getNombre());
				j++;
			}
			//Se debe ingresar la matricula del Medico
			System.out.println("Ingrese la matricula del médico: ");
			int matricula;
			matricula=sc.nextInt();
			Medico aux1= medicoDao.buscarMedico(matricula);
			unaReserva.setMedico(aux1);
			System.out.println("Ingrese consultorio: ");
			unaReserva.setConsultorio(sc.nextInt());
			
			reservaDao.guardarReserva(unaReserva);
			
			System.out.println("Desea realizar otra operacion? s/n");
			ex = sc.next().charAt(0);
			if(ex == 'n') {
				resp=false;
			
			}
				
				
			
		}break;
		
		case 6:{
			
			
			
		
			
		}break;
		
		case 7:{
			
			
			
		
			
		}break;
		case 8:{
			
			
			
		
			
		}break;
		case 9:{
			
			
			
		
			
		}break;
		case 10:{
			
			
			
		
			
		}break;
		case 11:{
			
			
			
		
			
		}break;
		case 12:{
			
			
			
		
			
		}break;
		case 13:{
			
			
			
		
			
		}break;
		case 14:{
			
			
			
		
			
		}break;
		
	
		}	
		} while(resp == true);
		
		sc.close();
		

	}

}
