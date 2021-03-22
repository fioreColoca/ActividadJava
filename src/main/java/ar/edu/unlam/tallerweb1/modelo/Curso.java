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
	
	private String nombreDelCurso;
	private String comision;
	private Boolean eliminado;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	
	
	
	
}
