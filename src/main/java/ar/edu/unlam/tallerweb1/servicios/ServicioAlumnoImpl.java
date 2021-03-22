package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlumno;

@Service
@Transactional
public class ServicioAlumnoImpl implements ServicioAlumno {

	@Inject
	private RepositorioAlumno repositorioAlumno;

	@Override
	public List<Alumno> devolverAlumnos() {
		List<Alumno> listado = repositorioAlumno.mostrarTodosLosAlumnos();
		List<Alumno> nuevaLista = new ArrayList<Alumno>();

		for (Alumno alumno : listado) {
			if (alumno.getEliminado() == false) {
				nuevaLista.add(alumno);
			}
		}
		return nuevaLista;

	}

	@Override
	public void registrarAlumno(Alumno alumno) {
		repositorioAlumno.registrarAlumno(alumno);
	}

	@Override
	public Alumno buscarAlumno(Long id) {
		return repositorioAlumno.mostrarAlumno(id);
	}

	@Override
	public void eliminarAlumno(Long id) {
		Alumno alumno = repositorioAlumno.mostrarAlumno(id);
		alumno.setEliminado(true);
	}

}
