package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Cursada;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlumno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCursada;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCurso;

@Service
@Transactional
public class ServicioCursadaImpl implements ServicioCursada {

	@Inject
	private RepositorioCursada repositorioCursada;

	@Inject
	private RepositorioCurso repositorioCurso;

	@Inject
	private RepositorioAlumno repositorioAlumno;

	@Override
	public void registrarCursada(Cursada cursada) {
		repositorioCursada.registrar(cursada);
	}
	
	
	

	@Override
	public List<Curso> buscarCursosPorAlumno(Alumno alumno) {
		List<Cursada> listaCursada = repositorioCursada.mostrarCursadasPorAlumno(alumno);
		List<Curso> ListaCurso = repositorioCurso.mostrarTodosLosCursos();
		List<Curso> ListaCursoAlumno = new ArrayList<Curso>();

		for (Cursada cursada : listaCursada) {
			for (Curso curso : ListaCurso) {
				if (cursada.getCurso().getId() == curso.getId()) {
					ListaCursoAlumno.add(curso);
				}
			}
		}
		return ListaCursoAlumno;

	}

	@Override
	public List<Alumno> buscarAlumnoPorCurso(Curso curso) {
		List<Cursada> listaCursada = repositorioCursada.mostrarAlumnoPorCursada(curso);
		List<Alumno> ListaAlumno = repositorioAlumno.mostrarTodosLosAlumnos();
		List<Alumno> ListaAlumnoCurso = new ArrayList<Alumno>();

		for (Cursada cursada : listaCursada) {
			for (Alumno alumno : ListaAlumno) {
				if (cursada.getAlumno().getId() == alumno.getId()) {
					ListaAlumnoCurso.add(alumno);
				}
			}
		}
		return ListaAlumnoCurso;
	}




	@Override
	public Cursada buscarCursada(Alumno alumno, Curso curso) {
		return repositorioCursada.buscarCursada(alumno, curso);
	}




	@Override
	public void eliminar(Alumno alumno, Curso curso) {
		Cursada cursada = buscarCursada(alumno,curso);
		repositorioCursada.eliminar(cursada);
	}



/*
	@Override
	public List<Curso> buscarCursosQueNoEsta(Alumno alumno) {
		
		List<Curso> ListaCurso = repositorioCurso.mostrarTodosLosCursos();
		List<Curso> ListaCursoAlumno = buscarCursosPorAlumno(alumno);
		List<Curso> ListaNueva = new ArrayList<Curso>();
		
		for (Curso cursada : ListaCurso) {
			for (Curso curso : ListaCursoAlumno) {
				if(cursada.getId() != curso.getId()) {
					ListaNueva.add(curso);
				}
			}
		} return ListaNueva;
	} */

}
