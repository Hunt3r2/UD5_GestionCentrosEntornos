package escuela;

import java.util.Scanner;
import validacion.Validar;

/**
 * La clase Gestor representa el gestor principal del sistema de la escuela.
 * Se encarga de gestionar alumnos, profesores y asignaturas.
 */
public class Gestor 
{
	/* Máximo de alumnos de la escuela */
	private final int MAXALUMNOS = 2;
	/* Máximo de profesores de la escuela */
	private final int MAXPROFESORES = 2;
	/* Máximo asignaturas de la escuela */
	private final int MAXASIGNATURAS = 4;
	
	/* Vector que va a contener a los alumnos del centro */
	private Alumno[] vAlumnos;
	/* Vector que va a contener a los profesores del centro */
	private Profesor[] vProfesores;
	/* Vector que va a contener las asignaturas del centro */
	private Asignatura[] vAsignaturas;
	
	/**
	 * Metodo principal que inicia la ejecucion del programa.
	 * @param args Argumentos de línea de comandos (no utilizados).
	 */
	public static void main(String[] args) 
	{
		Gestor miGestor = new Gestor();
		System.out.println("La nota asignada es: " + miGestor.pedirNota());
	}
	
	/**
	 * Constructor de la clase Gestor. Inicializa los vectores de alumnos, profesores y asignaturas.
	 */
	public Gestor() 
	{
		this.vAlumnos = new Alumno[MAXALUMNOS];
		this.vProfesores = new Profesor[MAXPROFESORES];
		this.vAsignaturas = new Asignatura[MAXASIGNATURAS];
	}
	
	/**
	 * Metodo para insertar una nueva asignatura en el sistema.
	 *
	 *
	 * @return  Si quedan posiciones libres insertamos y devuelve true; si no retorna false */
	public boolean insertarAsignatura() 
	{
		boolean insertarOK = false;
		
		// Comprobar si queda algún index libre
		int index = comprobarAsignaturaLibre();
		if (index >= 0)
		{
			Asignatura asig = pedirDatosAsignatura();
			/* Ahora tenemos que pedir la información del profesor */
			
			// Tenemos que asignarle un ID en base a los profesores que hay que no esté repetido // PROFXXXX
			String nuevoCodigo = obtenerNuevoCodigoAsignatura();
			asig.setCodigo(nuevoCodigo);
			
			/* Cuando todo está OK insertamos */
			this.vAsignaturas[index] = new Asignatura(asig);
			insertarOK = true;
		}
		
		return insertarOK;
	}
	
	/**
	 * Genera un nuevo codigo para una asignatura en base al ultimo codigo existente.
	 * @return Nuevo codigo de asignatura.
	 */
	private String obtenerNuevoCodigoAsignatura() {
		String idAsignatura = "ASIG";
		int idMasAlto = 0;
		
		for(Asignatura asig: this.vAsignaturas) 
		{
			if(asig != null) 
			{
				// Cojo la parte de la subcadena sólo de los números (ultimos 4 caracteres)
				String numero = asig.getCodigo();
				numero = numero.substring(numero.length()-4, numero.length());
				int valorId = Integer.valueOf(numero).intValue();
				
				// En caso de ser más alto lo tomo como referencia
				if(valorId > idMasAlto)
					idMasAlto = valorId;
			}
		}
		
		// Con el numero más alto ya, le voy a sumar 1 y ademas tengo que rellenar con ceros por la izquierda
		String idFinal = String.valueOf(idMasAlto+1);
		StringBuilder cadenaCodigoAsig = new StringBuilder(idFinal);
		while (cadenaCodigoAsig.length() < 4) 
		{
			cadenaCodigoAsig.insert(0, '0');
		}
		
		idAsignatura += cadenaCodigoAsig.toString();
		
		return idAsignatura;
	}

	/**
	 * Solicita al usuario los datos de una asignatura.
	 * @return Objeto Asignatura con los datos introducidos.
	 */
	private Asignatura pedirDatosAsignatura() {
		Asignatura asig = new Asignatura();
		boolean datosAsignaturaOK = false;
		
		Scanner teclado = new Scanner(System.in);
		
		while(!datosAsignaturaOK) 
		{
			try 
			{
				System.out.println("Introduzca el nombre de la asignatura (MAX 70 caracteres):");
				String nombreAsig = teclado.nextLine();
				while (!asig.setNombre(nombreAsig)) 
				{
					System.out.println("Introduzca un nombre de la asignatura válido (MAX 70 caracteres):");
					nombreAsig = teclado.nextLine();
				}

				// Si todo ha ido bien salgo del bucle
				datosAsignaturaOK = true;
			}
			catch(Exception ex) 
			{
				System.out.println("Ha habido algún error. Vuelva a introducir los datos.");
			}
		}

		return asig;
	}

	/**
     * Verifica si hay posiciones libres en el vector de profesores e inserta un nuevo profesor si es posible.
     * @return 
     * Si quedan posiciones libres insertamos y devuelve true; si no retorna false */
	public boolean insertarProfesor() 
	{
		boolean insertarOK = false;
		
		// Comprobar si queda algún index libre
		int index = comprobarProfesorLibre();
		if (index >= 0)
		{
			Profesor profesor = pedirDatosProfesor();
			/* Ahora tenemos que pedir la información del profesor */
			
			// Tenemos que asignarle un ID en base a los profesores que hay que no esté repetido // PROFXXXX
			String nuevoId = obtenerNuevoIdProfesor();
			profesor.setId(nuevoId);
			
			/* Cuando todo está OK insertamos */
			this.vProfesores[index] = new Profesor(profesor);
			insertarOK = true;
		}
		
		return insertarOK;
	}
	
	/** Metodo que va a recorrer el vector de profesores
	* @return va a coger el id mas alto que exista respecto a su
	* parte numerica y me va a devolver el siguiente */
	private String obtenerNuevoIdProfesor() 
	{
		String idProfesor = "PROF";
		int idMasAlto = 0;
		
		for(Profesor profesor: this.vProfesores) 
		{
			if(profesor != null) 
			{
				// Cojo la parte de la subcadena sólo de los números (ultimos 4 caracteres)
				String numero = profesor.getId();
				numero = numero.substring(numero.length()-4, numero.length());
				int valorId = Integer.valueOf(numero).intValue();
				
				// En caso de ser más alto lo tomo como referencia
				if(valorId > idMasAlto)
					idMasAlto = valorId;
			}
		}
		
		// Con el numero mas alto ya, le voy a sumar 1 y ademas tengo que rellenar con ceros por la izquierda
		String idFinal = String.valueOf(idMasAlto+1);
		StringBuilder cadenaNumeroProf = new StringBuilder(idFinal);
		while (cadenaNumeroProf.length() < 4) 
		{
			cadenaNumeroProf.insert(0, '0');
		}
		
		idProfesor += cadenaNumeroProf.toString();
		
		return idProfesor;
	}


/**
 * Metodo para solicitar al usuario los datos de un profesor y crear un objeto Profesor con esos datos.
 * @return El objeto Profesor creado con los datos proporcionados por el usuario.
 */
	private Profesor pedirDatosProfesor() 
	{
		Profesor profesor = new Profesor();
		boolean datosProfesorOK = false;
		
		Scanner teclado = new Scanner(System.in);
		
		while(!datosProfesorOK) 
		{
			try 
			{
				System.out.println("Introduzca el nombre del profesor (MAX 30 caracteres):");
				String nombreProfesor = teclado.nextLine();
				while (!profesor.setNombre(nombreProfesor)) 
				{
					System.out.println("Introduzca un nombre de profesor válido (MAX 30 caracteres):");
					nombreProfesor = teclado.nextLine();
				}

				System.out.println("Introduzca el primer apellido del profesor (MAX 40 caracteres):");
				String ap1Profesor = teclado.nextLine();
				while (!profesor.setApellido1(ap1Profesor)) 
				{
					System.out.println("Introduzca un apellido de profesor válido (MAX 40 caracteres):");
					ap1Profesor = teclado.nextLine();
				}

				System.out.println("Introduzca el segundo apellido del profesor (opcional):");
				String ap2Profesor = teclado.nextLine();
				if (ap2Profesor.length() > 0)
					profesor.setApellido2(ap2Profesor);

				System.out.println("Introduzca el teléfono del profesor ([6,7 o 9] y 8 números):");
				String tlfProfesor = teclado.nextLine();
				while (!profesor.setTelefono(tlfProfesor)) 
				{
					System.out.println("Introduzca un teléfono de profesor válido ([6,7 o 9] y 8 números):");
					tlfProfesor = teclado.nextLine();
				}

				System.out.println("Introduzca el email del profesor (cadena@profesor.es):");
				String emailProfesor = teclado.nextLine();
				while (!profesor.setEmail(emailProfesor)) 
				{
					System.out.println("Introduzca un email de profesor válido (cadena@profesor.es):");
					emailProfesor = teclado.nextLine();
				}

				System.out.println("Introduzca el documento del profesor (DNI o NIE):");
				String docProfesor = teclado.nextLine();
				while (!profesor.setDocumento(docProfesor)) 
				{
					System.out.println("Introduzca un documento de profesor válido (DNI o NIE):");
					docProfesor = teclado.nextLine();
				}

				System.out.println("Introduzca si el profesor es tutor (0: no; 1: sí):");
				int valorTutor = teclado.nextInt();
				while (valorTutor < 0 || valorTutor > 1) 
				{
					System.out.println("Introduzca una opción válida de tutor (0: no; 1: sí):");
					valorTutor = teclado.nextInt();
				}
				profesor.setEsTutor(valorTutor == 1);
				
				System.out.println("Introduzca el sueldo del profesor (>0):");
				double sueldo = teclado.nextDouble();
				while (!profesor.setSueldo(sueldo)) 
				{
					System.out.println("Introduzca un sueldo de profesor válido (>0):");
					sueldo = teclado.nextDouble();
				}

				System.out.println("Introduzca los días de asuntos propios del profesor (>=0):");
				int diasPropiosProfesor = teclado.nextInt();
				while (!profesor.setDiasAsuntosPropios(diasPropiosProfesor)) 
				{
					System.out.println("Introduzca días de asuntos propios válidos (>=0):");
					diasPropiosProfesor = teclado.nextInt();
				}
				
				
				// Si todo ha ido bien salgo del bucle
				datosProfesorOK = true;
			}
			catch(Exception ex) 
			{
				System.out.println("Ha habido algún error. Vuelva a introducir los datos.");
			}
		}

		return profesor;
	}

	/**
	 * Inserta un nuevo alumno en el sistema si hay posiciones disponibles.
	 * 
	 * @return true si se inserta correctamente, false si no hay posiciones disponibles.
	 */
	public boolean insertarAlumno() 
	{
		boolean insertarOK = false;
		
		// Comprobar si queda algun index libre
		int index = comprobarAlumnoLibre();
		if (index >= 0)
		{
			Alumno alumno = pedirDatosAlumno();
			/* Ahora tenemos que pedir la información del alumno */
			
			// Tenemos que asignarle un ID en base a los alumnos que hay que no esté repetido // ALUMXXXX
			String nuevoId = obtenerNuevoIdAlumno();
			alumno.setId(nuevoId);
			
			/* Cuando todo está OK insertamos */
			this.vAlumnos[index] = new Alumno(alumno);
			insertarOK = true;
		}
		
		return insertarOK;
	}

	/**
	 * Inserta un nuevo alumno en el array de alumnos si hay posiciones libres.
	 * @return True si se ha insertado correctamente, False si no hay posiciones libres.
	 */
	private Alumno pedirDatosAlumno() 
	{
		Alumno alumno = new Alumno();
		boolean datosAlumnoOK = false;
		
		Scanner teclado = new Scanner(System.in);
		
		while(!datosAlumnoOK) 
		{
			try 
			{
				System.out.println("Introduzca el nombre del alumno (MAX 30 caracteres):");
				String nombreAlumno = teclado.nextLine();
				while (!alumno.setNombre(nombreAlumno)) 
				{
					System.out.println("Introduzca un nombre de alumno válido (MAX 30 caracteres):");
					nombreAlumno = teclado.nextLine();
				}

				System.out.println("Introduzca el primer apellido del alumno (MAX 40 caracteres):");
				String ap1Alumno = teclado.nextLine();
				while (!alumno.setApellido1(ap1Alumno)) 
				{
					System.out.println("Introduzca un apellido de alumno válido (MAX 40 caracteres):");
					ap1Alumno = teclado.nextLine();
				}

				System.out.println("Introduzca el segundo apellido del alumno (opcional):");
				String ap2Alumno = teclado.nextLine();
				if (ap2Alumno.length() > 0)
					alumno.setApellido2(ap2Alumno);

				System.out.println("Introduzca el teléfono del alumno ([6,7 o 9] y 8 números):");
				String tlfAlumno = teclado.nextLine();
				while (!alumno.setTelefono(tlfAlumno)) 
				{
					System.out.println("Introduzca un teléfono de alumno válido ([6,7 o 9] y 8 números):");
					tlfAlumno = teclado.nextLine();
				}

				System.out.println("Introduzca el email del alumno (cadena@alumno.es):");
				String emailAlumno = teclado.nextLine();
				while (!alumno.setEmail(emailAlumno)) 
				{
					System.out.println("Introduzca un email de alumno válido (cadena@alumno.es):");
					emailAlumno = teclado.nextLine();
				}

				System.out.println("Introduzca el documento del alumno (DNI o NIE):");
				String docAlumno = teclado.nextLine();
				while (!alumno.setDocumento(docAlumno)) 
				{
					System.out.println("Introduzca un documento de alumno válido (DNI o NIE):");
					docAlumno = teclado.nextLine();
				}
				
				System.out.println("Introduzca el nombre del ciclo al que pertenece:");
				String cicloAlumno = teclado.nextLine();
				alumno.setNombreCicloMatriculado(cicloAlumno);

				// Si todo ha ido bien salgo del bucle
				datosAlumnoOK = true;
			}
			catch(Exception ex) 
			{
				System.out.println("Ha habido algún error. Vuelva a introducir los datos.");
			}
		}

		return alumno;
	}

	/**
	 * Obtiene un nuevo ID para un alumno en base a los alumnos existentes.
	 * 
	 * @return El nuevo ID generado para el alumno.
	 */
	private String obtenerNuevoIdAlumno() 
	{
		String idAlumno = "ALUM";
		int idMasAlto = 0;
		
		for(Alumno alumno: this.vAlumnos) 
		{
			if(alumno != null) 
			{
				// Cojo la parte de la subcadena sólo de los números (ultimos 4 caracteres)
				String numero = alumno.getId();
				numero = numero.substring(numero.length()-4, numero.length());
				int valorId = Integer.valueOf(numero).intValue();
				
				// En caso de ser más alto lo tomo como referencia
				if(valorId > idMasAlto)
					idMasAlto = valorId;
			}
		}
		
		// Con el numero más alto ya, le voy a sumar 1 y además tengo que rellenar con ceros por la izquierda
		String idFinal = String.valueOf(idMasAlto+1);
		StringBuilder cadenaNumeroAlum = new StringBuilder(idFinal);
		while (cadenaNumeroAlum.length() < 4) 
		{
			cadenaNumeroAlum.insert(0, '0');
		}
		
		idAlumno += cadenaNumeroAlum.toString();
		
		return idAlumno;
	}

	/**
	 * Obtiene un nuevo ID para un alumno basado en el último ID registrado.
	 * @return El nuevo ID para el alumno.
	 */
	private int comprobarAsignaturaLibre() 
	{

		int indexResultado = -1, index = 0;
		
		while (index < this.vAsignaturas.length && indexResultado < 0) 
		{
			if(this.vAsignaturas[index] == null) 
			{
				indexResultado = index;
			}
			
			index++;
		}
		
		return indexResultado;
	}
	
	/**
	 * Comprueba si hay posiciones libres en el array de profesores.
	 * @return El indice de la primera posición libre encontrada, o -1 si no hay posiciones libres.
	 */
	private int comprobarProfesorLibre() 
	{

		int indexResultado = -1, index = 0;
		
		while (index < this.vProfesores.length && indexResultado < 0) 
		{
			if(this.vProfesores[index] == null) 
			{
				indexResultado = index;
			}
			
			index++;
		}
		
		return indexResultado;
	}
	
	/**
	 * Comprueba si hay posiciones libres en el array de alumnos.
	 * @return El indice de la primera posición libre encontrada, o -1 si no hay posiciones libres.
	 */
	private int comprobarAlumnoLibre() {

		int indexResultado = -1, index = 0;
		
		while (index < this.vAlumnos.length && indexResultado < 0) 
		{
			if(this.vAlumnos[index] == null) 
			{
				indexResultado = index;
			}
			
			index++;
		}
		
		return indexResultado;
	}
	
	/**
	 * Este metodo nos va a decir los profesores que hay registrados y nos dara la opcion de consultar la 
	 * informacion de alguno de ellos
	 * */
	public void consultarProfesores() 
	{
		int opcionProfesores = listarProfesores();
		if (opcionProfesores >= 0)
		{
			this.vProfesores[opcionProfesores].mostrarInformacion();
		}
	}

	/**
	 * Este metodo muestra una lista de profesores registrados y permite al usuario seleccionar uno de ellos para consultar su informacion.
	 * @return El indice del profesor seleccionado (comenzando desde 0), o -1 si no hay profesores registrados o se selecciona la opcion de volver al menu anterior.
	 */
	public int listarProfesores() 
	{
		int accion = -1;
		System.out.println("--------------------------------------------");
		System.out.println("Listado de profesores:");
		System.out.println("--------------------------------------------");
			
		if (this.vProfesores.length > 0)
		{
			int cantidadRegistrados = 0;
			int opcionActual = 1;
			for(Profesor profesor: this.vProfesores) 
			{
				if(profesor != null) 
				{
					System.out.printf("%d. %s # %s\n"
								,opcionActual
								,profesor.getId()
								,(profesor.getNombre() + " " + profesor.getApellido1() + (profesor.getApellido2() == null ? "" : " " + profesor.getApellido2()))
							);
					
					opcionActual++;
					cantidadRegistrados++;
				}
			}
			
			if (cantidadRegistrados == 0)
			{
				System.out.println("No hay profesores registrados en la plataforma.");
			}
			else 
			{
				System.out.println("Escoger profesor (0: Volver al menú anterior):");
				
				Scanner teclado = new Scanner(System.in);
				
				
				while (accion < 0) 
				{
					try 
					{
						System.out.println("OPCIÓN: ");
						int valor = teclado.nextInt();
						
						if (valor >= 0 && valor <= (opcionActual-1)) 
						{
							accion = valor;
						}
						else
							System.out.println("Por favor, seleccione una opción válida [0-" + (opcionActual-1) + "].");
					}
					catch(Exception ex) 
					{
						teclado.nextLine();
						System.out.println("Por favor, seleccione una opción válida [0-" + (opcionActual-1) + "].");
					}
				}
			}
		}	
		
		return accion-1;
	}

	/**
	 * Este metodo permite consultar la informacion de un alumno seleccionado de la lista de alumnos registrados.
	 */
	public void consultarAlumnos() 
	{
		int opcionAlumnos = listarAlumnos();
		if (opcionAlumnos >= 0)
		{
			this.vAlumnos[opcionAlumnos].mostrarInformacion();
		}
	}
	
	/**
	 * Este metodo muestra un listado de los alumnos registrados en la plataforma y permite seleccionar uno de ellos para consultar su informacion.
	 * @return La opción seleccionada por el usuario para consultar un alumno especifico.
	 */
	public int listarAlumnos() 
	{
		int accion = -1;
		System.out.println("--------------------------------------------");
		System.out.println("Listado de alumnos:");
		System.out.println("--------------------------------------------");
			
		if (this.vAlumnos.length > 0)
		{
			int cantidadRegistrados = 0;
			int opcionActual = 1;
			for(Alumno alumno: this.vAlumnos) 
			{
				if(alumno != null) 
				{
					System.out.printf("%d. %s # %s\n"
								,opcionActual
								,alumno.getId()
								,(alumno.getNombre() + " " + alumno.getApellido1() + (alumno.getApellido2() == null ? "" : " " + alumno.getApellido2()))
							);
					
					opcionActual++;
					cantidadRegistrados++;
				}
			}
			
			if (cantidadRegistrados == 0)
			{
				System.out.println("No hay alumnos registrados en la plataforma.");
			}
			else 
			{
				System.out.println("Escoger alumno (0: Volver al menú anterior):");
				
				Scanner teclado = new Scanner(System.in);
				
				while (accion < 0) 
				{
					try 
					{
						System.out.println("OPCIÓN: ");
						int valor = teclado.nextInt();
						
						if (valor >= 0 && valor <= (opcionActual-1)) 
						{
							accion = valor;
						}
						else
							System.out.println("Por favor, seleccione una opción válida [0-" + (opcionActual-1) + "].");
					}
					catch(Exception ex) 
					{
						teclado.nextLine();
						System.out.println("Por favor, seleccione una opción válida [0-" + (opcionActual-1) + "].");
					}
				}
			}
		}	
		
		return accion-1;
	}
	
	/**
	 * Este metodo permite al usuario consultar la informacion de una asignatura seleccionada de la lista de asignaturas registradas.
	 */
	public void consultarAsignaturas() 
	{
		int opcionAsignaturas = listarAsignaturas();
		if (opcionAsignaturas >= 0)
		{
			this.vAsignaturas[opcionAsignaturas].mostrarInformacion();
		}
	}

	/**
	 * Este metodo muestra una lista de asignaturas disponibles en la plataforma y permite al usuario seleccionar una para consultar su informacion.
	 * @return El indice de la asignatura seleccionada, o -1 si no se selecciona ninguna asignatura o si no hay asignaturas registradas.
	 */
	public int listarAsignaturas() 
	{
		int accion = -1;
		System.out.println("--------------------------------------------");
		System.out.println("Listado de asignaturas:");
		System.out.println("--------------------------------------------");
			
		if (this.vAsignaturas.length > 0)
		{
			int cantidadRegistrados = 0;
			int opcionActual = 1;
			for(Asignatura asig: this.vAsignaturas) 
			{
				if(asig != null) 
				{
					System.out.printf("%d. %s # %s\n"
								,opcionActual
								,asig.getCodigo()
								,asig.getNombre()
							);
					
					opcionActual++;
					cantidadRegistrados++;
				}
			}
			
			if (cantidadRegistrados == 0)
			{
				System.out.println("No hay asignaturas registradas en la plataforma.");
			}
			else 
			{
				System.out.println("Escoger asignatura (0: Volver al menú anterior):");
				
				Scanner teclado = new Scanner(System.in);
				
				
				while (accion < 0) 
				{
					try 
					{
						System.out.println("OPCIÓN: ");
						int valor = teclado.nextInt();
						
						if (valor >= 0 && valor <= (opcionActual-1)) 
						{
							accion = valor;
						}
						else
							System.out.println("Por favor, seleccione una opción válida [0-" + (opcionActual-1) + "].");
					}
					catch(Exception ex) 
					{
						teclado.nextLine();
						System.out.println("Por favor, seleccione una opción válida [0-" + (opcionActual-1) + "].");
					}
				}
			}
		}	
		
		return accion-1;
	}

	/**
	 *  Este metodo permite al usuario asignar un profesor a una asignatura seleccionada.
	 * 1) Muestra las asignaturas; si no hay asignaturas, mensaje y para atrás. Selecciono.
	 * 2) Muestra los profesores; si no hay profesores, mensaje y para atrás. Seleccion y asigno (da igual que haya otro).
	 * */
	public void asignarProfesor() 
	{
		int opcionAsignaturas = listarAsignaturas();
		if (opcionAsignaturas >= 0)
		{
			int opcionProfesor = listarProfesores();
			if (opcionProfesor >= 0)
			{
				this.vAsignaturas[opcionAsignaturas].setIdProfesorAsignado(this.vProfesores[opcionProfesor].getId());
			}
		}
	}

	/**
	 * Este metodo permite al usuario matricular un alumno en una asignatura seleccionada.
	 * 1) Muestra las asignaturas; si no hay asignaturas, mensaje y para atras. Selecciono.
	 * 2) Muestra los alumnos; si no hay alumnos, mensaje y para atrás. Selecciono.
	 * 3) Si no quedan plazas mensaje ; si quedan o ya estaba matriculo.
	 * */
	public void matricularAlumno() 
	{
		int opcionAsignaturas = listarAsignaturas();
		if (opcionAsignaturas >= 0)
		{
			int opcionAlumnos = listarAlumnos();
			if (opcionAlumnos >= 0)
			{
				if (this.vAsignaturas[opcionAsignaturas].matricularAlumno(this.vAlumnos[opcionAlumnos].getId()))
				{
					System.out.println("Alumno matriculado correctamente.");
				}
				else 
				{
					System.out.println("No se ha podido matricular al alumno.");
				}
			}
		}
	}

	/**
	 * Este metodo permite al usuario asignar una nota a un alumno en una asignatura seleccionada.
	 * 1) Muestra las asignaturas; si no hay asignaturas, mensaje y para atras. Selecciono.
	 * 2) Muestra los alumnos de la asignatura; si no hay alumnos, mensaje y para atrás. Selecciono.
	 * 3) Me pide nota (decimal entre 0 y 10), asigno.
	 * */
	public void ponerNotaAlumno() 
	{
		int opcionAsignaturas = listarAsignaturas();
		if (opcionAsignaturas >= 0)
		{
			int opcionAlumnos = this.vAsignaturas[opcionAsignaturas].listarAlumnosAsignatura();
			if (opcionAlumnos >= 0)
			{
				String idAlumno = this.vAsignaturas[opcionAsignaturas].obtenerIdAlumnoAsignatura(opcionAlumnos);
				this.vAsignaturas[opcionAsignaturas].asignarNota(idAlumno, pedirNota());
			}
		}
	}

	/**
	 * Este metodo solicita al usuario que ingrese una nota, la cual debe ser un numero decimal entre 0 y 10.
	 * Devuelve la nota ingresada por el usuario una vez que esta sea válida.
	 *
	 * @return La nota ingresada por el usuario.
	 */
	private double pedirNota() 
	{
		double nota = -1;
		System.out.println("Introduzca la nota (>=0 Y <=10):");
		Scanner teclado = new Scanner(System.in);
		
		while(nota < 0) 
		{
			try 
			{
				nota = teclado.nextDouble();
				if (nota < 0 || nota > 10)
				{
					nota = -1;
					System.out.println("Debe introducir una nota numérica válida (>=0 Y <=10):");
				}
			}
			catch(Exception ex) 
			{
				teclado.nextLine();
				System.out.println("Debe introducir una nota numérica válida (>=0 Y <=10):");
			}
		}
		
		return nota;
	}

	
	/**
	 * Elimina un profesor de la lista de profesores y lo desvincula de las asignaturas que lo tienen asignado.
	 * ¡¡SIN TERMINAR!!
	 * 
	 * Habría que quitar el profesor de las asignaturas que lo tengan asignado
	 * */
	public void borrarProfesor() 
	{
		int opcionProfesores = listarProfesores();
		
		if (opcionProfesores >= 0)
		{
			boolean finProfesores = false;
			this.vProfesores[opcionProfesores] = null;
			
			for(int i = opcionProfesores+1; i < this.vProfesores.length && !finProfesores; i++) 
			{
				if(this.vProfesores[i] != null) 
				{
					this.vProfesores[i-1] = new Profesor(this.vProfesores[i]);
					this.vProfesores[i] = null;
				}
				else 
				{
					finProfesores = true;
				}
			}
		}
	}

	/**
	 *  Elimina un alumno de la lista de alumnos y lo desmatricula de todas las asignaturas donde esté matriculado.
	 * ¡¡SIN TERMINAR!!
	 * 
	 * Habria que desmatricular al alumno de todas las asignaturas donde esté matriculado
	 * */
	public void borrarAlumno() 
	{
		int opcionAlumnos = listarAlumnos();
		
		if (opcionAlumnos >= 0)
		{
			boolean finAlumnos = false;
			this.vAlumnos[opcionAlumnos] = null;
			
			for(int i = opcionAlumnos+1; i < this.vAlumnos.length && !finAlumnos; i++) 
			{
				if(this.vAlumnos[i] != null) 
				{
					this.vAlumnos[i-1] = new Alumno(this.vAlumnos[i]);
					this.vAlumnos[i] = null;
				}
				else 
				{
					finAlumnos = true;
				}
			}
		}
	}

	/**
	 * Permite al usuario seleccionar una asignatura para ser eliminada del sistema.
	 * Si se selecciona una asignatura valida, se elimina del vector de asignaturas.
	 */
	public void borrarAsignatura() 
	{
		int opcionAsignaturas= listarAsignaturas();
		
		if (opcionAsignaturas >= 0)
		{
			String codigo = this.vAsignaturas[opcionAsignaturas].getCodigo();
			boolean finAsignaturas = false;
			this.vAsignaturas[opcionAsignaturas] = null;
			
			for(int i = opcionAsignaturas+1; i < this.vAsignaturas.length && !finAsignaturas; i++) 
			{
				if(this.vAsignaturas[i] != null) 
				{
					this.vAsignaturas[i-1] = new Asignatura(this.vAsignaturas[i]);
					this.vAsignaturas[i] = null;
				}
				else 
				{
					finAsignaturas = true;
				}
			}
			
			System.out.println("Asignatura " + codigo + " borrada correctamete.");
		}
	}

	/**
	 * Elimina una asignatura de la lista de asignaturas.
	 * 
	 * @see #listarAsignaturas() Metodo para listar las asignaturas disponibles.
	 */
	public void desmatricularAlumno() 
	{
		int opcionAsignaturas = listarAsignaturas();
		
		if (opcionAsignaturas >= 0)
		{
			int opcionAlumnosAsig = this.vAsignaturas[opcionAsignaturas].listarAlumnosAsignatura();
			if (opcionAlumnosAsig >= 0)
			{
				String idAlumno = this.vAsignaturas[opcionAsignaturas].obtenerIdAlumnoAsignatura(opcionAlumnosAsig);
				this.vAsignaturas[opcionAsignaturas].desmatricularAlumno(opcionAlumnosAsig);
				System.out.println("El alumno " + idAlumno + " ha sido desmatriculado de la asignatura " + this.vAsignaturas[opcionAsignaturas].getCodigo());
			}
		}
	}
}
