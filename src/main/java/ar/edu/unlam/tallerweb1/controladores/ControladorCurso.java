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

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.servicios.ServicioCurso;

@Controller
public class ControladorCurso {

	@Inject
	private ServicioCurso servicioCursos;

	@RequestMapping(path = "/cursoRegistrado", method = RequestMethod.GET)
	public ModelAndView cursoRegistrado(@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "comision", required = true) String comision,
			@RequestParam(value = "cantidadMaxima", required = true) Integer cantidadMaxima,

			HttpServletRequest request) {

		Curso curso = new Curso();
		curso.setEliminado(false);
		curso.setNombreDelCurso(nombre);
		curso.setCantidadMaximaAlumno(cantidadMaxima);
		curso.setComision(comision);
		curso.setCantidadALumnos(0);

		servicioCursos.registrarCurso(curso);

		return new ModelAndView("redirect:/cursos");
	}

	@RequestMapping(path = "/cursos", method = RequestMethod.GET)
	public ModelAndView irVerCuros() {

		ModelMap modelo = new ModelMap();
		List<Curso> cursos = servicioCursos.devolverCursos();

		modelo.put("cursos", cursos);
		modelo.put("title", "Actividad | Cursos");
		return new ModelAndView("cursos", modelo);
	}

	@RequestMapping(path = "/RegistrarCurso", method = RequestMethod.GET)
	public ModelAndView registrarCurso() {
		return new ModelAndView("RegistrarCurso");
	}
}
