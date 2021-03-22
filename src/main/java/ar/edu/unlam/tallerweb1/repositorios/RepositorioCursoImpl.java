package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Curso;

@Repository
public class RepositorioCursoImpl implements RepositorioCurso {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Curso> mostrarTodosLosCursos() {
		return sessionFactory.getCurrentSession().createCriteria(Curso.class).list();
	}

	@Override
	public void registrarCurso(Curso curso) {
		Session session = sessionFactory.getCurrentSession();
		session.save(curso);
	}
	
	
	

}
