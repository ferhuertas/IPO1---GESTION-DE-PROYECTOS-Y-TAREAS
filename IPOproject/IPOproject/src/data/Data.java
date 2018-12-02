package data;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import domain.Tarea;
import domain.Proyecto;
import domain.User;

public class Data {
	public ArrayList<User> listaUsuarios;
	
	public ArrayList<User> miembrostarea1;
	public ArrayList<User> miembrostarea2;
	public ArrayList<User> miembrostarea3;
	public ArrayList<User> miembrostarea4;	
	public ArrayList<User> miembrostarea5;

	public ArrayList<User> miembrosproyecto1;
	public ArrayList<User> miembrosproyecto2;
	
	public ArrayList<Proyecto> listaProyectos;
	public ArrayList<Tarea> listaTareas;
	public ArrayList <String> listaImagenes;
	
	public Data() {
		initialize();
	}
	
	public void initialize() {
		
		//Cargar Imagenes del sistema
		listaImagenes= new ArrayList<String>();
		listaImagenes.add("/cachorro-tigre.jpg");
		listaImagenes.add("/caballitodemar.jpg");
		
		
		//Crear Usuarios
		
		User user1 = new User("admin", "Fernando", "01652", "Huertas", "Universitaria", "Ingeniero informatico",
				"658954", "Calle falsa 123");
		User user2 = new User("buwe", "Javi", "016das52", "Abengozar", "Universitaria", "Ingeniero informatico",
				"6584445954", "Calle verdad 1243");
		User user3 = new User("chapela", "Carlos", "016dadas52", "Luz", "Universitaria", "Ingeniero industrial",
				"6584755954", "Calle media 1243");
		User user4 = new User("epxon", "Santi", "016das52", "Lucas", "Universitaria", "Ciencias",
				"651155954", "Calle cuarta 1243");
		
		listaUsuarios= new ArrayList<User>();
		listaUsuarios.add(user1);
		listaUsuarios.add(user2);
		listaUsuarios.add(user3);
		listaUsuarios.add(user4);
		
		//Crear equipos
		miembrostarea1 = new ArrayList<User>();
		miembrostarea1.add(user1);
		miembrostarea1.add(user2);

		miembrostarea2 = new ArrayList<User>();
		miembrostarea2.add(user1);
		miembrostarea2.add(user3);
		
		miembrostarea3 = new ArrayList<User>();
		miembrostarea3.add(user2);
		miembrostarea3.add(user3);
		
		miembrostarea4 = new ArrayList<User>();
		miembrostarea4.add(user2);
		miembrostarea4.add(user3);
		
		miembrostarea5 = new ArrayList<User>();
		miembrostarea5.add(user2);
		miembrostarea5.add(user3);
		miembrostarea5.add(user4);

		//miembros proyectos
		miembrosproyecto1 = new ArrayList<User>();
		miembrosproyecto1.add(user1);
		miembrosproyecto1.add(user2);
		miembrosproyecto1.add(user3);
		
		miembrosproyecto2 = new ArrayList<User>();
		miembrosproyecto2.add(user2);
		miembrosproyecto2.add(user3);
		miembrosproyecto2.add(user4);
		
		//Crear Tareas
		Tarea tarea1= new Tarea("Tarea 1", new GregorianCalendar(2016,02,21), new GregorianCalendar(2017,01,11), user1,
				"Alta", "Completada", "Este es un ejemplo de la Tarea 1", miembrostarea1);
		Tarea tarea2= new Tarea("Tarea 2", new GregorianCalendar(2015,01,14), new GregorianCalendar(2018,02,13), user1,
					"Media", "Activa", "Este es un ejemplo de la Tarea 2", miembrostarea2);
		Tarea tarea3= new Tarea("Tarea 3", new GregorianCalendar(2016,01,14), new GregorianCalendar(2017,02,22), user2,
				"Baja", "Completada", "Este es un ejemplo de la Tarea 3", miembrostarea3);
		Tarea tarea4= new Tarea("Tarea 4", new GregorianCalendar(2015,05,11), new GregorianCalendar(2019,05,17), user3,
					"Media", "Activa", "Este es un ejemplo de la Tarea 4", miembrostarea4);
		Tarea tarea5= new Tarea("Tarea 5", new GregorianCalendar(2013,07,07), new GregorianCalendar(2017,9,07), user4,
				"Alta", "Tardia", "Este es un ejemplo de la Tarea 5", miembrostarea5);
		
		tarea1.setIsSubtarea(false);
		tarea2.setIsSubtarea(false);
		tarea3.setIsSubtarea(false);
		tarea4.setIsSubtarea(false);
		tarea5.setIsSubtarea(false);
		
		//subtareas
		Tarea subtarea1_1= new Tarea("SubTarea 1.1", new GregorianCalendar(2016,02,21), new GregorianCalendar(2017,01,11), user1,
				"Alta", "Completada", "Este es un ejemplo de la SubTarea 1.1", miembrostarea1);
		Tarea subtarea1_2= new Tarea("SubTarea 1.2", new GregorianCalendar(2015,01,14), new GregorianCalendar(2018,02,13), user1,
					"Media", "Activa", "Este es un ejemplo de la SubTarea 1.2", miembrostarea1);
		Tarea subtarea4_1= new Tarea("SubTarea 4.1", new GregorianCalendar(2016,01,14), new GregorianCalendar(2017,02,22), user3,
				"Baja", "Completada", "Este es un ejemplo de la SubTarea 4.1", miembrostarea4);
		Tarea subtarea5_1= new Tarea("SubTarea 5.1", new GregorianCalendar(2015,05,11), new GregorianCalendar(2019,05,17), user4,
					"Media", "Activa", "Este es un ejemplo de la SubTarea 5.1", miembrostarea5);
		Tarea subtarea5_2= new Tarea("SubTarea 5.2", new GregorianCalendar(2013,07,07), new GregorianCalendar(2017,9,07), user4,
				"Alta", "Tardia", "Este es un ejemplo de la SubTarea 5.2", miembrostarea5);
		
		subtarea1_1.setIsSubtarea(true);
		subtarea1_2.setIsSubtarea(true);
		subtarea4_1.setIsSubtarea(true);
		subtarea5_1.setIsSubtarea(true);
		subtarea5_2.setIsSubtarea(true);
		
		ArrayList <Tarea> listasubTareas1 = new ArrayList<Tarea>();
		listasubTareas1.add(subtarea1_1);
		listasubTareas1.add(subtarea1_2);
		tarea1.setSubtareas(listasubTareas1);
		
		ArrayList <Tarea> listasubTareas4 = new ArrayList<Tarea>();
		listasubTareas4.add(subtarea4_1);
		tarea4.setSubtareas(listasubTareas4);
		
		ArrayList <Tarea> listasubTareas5 = new ArrayList<Tarea>();
		listasubTareas5.add(subtarea5_1);
		listasubTareas5.add(subtarea5_2);
		tarea5.setSubtareas(listasubTareas5);
		
		
		
		//Crear Lista de Tareas
		ArrayList<Tarea> listaTareas1 = new ArrayList<Tarea>();
		listaTareas1.add(tarea1);
		listaTareas1.add(tarea2);
		listaTareas1.add(tarea3);

		
		ArrayList<Tarea> listaTareas2 = new ArrayList<Tarea>();
		listaTareas2.add(tarea4);
		listaTareas2.add(tarea5);
		
		listaTareas = new ArrayList<Tarea>();
		listaTareas.add(tarea1);
		listaTareas.add(tarea2);
		listaTareas.add(tarea3);
		listaTareas.add(tarea4);
		listaTareas.add(tarea5);

		
		//Crear Proyectos
		
		Proyecto proyecto1=new Proyecto("Proyecto 1", new GregorianCalendar(2015,10,24), "Este es un ejemplo de un proyecto", user1, miembrosproyecto1, listaTareas1);
		Proyecto proyecto2= new Proyecto("Proyecto 2", new GregorianCalendar(2016,07,18), "Este es un ejemplo de un proyecto2", user2, miembrosproyecto2, listaTareas2);
		
		listaProyectos = new ArrayList<Proyecto>();
		listaProyectos.add(proyecto1);
		listaProyectos.add(proyecto2);
	}
}
