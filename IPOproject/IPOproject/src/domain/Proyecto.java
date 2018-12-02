package domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Proyecto {
	private String nombre;
	private Calendar fechacreación;
	private String descripción;
	private User responsable;
	private ArrayList<User> miembros;
	private ArrayList<Tarea> tareas;

	public Proyecto(String nombre, Calendar fechacreación, String descripción, User responsable, ArrayList<User> miembros, ArrayList<Tarea> tareas) {
		this.nombre = nombre;
		this.fechacreación = fechacreación;
		this.descripción = descripción;
		this.responsable = responsable;
		this.miembros = miembros;
		this.tareas = tareas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechacreación() {
		return fechacreación;
	}

	public void setFechacreación(Calendar fechacreación) {
		this.fechacreación = fechacreación;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}

	public ArrayList<User> getMiembros() {
		return miembros;
	}

	public void setMiembros(ArrayList<User> miembros) {
		this.miembros = miembros;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
	public String toString() {
		return nombre;
	}

}
