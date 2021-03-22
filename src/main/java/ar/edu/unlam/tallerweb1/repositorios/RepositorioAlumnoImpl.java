package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Alumno;

@Repository
public class RepositorioAlumnoImpl implements RepositorioAlumno{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Alumno> mostrarTodosLosAlumnos() {
		return sessionFactory.getCurrentSession().createCriteria(Alumno.class).list();
	}

	@Override
	public void registrarAlumno(Alumno alumno) {
		Session session = sessionFactory.getCurrentSession();
		session.save(alumno);
	}

	@Override
	public Alumno mostrarAlumno(Long id) {
		return  sessionFactory.getCurrentSession().get(Alumno.class, id);
	}
	
	

}
