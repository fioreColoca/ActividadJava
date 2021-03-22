package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Alumno;


public interface ServicioAlumno {

	List<Alumno> devolverAlumnos();
	
	void registrarAlumno(Alumno alumno);
	
	Alumno buscarAlumno(Long id);
	
	void eliminarAlumno(Long id);
	
}
