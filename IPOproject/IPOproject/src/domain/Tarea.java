package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Tarea {
	private String nombre;
	private Boolean IsSubtarea;
	private Calendar fechacreacion;
	private Calendar fechafinal;
	private User responsable;
	private String prioridad;
	private String estado;
	private ArrayList<User> miembros;
	private String comentarios;
	private ArrayList<Tarea> subtareas;
	private ArrayList<String> listaimagenes;



	public Tarea(String nombre, Calendar fechacreacion, Calendar fechafinal, User responsable,
			String prioridad, String estado, String comentarios, ArrayList<User> miembros ) {
		this.miembros = miembros;
		this.nombre = nombre;
		this.fechacreacion = fechacreacion;
		this.fechafinal = fechafinal;
		this.responsable = responsable;
		this.prioridad = prioridad;
		this.estado = estado;
		this.comentarios = comentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Calendar fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Calendar getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(Calendar fechafinal) {
		this.fechafinal = fechafinal;
	}

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<User> getMiembros() {
		return miembros;
	}

	public void setMiembros(ArrayList<User> miembros) {
		this.miembros = miembros;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String toString() {
		return nombre;
	}
	
	public ArrayList<Tarea> getSubtareas() {
		return subtareas;
	}

	public void setSubtareas(ArrayList<Tarea> subtareas) {
		this.subtareas = subtareas;
	}
	
	public Boolean getIsSubtarea() {
		return IsSubtarea;
	}

	public void setIsSubtarea(Boolean isSubtarea) {
		IsSubtarea = isSubtarea;
	}

	public ArrayList<String> getListaimagenes() {
		return listaimagenes;
	}

	public void setListaimagenes(ArrayList<String> listaimagenes) {
		this.listaimagenes = listaimagenes;
	}

}
