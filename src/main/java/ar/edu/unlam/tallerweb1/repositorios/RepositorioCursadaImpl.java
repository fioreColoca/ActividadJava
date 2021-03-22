package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Cursada;
import ar.edu.unlam.tallerweb1.modelo.Curso;


@Repository
public class RepositorioCursadaImpl implements RepositorioCursada {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void registrar(Cursada cursada) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cursada);
	}

	@Override
	public List<Cursada> mostrarCursadasPorAlumno(Alumno alumno) {
		return sessionFactory.getCurrentSession().createCriteria(Cursada.class)
				.add(Restrictions.eq("alumno", alumno)).list();
	}

	@Override
	public List<Cursada> mostrarAlumnoPorCursada(Curso curso) {
		return sessionFactory.getCurrentSession().createCriteria(Cursada.class)
				.add(Restrictions.eq("curso", curso)).list();
	}

	@Override
	public Cursada buscarCursada(Alumno alumno, Curso curso) {
		return (Cursada) sessionFactory.getCurrentSession().createCriteria(Cursada.class)
				.add(Restrictions.and(Restrictions.eq("alumno", alumno), Restrictions.in("curso", curso)))
				.uniqueResult();
	}

	@Override
	public void eliminar(Cursada cursada) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cursada);
	}
	
	
	
}
