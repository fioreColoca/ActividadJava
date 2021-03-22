package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Cursada;
import ar.edu.unlam.tallerweb1.modelo.Curso;

public interface RepositorioCursada {

	void registrar(Cursada cursada);

	List<Cursada> mostrarCursadasPorAlumno(Alumno alumno);

	List<Cursada> mostrarAlumnoPorCursada(Curso curso);
	
	Cursada buscarCursada(Alumno alumno, Curso curso);
	
	void eliminar(Cursada cursada);

}
