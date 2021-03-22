package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Alumno;


public interface RepositorioAlumno {

	List<Alumno> mostrarTodosLosAlumnos();

	void registrarAlumno(Alumno alumno);
	
	Alumno mostrarAlumno(Long id);
}
