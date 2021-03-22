package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Cursada;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlumno;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlumno;
import ar.edu.unlam.tallerweb1.servicios.ServicioCursada;
import ar.edu.unlam.tallerweb1.servicios.ServicioCurso;


@Controller
public class ControladorCursada {

	@Inject
	private ServicioCursada servicioCursada;
	
	@Inject
	private ServicioAlumno servicioAlumno;
	
	
	@Inject
	private ServicioCurso servicioCursos;

	
	@RequestMapping(path = "/inscripcion", method = RequestMethod.GET)
	public ModelAndView inscripcion(@RequestParam(value = "idAlumno", required = true) Long id) {

		ModelMap modelo = new ModelMap();
	
		Alumno alumno = servicioAlumno.buscarAlumno(id);
		/*
		List<Curso> listaCursos = servicioCursada.buscarCursosQueNoEsta(alumno); */
		List<Curso> listaCursos = servicioCursos.devolverCursos();
				
		modelo.put("title", "Cursada | Inscripcion");
		modelo.put("alumno", alumno);
		modelo.put("cursos",listaCursos);
		return new ModelAndView("Inscripcion", modelo);
	}
	
	@RequestMapping(path = "/alumnoIncripcionCurso", method = RequestMethod.GET)
	public ModelAndView alumnoIncripcionCurso(@RequestParam(value = "idAlumno", required = true) Long idNombre,
			@RequestParam(value = "idCurso", required = true) Long idCurso,
			HttpServletRequest request) {
		
		Alumno alumno = servicioAlumno.buscarAlumno(idNombre);
		Curso curso = servicioCursos.buscarCurso(idCurso);
		Cursada cursada = new Cursada();
		cursada.setAlumno(alumno);
		cursada.setCurso(curso);
		
		servicioCursada.registrarCursada(cursada);
		

		return new ModelAndView("redirect:/alumnos");
	}
	
	@RequestMapping(path = "/cursosDelAlumno", method = RequestMethod.GET)
	public ModelAndView cursosDelAlumno(@RequestParam(value = "idAlumno", required = true) Long idAlumno,
			HttpServletRequest request) {
		
		Alumno alumno = servicioAlumno.buscarAlumno(idAlumno);
		List<Curso> ListaCursos = servicioCursada.buscarCursosPorAlumno(alumno);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("title", "Cursos | Alumno");
		modelo.put("alumno", alumno);
		modelo.put("cursos",ListaCursos);	
		
		return new ModelAndView("cursosAsisteAlumno",modelo);
	}
	
	@RequestMapping(path = "/alumnosDelCurso", method = RequestMethod.GET)
	public ModelAndView alumnosDelCurso(@RequestParam(value = "idCurso", required = true) Long idCurso,
			HttpServletRequest request) {
		
		Curso curso = servicioCursos.buscarCurso(idCurso);
		List<Alumno> ListaAlumnos = servicioCursada.buscarAlumnoPorCurso(curso);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("title", "Alumnos | Curso");
		modelo.put("alumnos", ListaAlumnos);
		modelo.put("curso",curso);	
		
		return new ModelAndView("alumnosDelCurso",modelo);
	}
	
	@RequestMapping(path = "/eliminarAlumnoDelCurso")
	public ModelAndView eliminarAlumnoDelCurso(@RequestParam(value = "idCurso", required = true) Long idCurso, 
			@RequestParam(value = "idAlumno", required = true) Long idAlumno, 
		
			HttpServletRequest request) {
		Alumno alumno = servicioAlumno.buscarAlumno(idAlumno);
		Curso curso = servicioCursos.buscarCurso(idCurso);
		
		servicioCursada.eliminar(alumno,curso);
		
		String estadoAuxiliar = "alumno";
		
		
		return new ModelAndView("redirect:/cursos");
		
	}
	
	
}
