package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Curso;

public interface RepositorioCurso {
	
	List<Curso>mostrarTodosLosCursos();
	
	void registrarCurso(Curso curso);
}
