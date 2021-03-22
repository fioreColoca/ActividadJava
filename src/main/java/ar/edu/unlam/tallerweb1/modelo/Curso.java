package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidadMaximaAlumno;
	private String nombreDelCurso;
	private String comision;
	private Integer  cantidadALumnos;
	private Boolean eliminado;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidadMaximaAlumno() {
		return cantidadMaximaAlumno;
	}

	public void setCantidadMaximaAlumno(Integer cantidadMaximaAlumno) {
		this.cantidadMaximaAlumno = cantidadMaximaAlumno;
	}

	public String getNombreDelCurso() {
		return nombreDelCurso;
	}

	public void setNombreDelCurso(String nombreDelCurso) {
		this.nombreDelCurso = nombreDelCurso;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}


	public Integer getCantidadALumnos() {
		return cantidadALumnos;
	}

	public void setCantidadALumnos(Integer cantidadALumnos) {
		this.cantidadALumnos = cantidadALumnos;
	}


	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
	
	
	
}
