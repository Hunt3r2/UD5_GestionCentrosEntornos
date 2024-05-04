package escuela;

import java.util.Scanner;

import validacion.Validar;

/**
 * La clase Asignatura representa una asignatura en la escuela.
 */
public class Asignatura
{
	/* Atributos */

	/* Máximo de alumnos permitidos matriculados en la asignatura */
	private final static int MAXALUMNOS = 5;
	
	/**
     * La clase DatosNotas representa la información de las notas de un alumno en la asignatura.
     */
	private class DatosNotas
	{
		private String idAlumno;
		private double notaAlumno;
		
		 /**
         * Constructor de la clase DatosNotas.
         * 
         * @param idAlumno El ID del alumno.
         * @param notaAlumno La nota del alumno en la asignatura.
         */
		public DatosNotas(String idAlumno, double notaAlumno) 
		{
			this.idAlumno = idAlumno;
			this.notaAlumno = notaAlumno;
		}
		
		/**
         * Constructor de copia de la clase DatosNotas.
         * 
         * @param datos El objeto DatosNotas del que se va a realizar la copia.
         */
		public DatosNotas(DatosNotas datos) 
		{
			this.idAlumno = datos.getIdAlumno();
			this.notaAlumno = datos.getNotaAlumno();
		}

		/**
         * Obtiene el ID del alumno.
         * 
         * @return El ID del alumno.
         */
		public String getIdAlumno() {
			return idAlumno;
		}

		/**
         * Establece el ID del alumno.
         * 
         * @param idAlumno El ID del alumno que se va a establecer.
         */
		public void setIdAlumno(String idAlumno) {
			this.idAlumno = idAlumno;
		}

		/**
         * Obtiene la nota del alumno.
         * 
         * @return La nota del alumno.
         */
		public double getNotaAlumno() {
			return notaAlumno;
		}

		/**
         * Establece la nota del alumno.
         * 
         * @param notaAlumno La nota del alumno que se va a establecer.
         */
		public void setNotaAlumno(double notaAlumno) {
			this.notaAlumno = notaAlumno;
		}
	}
	
	private String idProfesorAsignado;
	private String nombre; // ^\w{1,70}$
	private String codigo; // ASIGXXXX
	private DatosNotas[] notasAlumnos;
	
	/**
     * Metodo principal para probar la clase Asignatura.
     */
	public static void main(String[] args) 
	{
		try 
		{
			Asignatura miAsignatura = new Asignatura();
			miAsignatura.setNombre(new String("Programación"));
			miAsignatura.setIdProfesorAsignado(new String("PROF0001"));
			boolean valido = miAsignatura.setCodigo(new String("PRUEBA"));
			
			if (valido)
				System.out.println("Codigo asignatura 'PRUEBA' OK");
			else
				System.out.println("Codigo asignatura 'PRUEBA' KO");
			
			valido = miAsignatura.setCodigo(new String("ASIG0001"));
			
			if (valido)
				System.out.println("Codigo asignatura 'ASIG0001' OK");
			else
				System.out.println("Codigo asignatura 'ASIG0001' KO");
			
			miAsignatura.testRellenadoAsignaturas(3);
			
			boolean asignacionOK = miAsignatura.asignarNota(new String("PRUEBA"), 7.3); 
			if (asignacionOK)
				System.out.println("Asignar nota 'PRUEBA' OK");
			else
				System.out.println("Asignar nota 'PRUEBA' KO");
			
			asignacionOK = miAsignatura.asignarNota(new String("ALUMNO001"), 7.3); 
			if (asignacionOK)
				System.out.println("Asignar nota 'ALUMNO001' OK");
			else
				System.out.println("Asignar nota 'ALUMNO001' KO");
			
			miAsignatura.mostrarInformacion();
			
			System.out.println("Rellenamos alumnos restantes...");
			
			boolean matriculaOK = true;
			int indexAlumno = 1;
			do {
				matriculaOK = miAsignatura.matricularAlumno(new String("ALUMNO55" + indexAlumno));
				indexAlumno++;
			}while(matriculaOK);
			
			miAsignatura.mostrarInformacion();
			
//			System.out.println("Desmatriculo al segundo");
//			miAsignatura.desmatricularAlumno(1);
//			miAsignatura.mostrarInformacion();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	/* Métodos */
	
	/**
     * Constructor por defecto de la clase Asignatura.
     */
	public Asignatura() {
		this.idProfesorAsignado = null;
		this.nombre = null;
		this.codigo = null;
		this.notasAlumnos = new DatosNotas[getMAXALUMNOS()];
	}
	
	/**
     * Constructor parametrizado de la clase Asignatura.
     * 
     * @param idProfesorAsignado El ID del profesor asignado a la asignatura.
     * @param nombre El nombre de la asignatura.
     * @param codigo El codigo de la asignatura.
     * @param notasAlumnos El arreglo de datos de notas de los alumnos.
     */
	public Asignatura(String idProfesorAsignado, String nombre, String codigo,
			DatosNotas[] notasAlumnos) {
		this.idProfesorAsignado = idProfesorAsignado;
		this.nombre = nombre;
		this.codigo = codigo;
		this.notasAlumnos = notasAlumnos;
	}
	
	 /**
     * Constructor de copia de la clase Asignatura.
     * 
     * @param asig La asignatura de la que se va a realizar la copia.
     */
	public Asignatura(Asignatura asig) {
		this.idProfesorAsignado = asig.getIdProfesorAsignado();
		this.nombre = asig.getNombre();
		this.codigo = asig.getCodigo();
		this.notasAlumnos = new DatosNotas[getMAXALUMNOS()];
		
		DatosNotas[] notas = asig.getNotasAlumnos();
		for(int i = 0; i < MAXALUMNOS;i++) 
		{
			this.notasAlumnos[i] = notas[i];
		}
	}

	/**
     * Obtiene el ID del profesor asignado a la asignatura.
     * 
     * @return El ID del profesor asignado.
     */
	public String getIdProfesorAsignado() {
		return idProfesorAsignado;
	}

	/**
     * Establece el ID del profesor asignado a la asignatura.
     * 
     * @param idProfesorAsignado El ID del profesor asignado que se va a establecer.
     */
	public void setIdProfesorAsignado(String idProfesorAsignado) {
		this.idProfesorAsignado = idProfesorAsignado;
	}

	/**
     * Obtiene el nombre de la asignatura.
     * 
     * @return El nombre de la asignatura.
     */
	public String getNombre() {
		return nombre;
	}

	/**
     * Establece el nombre de la asignatura.
     * 
     * @param nombre El nombre de la asignatura que se va a establecer.
     * @return true si el nombre se estableció correctamente, false si el nombre no cumple con el formato especificado.
     */
	public boolean setNombre(String nombre) {
		boolean validacionOK = Validar.validarPatron(nombre.toString(), "^\\w{1,70}$");
		
		if (validacionOK)
			this.nombre = nombre;
		
		return validacionOK;
	}

	/**
     * Obtiene el codigo de la asignatura.
     * 
     * @return El codigo de la asignatura.
     */
	public String getCodigo() {
		return codigo;
	}

	 /**
     * Establece el codigo de la asignatura.
     * 
     * @param codigo El codigo de la asignatura que se va a establecer.
     * @return true si el código se establecio correctamente, false si el codigo no cumple con el formato especificado.
     */
	public boolean setCodigo(String codigo) {
		boolean validacionOK = Validar.validarPatron(codigo.toString(), "^ASIG[0-9]{4}$");
		
		if(validacionOK)
			this.codigo = codigo;
		
		return validacionOK;
	}

	/**
     * Obtiene el vector de datos de notas de los alumnos.
     * 
     * @return El vector de datos de notas de los alumnos.
     */
	public DatosNotas[] getNotasAlumnos() {
		return notasAlumnos;
	}

	/**
     * Establece el vector de datos de notas de los alumnos.
     * 
     * @param notasAlumnos El vector de datos de notas de los alumnos que se va a establecer.
     */
	public void setNotasAlumnos(DatosNotas[] notasAlumnos) {
		this.notasAlumnos = notasAlumnos;
	}

	/**
     * Obtiene el maximo de alumnos permitidos matriculados en la asignatura.
     * 
     * @return El maximo de alumnos permitidos matriculados.
     */
	public static int getMAXALUMNOS() {
		return MAXALUMNOS;
	}

	/* ---------------- */
	
	/**
     * Asigna una nota a un alumno en la asignatura.
     * 
     * @param idAlumno El ID del alumno al que se va a asignar la nota.
     * @param notaAlumno La nota que se va a asignar al alumno.
     * @return true si se asigno la nota correctamente, false si el alumno no está matriculado en la asignatura.
     */
	public boolean asignarNota(String idAlumno, double notaAlumno) 
	{
		boolean existeAlumno = false;
		int indexAlumno = 0;
		
		while (!existeAlumno && indexAlumno < this.notasAlumnos.length)
		{
			existeAlumno = this.notasAlumnos[indexAlumno] != null && this.notasAlumnos[indexAlumno].getIdAlumno().compareTo(idAlumno) == 0;
			if (!existeAlumno)
				indexAlumno++;
		}
		
		if (existeAlumno) 
		{
			this.notasAlumnos[indexAlumno].setNotaAlumno(notaAlumno);
		}
		
		return existeAlumno;
	}
	
	/**
	 * Metodo para matricular a un alumno
	 * 
	 * @return
	 * 1) Si ya esta matriculado devuelve true y no hace nada
	 * 2) Si no esta matriculado y hay algun hueco libre en el vector se lo asigna y devuelve true
	 * 3) Si no esta matriculado y no hay  hueco libre en el vector devuelve false
	 * */
	public boolean matricularAlumno(String idAlumno) 
	{
		boolean matriculaOK = false;
		
		if (idAlumno.length() > 0) 
		{
			int indexAlumno = 0;
			int primerIndexLibre = -1;
			
			while (!matriculaOK && primerIndexLibre < 0 && indexAlumno < this.notasAlumnos.length)
			{
				if(this.notasAlumnos[indexAlumno] != null) 
				{
					String curID = this.notasAlumnos[indexAlumno].getIdAlumno();
					matriculaOK = curID.compareTo(idAlumno) == 0;
				}
				else 
				{
					// Un ID con longitud cero indica que no está asignado a nadie
					if (primerIndexLibre < 0) 
					{
						primerIndexLibre = indexAlumno;
						matriculaOK = true;
					}
				}
				if (!matriculaOK)
					indexAlumno++;
			}
			
			if (primerIndexLibre >= 0) 
			{
				matriculaOK = true;
				this.notasAlumnos[primerIndexLibre] = new DatosNotas(idAlumno, 0);
			}
		}
		
		return matriculaOK;
	}
	
	/* Métodos TEST */
	private void testRellenadoAsignaturas(int total) 
	{
		int cantidad = total < MAXALUMNOS && total > 1 ? total : MAXALUMNOS;
		for(int i=0; i < cantidad; i++) 
		{
			this.notasAlumnos[i] = new DatosNotas(new String("ALUMNO00" + (i+1)), i);
		}
	}
	
	/**
     * Metodo de prueba que muestra la informacion de la asignatura por consola.
     */
	public void mostrarInformacion() 
	{
		System.out.println("--------------------------------------------");
		System.out.println("INFO ASIGNATURA:");
		System.out.println("--------------------------------------------");
		System.out.printf("Nombre: %s\n",this.nombre);
		System.out.printf("Código: %s\n", this.codigo);
		System.out.printf("Profesor: %s\n", this.idProfesorAsignado == null ? "" : this.idProfesorAsignado);
		System.out.println("#########################");
		System.out.println("Notas alumnos:");
		
		int cantidadMatriculados = 0;
		for(int i=0; i < MAXALUMNOS; i++) 
		{
			if (this.notasAlumnos[i] != null) 
			{
				System.out.printf("Alumno: %s - Nota: %.2f\n", this.notasAlumnos[i].getIdAlumno(), this.notasAlumnos[i].getNotaAlumno());
				cantidadMatriculados++;
			}
		}
		
		if(cantidadMatriculados == 0) 
		{
			System.out.println("No hay alumnos matriculados en la asignatura.");
		}
		
		System.out.println("--------------------------------------------");
	}
	
	/**
     * Lista los alumnos matriculados en la asignatura y permite seleccionar uno.
     * 
     * @return El indice del alumno seleccionado en el arreglo de alumnos matriculados.
     */
	public int listarAlumnosAsignatura() {
		int indexAlumno = -1;
		int cantidadMatriculados = 0;
		int opcionActual = 1;
		for(int i=0; i < MAXALUMNOS; i++) 
		{
			if (this.notasAlumnos[i] != null) 
			{
				System.out.printf("%d. %s\n"
						,opcionActual
						,this.notasAlumnos[i].getIdAlumno()
					);
				
				cantidadMatriculados++;
				opcionActual++;
			}
		}
		
		if(cantidadMatriculados == 0) 
		{
			System.out.println("No hay alumnos matriculados en la asignatura.");
		}
		else 
		{
			System.out.println("Escoger alumno (0: Volver al menú anterior):");
			Scanner teclado = new Scanner(System.in);
			
			while (indexAlumno < 0) 
			{
				try 
				{
					System.out.println("OPCIÓN: ");
					int valor = teclado.nextInt();
					
					if (valor >= 0 && valor <= (cantidadMatriculados)) 
					{
						indexAlumno = valor;
					}
					else
						System.out.println("Por favor, seleccione una opción válida [0-" + (cantidadMatriculados) + "].");
				}
				catch(Exception ex) 
				{
					teclado.nextLine();
					System.out.println("Por favor, seleccione una opción válida [0-" + (cantidadMatriculados) + "].");
				}
			}
		}
		
		System.out.println("--------------------------------------------");
		
		return indexAlumno-1;
	}
	
	/**
     * Obtiene el ID de un alumno matriculado en la asignatura dado su indice.
     * 
     * @param indexAlumno El indice del alumno en el arreglo de alumnos matriculados.
     * @return El ID del alumno.
     */
	public String obtenerIdAlumnoAsignatura(int indexAlumno) 
	{
		return this.notasAlumnos[indexAlumno].getIdAlumno();
	}
	
	/**
	 * Desmatricula al alumno dado su indice
	 * 
	 * @param Tendremos que quitar al alumno de la lista y mover todos los alumnos a la izquierda
	 * */
	public void desmatricularAlumno(int indexAlumno) 
	{
		boolean finAlumnos = false;
		this.notasAlumnos[indexAlumno] = null;
		
		for(int i = indexAlumno+1; i < this.notasAlumnos.length && !finAlumnos; i++) 
		{
			if(this.notasAlumnos[i] != null) 
			{
				this.notasAlumnos[i-1] = new DatosNotas(this.notasAlumnos[i]);
				this.notasAlumnos[i] = null;
			}
			else 
			{
				finAlumnos = true;
			}
		}
	}
}
