package escuela;

import java.util.Scanner;

/**
 * Clase que representa el programa de gestion de centros educativos.
 */
public class ProgramaGestionCentros 
{
	private Gestor miGestor;
	
	/**
     * Metodo principal que inicia el programa.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgramaGestionCentros programa = new ProgramaGestionCentros();
		
		System.out.println("Bienvenido al software de gestión de centros educativos.");
		
		int accion = programa.pintarMenuPrincipal();
		
		while(accion != 4)
		{
			accion = programa.pintarMenuPrincipal();
		}
	}
	
	/**
     * Constructor de la clase ProgramaGestionCentros.
     */
	public ProgramaGestionCentros() 
	{
		miGestor = new Gestor();
	}

	
	/**
     * Muestra el menu principal y solicita una accion al usuario.
     * @return La accion seleccionada por el usuario.
     */
	private int pintarMenuPrincipal() 
	{
		int accion = -1;
		System.out.println("--------------------------------------------");
		System.out.println("Por favor, escoja una de las opciones válidas:");
		System.out.println("--------------------------------------------");
		
		System.out.println("1. Menú de profesores.");
		System.out.println("2. Menú de asignaturas.");
		System.out.println("3. Menú de alumnos.");
		System.out.println("4. Salir del gestor.");
		
		System.out.println("--------------------------------------------");
		
		Scanner teclado = new Scanner(System.in);
		
		while(accion < 0) 
		{
			try 
			{
				System.out.println("OPCIÓN: ");
				int valor = teclado.nextInt();
				
				if (valor >= 1 && valor <= 4) 
				{
					accion = valor;
					
					switch(accion) 
					{
						case 1: 
							accionesProfesores();
							break;
						case 2: 
							accionesAsignaturas();
							break;
						case 3: 
							accionesAlumnos();
							break;
						case 4:
							System.out.println("Gracias por usar nuestro software.");
							System.out.println("CERRANDO...");
							break;
					}
				}
				else
					System.out.println("Por favor, seleccione una opción válida [1-4].");
			}
			catch(Exception ex) 
			{
				teclado.nextLine();
				System.out.println("Por favor, seleccione una opción válida [1-4].");
			}
		}
		
		return accion;
	}
	
	/**
     * Realiza las acciones relacionadas con los profesores.
     */
	private void accionesProfesores() {
		int accion =  pintarMenuProfesores();
		
		while (accion != 3) 
		{
			switch(accion) 
			{
				case 1:
					boolean ok = this.miGestor.insertarProfesor();
					if(!ok) 
					{
						System.out.println("Máximo de profesores alcanzado");
					}
					break;
				case 2:
					this.miGestor.consultarProfesores();
					break;
//				case 3:
//					this.miGestor.borrarProfesor();
//					break;
			}
			
			accion =  pintarMenuProfesores();
		}
	}

	/**
     * Muestra el menu de opciones relacionadas con los profesores.
     * @return La acción seleccionada por el usuario.
     */
	private int pintarMenuProfesores() 
	{
		int accion = -1;
		System.out.println("--------------------------------------------");
		System.out.println("PROFESORES:");
		System.out.println("--------------------------------------------");
		
		System.out.println("1. Añadir profesor.");
		System.out.println("2. Consultar datos profesor.");
		//System.out.println("3. Borrar profesor.");
		System.out.println("3. Volver.");
		
		System.out.println("--------------------------------------------");
		Scanner teclado = new Scanner(System.in);
		
		while(accion < 0) 
		{
			try 
			{
				System.out.println("OPCIÓN: ");
				int valor = teclado.nextInt();
				
				if (valor >= 1 && valor <= 3) 
				{
					accion = valor;
				}
				else
					System.out.println("Por favor, seleccione una opción válida [1-3].");
			}
			catch(Exception ex) 
			{
				teclado.nextLine();
				System.out.println("Por favor, seleccione una opción válida [1-3].");
			}
		}
		
		return accion;
	}
	
	/**
     * Realiza las acciones relacionadas con los alumnos.
     */
	private void accionesAlumnos() 
	{
		int accion =  pintarMenuAlumnos();
		
		while (accion != 3) 
		{
			//Hago las acciones
			switch(accion) 
			{
				case 1:
					boolean ok = this.miGestor.insertarAlumno();
					if(!ok) 
					{
						System.out.println("Máximo de alumnos alcanzado");
					}
					break;
				case 2:
					this.miGestor.consultarAlumnos();
					break;
//				case 3:
//					this.miGestor.borrarAlumno();
//					break;
			}
			
			accion =  pintarMenuAlumnos();
		}
	}
	
	/**
     * Muestra el menu de opciones relacionadas con los alumnos.
     * @return La accion seleccionada por el usuario.
     */
	private int pintarMenuAlumnos() 
	{
		int accion = -1;
		System.out.println("--------------------------------------------");
		System.out.println("Alumnos:");
		System.out.println("--------------------------------------------");
		
		System.out.println("1. Añadir alumno.");
		System.out.println("2. Consultar alumnos.");
		//System.out.println("3. Borrar alumno.");
		System.out.println("3. Volver.");
		
		System.out.println("--------------------------------------------");
		Scanner teclado = new Scanner(System.in);
		
		while(accion < 0) 
		{
			try 
			{
				System.out.println("OPCIÓN: ");
				int valor = teclado.nextInt();
				
				if (valor >= 1 && valor <= 3)
				{
					accion = valor;
				}
				else
					System.out.println("Por favor, seleccione una opción válida [1-3].");
			}
			catch(Exception ex) 
			{
				teclado.nextLine();
				System.out.println("Por favor, seleccione una opción válida [1-3].");
			}
		}
		
		return accion;
	}
	
	/**
     * Realiza las acciones relacionadas con las asignaturas.
     */
	private void accionesAsignaturas() 
	{
		int accion =  pintarMenuAsignaturas();
		
		while (accion != 8) 
		{
			//Hago las acciones
			switch(accion) 
			{
				case 1:
					boolean ok = this.miGestor.insertarAsignatura();
					
					if(!ok) 
					{
						System.out.println("Máximo de asignaturas alcanzado");
					}
					break;
				case 2:
					this.miGestor.consultarAsignaturas();
					break;
				case 3:
					this.miGestor.asignarProfesor();
					break;
				case 4:
					this.miGestor.matricularAlumno();
					break;
				case 5:
					this.miGestor.ponerNotaAlumno();
					break;
				case 6:
					this.miGestor.borrarAsignatura();
					break;
				case 7:
					this.miGestor.desmatricularAlumno();
					break;
			}
			
			accion =  pintarMenuAsignaturas();
		}
	}
	
	/**
     * Muestra el menu de opciones relacionadas con las asignaturas.
     * @return La accion seleccionada por el usuario.
     */
	private int pintarMenuAsignaturas() 
	{
		int accion = -1;
		
		System.out.println("--------------------------------------------");
		System.out.println("ASIGNATURAS:");
		System.out.println("---------------------------------------------");
		
		System.out.println("1. Añadir asignatura.");
		System.out.println("2. Consultar asignaturas.");
		System.out.println("3. Asignar profesor a asignatura.");
		System.out.println("4. Matricular alumno en asignatura.");
		System.out.println("5. Poner nota alumno en asignatura.");
		System.out.println("6. Borrar asignatura.");
		System.out.println("7. Desmatricular alumno de asignatura.");
		System.out.println("8. Volver.");
		
		System.out.println("--------------------------------------------");
		Scanner teclado = new Scanner(System.in);
		
		while(accion < 0) 
		{
			try 
			{
				System.out.println("OPCIÓN: ");
				int valor = teclado.nextInt();
				
				if (valor >= 1 && valor <= 8) 
				{
					accion = valor;
				}
				else
					System.out.println("Por favor, seleccione una opción válida [1-8].");
			}
			catch(Exception ex) 
			{
				teclado.nextLine();
				System.out.println("Por favor, seleccione una opción válida [1-8].");
			}
		}
		
		return accion;
	}
}
