package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlumno;

@Controller
public class ControladorAlumno {

	@Inject
	private ServicioAlumno servicioAlumno;

	@RequestMapping(path = "/alumnoRegistrado", method = RequestMethod.GET)
	public ModelAndView alumnoRegistrado(@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "apellido", required = true) String apellido,
			@RequestParam(value = "dni", required = true) Integer dni,

			HttpServletRequest request) {

		Alumno alumno = new Alumno();

		alumno.setEliminado(false);
		alumno.setNombre(nombre);
		alumno.setApellido(apellido);
		alumno.setDni(dni);
		servicioAlumno.registrarAlumno(alumno);

		return new ModelAndView("redirect:/alumnos");
	}

	@RequestMapping(path = "/alumnos", method = RequestMethod.GET)
	public ModelAndView irVerAlumnos() {

		ModelMap modelo = new ModelMap();

		List<Alumno> alumnos = servicioAlumno.devolverAlumnos();

		modelo.put("title", "Actividad | Alumnos");
		modelo.put("alumnos", alumnos);

		return new ModelAndView("alumnos", modelo);
	}

	@RequestMapping(path = "/RegistrarAlumno", method = RequestMethod.GET)
	public ModelAndView registrarAlumnos() {
		return new ModelAndView("RegistrarAlumno");
	}
	
	
	@RequestMapping(path = "/eliminarAlumno")
	public ModelAndView eliminarAlumno(@RequestParam(value = "botonBorrar", required = true) Long idAlumno,
			HttpServletRequest request) {
		
		Alumno alumnoAEliminar = servicioAlumno.buscarAlumno(idAlumno);
		
		alumnoAEliminar.setEliminado(true);
		
		return new ModelAndView("redirect:/home");
	}

}
