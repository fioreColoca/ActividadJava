package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Curso;

public interface ServicioCurso {
	
	
	List<Curso> devolverCursos();
	
	void registrarCurso(Curso curso);
	
	Curso buscarCurso(Long id);
	
	void eliminarCurso(Long id);
	
}
