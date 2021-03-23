package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Cursada;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCursada;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCurso;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServicioCursoImpl implements ServicioCurso {

	@Inject
	private RepositorioCurso repositorioCurso;
	
	@Inject
	private RepositorioCursada repositorioCursada;
	
	@Inject
	private ServicioCursada servicioCursada;


	@Override
	public List<Curso> devolverCursos() {
		List<Curso> listado = repositorioCurso.mostrarTodosLosCursos();
		List<Curso> nuevaLista = new ArrayList<Curso>();

		for (Curso curso : listado) {
			if (curso.getEliminado() == false) {
				nuevaLista.add(curso);
			}
		}
		return nuevaLista;

	}

	@Override
	public void registrarCurso(Curso curso) {
		repositorioCurso.registrarCurso(curso);
	}

	@Override
	public Curso buscarCurso(Long id) {
		return repositorioCurso.mostrarCurso(id);
	}

	@Override
	public void eliminarCurso(Long id) {
		
		Curso curso = buscarCurso(id);
		List<Cursada> listado = servicioCursada.buscarCursadasPorCurso(curso);

		Curso cursoEliminar = buscarCurso(id);
		
		for(Cursada cursada : listado) {
			repositorioCursada.eliminar(cursada);
		}
		cursoEliminar.setEliminado(true);
	}


}
