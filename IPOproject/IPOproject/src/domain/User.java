package domain;

import java.util.ArrayList;

public class User {

	private String nickname;
	private String nombre;
	private String dni;
	private String apellido;
	private String formacion;
	private String titulo;
	private String telefono;
	private String dirección;
	private ArrayList<Tarea> tareas;
	private ArrayList<Proyecto> proyectos;
	private String image;
	private String lastconnect;
	
	public User(String nickname, String nombre, String dni, String apellido, String formacion, String titulo,
			String telefono, String dirección) {
		this.nickname = nickname;
		this.nombre = nombre;
		this.dni = dni;
		this.apellido = apellido;
		this.formacion = formacion;
		this.titulo = titulo;
		this.telefono = telefono;
		this.dirección = dirección;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFormacion() {
		return formacion;
	}

	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(ArrayList<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	public String toString() {
		return nickname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLastconnect() {
		return lastconnect;
	}

	public void setLastconnect(String lastconnect) {
		this.lastconnect = lastconnect;
	}
	
	
}
