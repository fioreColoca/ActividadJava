package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Cursada;
import ar.edu.unlam.tallerweb1.modelo.Curso;

public interface ServicioCursada {
	
	void registrarCursada(Cursada cursada);
	
	/*List<Curso> buscarCursosQueNoEsta (Alumno alumno); */
	
	List<Curso> buscarCursosPorAlumno (Alumno alumno);
	
	List<Alumno> buscarAlumnoPorCurso (Curso curso);

	Cursada buscarCursada(Alumno alumno, Curso curso);
	
	void eliminar(Alumno alumno, Curso curso);

}
