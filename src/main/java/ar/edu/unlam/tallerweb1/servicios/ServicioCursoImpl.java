package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCurso;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioCursoImpl implements ServicioCurso {

@Inject
private RepositorioCurso repositorioCurso;

	@Override
	public List<Curso> devolverCursos() {
	
		return repositorioCurso.mostrarTodosLosCursos();
	}

	@Override
	public void registrarCurso(Curso curso) {
		repositorioCurso.registrarCurso(curso);
	}




}
