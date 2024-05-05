package escuela;

import validacion.Validar;

/**
 * La clase Alumno representa a un estudiante en la escuela.
 */
public class Alumno 
{
	private String idAlumno; // ALUMXXXX
	private String nombre; // ^\w{1,30}$
	private String apellido1; // ^\w{1,40}$
	private String apellido2; // opcional
	private String telefono; // ^[679][0-9]{8}$
	private String email; // ^[a-zA-Z0-9_]+@alumno\.[a-zA-Z0-9]{2,3}$
	private String documento; //NIF: ^[0-9]{8}[A-Z]$ ; NIE: ^[XYZ][0-9]{7}[A-Z]$
	
	private String nombreCicloMatriculado;
	
	/**
	 * Metodo principal que prueba la funcionalidad de la clase Alumno.
	 * Imprime resultados de las operaciones de validación realizadas sobre los atributos del alumno.
	 * @param args Argumentos de la linea de comandos (no utilizados).
	 */
	public static void main(String[] args) 
	{
		try 
		{
			Alumno nuevoAlumno = new Alumno();
			
			boolean validar = nuevoAlumno.setId(new String("PRUEBA"));
			
			if(validar)
				System.out.println("ID alumno 'PRUEBA' OK");
			else
				System.out.println("ID alumno 'PRUEBA' KO");
			
			validar = nuevoAlumno.setId(new String("ALUM0001"));
			
			if(validar)
				System.out.println("ID alumno 'ALUM0001' OK");
			else
				System.out.println("ID alumno 'ALUM0001' KO");
			
			System.out.println("--------------------------------");
			
			validar = nuevoAlumno.setNombre(new String("sdsadsadsadsadsadasdasdsadasasdsadadas"));
			
			if(validar)
				System.out.println("Nombre alumno 'sdsadsadsadsadsadasdasdsadasasdsadadas' OK");
			else
				System.out.println("Nombre alumno 'sdsadsadsadsadsadasdasdsadasasdsadadas' KO");
			
			validar = nuevoAlumno.setNombre(new String("Hugo"));
			
			if(validar)
				System.out.println("Nombre alumno 'Hugo' OK");
			else
				System.out.println("Nombre alumno 'Hugo' KO");
			
			System.out.println("--------------------------------");
			
			validar = nuevoAlumno.setApellido1(new String(" "));
			
			if(validar)
				System.out.println("Apellido 1 alumno ' ' OK");
			else
				System.out.println("Apellido 1 alumno ' ' KO");
			
			validar = nuevoAlumno.setApellido1(new String("Vegas"));
			
			if(validar)
				System.out.println("Apellido 1 alumno 'Vegas' OK");
			else
				System.out.println("Apellido 1 alumno 'Vegas' KO");
			
			System.out.println("--------------------------------");
			
			nuevoAlumno.setApellido2(new String("Carrasco"));
			
			validar = nuevoAlumno.setTelefono(new String("555555555"));
			
			if(validar)
				System.out.println("Telefono alumno '555555555' OK");
			else
				System.out.println("Telefono alumno '555555555' KO");
			
			validar = nuevoAlumno.setTelefono(new String("915435701"));
			
			if(validar)
				System.out.println("Telefono alumno '915435701' OK");
			else
				System.out.println("Telefono alumno '915435701' KO");
			
			System.out.println("--------------------------------");
			
			validar = nuevoAlumno.setEmail(new String("hugovegas@profesor.es"));
			
			if(validar)
				System.out.println("Email alumno 'hugovegas@profesor.es' OK");
			else
				System.out.println("Email alumno 'hugovegas@profesor.es' KO");
			
			validar = nuevoAlumno.setEmail(new String("hugovegas@alumno.es"));
			
			if(validar)
				System.out.println("Email alumno 'hugovegas@alumno.es' OK");
			else
				System.out.println("Email alumno 'hugovegas@alumno.es' KO");
			
			System.out.println("--------------------------------");
			
			validar = nuevoAlumno.setDocumento(new String("123456789Z"));
			
			if(validar)
				System.out.println("Documento alumno '123456789Z' OK");
			else
				System.out.println("Documento alumno '123456789Z' KO");
			
			validar = nuevoAlumno.setDocumento(new String("Y1234567Z"));
			
			if(validar)
				System.out.println("Documento alumno 'Y1234567Z' OK");
			else
				System.out.println("Documento alumno 'Y1234567Z' KO");
			
			System.out.println("--------------------------------");
			
			nuevoAlumno.setNombreCicloMatriculado(new String("Desarrollo de aplicaciones multiplataforma"));
			
			nuevoAlumno.mostrarInformacion();
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
	}
	/**
     * Constructor por defecto de la clase Alumno.
     */
	public Alumno() {
		this.idAlumno = null;
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.telefono = null;
		this.email = null;
		this.documento = null;
		this.nombreCicloMatriculado = null;
	}
	 /**
     * Constructor parametrizado de la clase Alumno.
     * 
     * @param idAlumno El ID del alumno.
     * @param nombre El nombre del alumno.
     * @param apellido1 El primer apellido del alumno.
     * @param apellido2 El segundo apellido del alumno (opcional).
     * @param telefono El número de teléfono del alumno.
     * @param email El correo electrónico del alumno.
     * @param documento El documento de identificación del alumno (NIF o NIE).
     * @param nombreCicloMatriculado El nombre del ciclo formativo en el que está matriculado el alumno.
     */
	public Alumno(String idAlumno, String nombre, String apellido1, String apellido2,
			String telefono, String email, String documento,
			String nombreCicloMatriculado) {
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.email = email;
		this.documento = documento;
		this.nombreCicloMatriculado = nombreCicloMatriculado;
	}
	/**
     * Constructor de copia de la clase Alumno.
     * 
     * @param alumno El alumno del que se va a realizar la copia.
     */
	public Alumno(Alumno alumno) {
		this.idAlumno = alumno.getId();
		this.nombre = alumno.getNombre();
		this.apellido1 = alumno.getApellido1();
		this.apellido2 = alumno.getApellido2();
		this.telefono = alumno.getTelefono();
		this.email = alumno.getEmail();
		this.documento = alumno.getDocumento();
		this.nombreCicloMatriculado = alumno.getNombreCicloMatriculado();
	}
	/**
     * Obtiene el ID del alumno.
     * 
     * @return El ID del alumno.
     */
	public String getId() {
		return idAlumno;
	}

	/**
	 * Establece el ID del alumno.
	 * 
	 * @param idAlumno El ID del alumno que se va a establecer. Debe seguir el formato ALUMXXXX, donde X es un digito.
	 * @return true si el ID se establecio correctamente, false si el formato del ID no es valido.
	 */
	public boolean setId(String idAlumno) {
		
		boolean validacionOK = Validar.validarPatron(idAlumno.toString(), "^ALUM[0-9]{4}$");
		
		if(validacionOK)
			this.idAlumno = idAlumno;
		
		return validacionOK;
	}

	/**
     * Obtiene el nombre del alumno.
     * 
     * @return El nombre del alumno.
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre del alumno.
	 * 
	 * @param nombre El nombre del alumno que se va a establecer. Debe contener entre 1 y 30 caracteres alfanumericos.
	 * @return true si el nombre se establecio correctamente, false si el nombre no cumple con el formato especificado.
	 */
	public boolean setNombre(String nombre) {
		boolean validacionOK = Validar.validarPatron(nombre.toString(), "^\\w{1,30}$");
		
		if (validacionOK)
			this.nombre = nombre;
		
		return validacionOK;
	}

	/**
     * Obtiene el primer apellido del alumno.
     * 
     * @return El primer apellido del alumno.
     */
	public String getApellido1() {
		return apellido1;
	}

	/**
     * Establece el primer apellido del alumno.
     * 
     * @param apellido1 El primer apellido del alumno que se va a establecer.
     * @return true si el apellido se establecio correctamente, false si el apellido no cumple con el formato especificado.
     */
	public boolean setApellido1(String apellido1) 
	{
		boolean validacionOK = Validar.validarPatron(apellido1.toString(), "^\\w{1,40}$");
		
		if (validacionOK)
			this.apellido1 = apellido1;
		
		return validacionOK;
	}

	/**
     * Obtiene el segundo apellido del alumno.
     * 
     * @return El segundo apellido del alumno.
     */
	public String getApellido2() {
		return apellido2;
	}

	/**
     * Establece el segundo apellido del alumno.
     * 
     * @param apellido2 El segundo apellido del alumno que se va a establecer.
     */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
     * Obtiene el numero de telefono del alumno.
     * 
     * @return El numero de telefono del alumno.
     */
	public String getTelefono() {
		return telefono;
	}

	/**
     * Establece el numero de telefono del alumno.
     * 
     * @param telefono El numero de telefono del alumno que se va a establecer.
     * @return true si el numero de telefono se establecio correctamente, false si el numero no cumple con el formato especificado.
     */
	public boolean setTelefono(String telefono) {
		
		boolean validacionOK = Validar.validarPatron(telefono.toString(), "^[679][0-9]{8}$");
		
		if (validacionOK)
			this.telefono = telefono;
		
		return validacionOK;
	}

	/**
     * Obtiene el correo electronico del alumno.
     * 
     * @return El correo electronico del alumno.
     */
	public String getEmail() {
		return email;
	}

	/**
     * Establece el correo electronico del alumno.
     * 
     * @param email El correo electronico del alumno que se va a establecer.
     * @return true si el correo electrónico se estableció correctamente, false si el correo electronico no cumple con el formato especificado.
     */
	public boolean setEmail(String email) 
	{
		boolean validacionOK = Validar.validarPatron(email.toString(), "^[a-zA-Z0-9_]+@alumno\\.es$");
		
		if (validacionOK)
			this.email = email;
		
		return validacionOK;
	}

	/**
     * Obtiene el documento de identificacion del alumno.
     * 
     * @return El documento de identificacion del alumno.
     */
	public String getDocumento() {
		return documento;
	}

	/**
     * Establece el documento de identificacion del alumno.
     * 
     * @param documento El documento de identificacion del alumno que se va a establecer.
     * @return true si el documento se establecio correctamente, false si el documento no cumple con el formato especificado.
     */
	public boolean setDocumento(String documento) 
	{
		boolean validacionOK = Validar.validarPatron(documento.toString(), "^[0-9]{8}[A-Z]$")
				|| Validar.validarPatron(documento.toString(), "^[XYZ][0-9]{7}[A-Z]$");
		
		if (validacionOK)
			this.documento = documento;
		
		return validacionOK;
	}

	/**
     * Obtiene el nombre del ciclo formativo en el que esta matriculado el alumno.
     * 
     * @return El nombre del ciclo formativo en el que esta matriculado el alumno.
     */
	public String getNombreCicloMatriculado() {
		return nombreCicloMatriculado;
	}

	/**
     * Establece el nombre del ciclo formativo en el que esta matriculado el alumno.
     * 
     * @param nombreCicloMatriculado El nombre del ciclo formativo que se va a establecer.
     */
	public void setNombreCicloMatriculado(String nombreCicloMatriculado) {
		this.nombreCicloMatriculado = nombreCicloMatriculado;
	}
	
	/* TEST */
	/**
     * Metodo de prueba que muestra la informacion del alumno por consola.
     */
	public void mostrarInformacion() 
	{
		System.out.println("--------------------------------------------");
		System.out.println("INFO ALUMNO:");
		System.out.println("--------------------------------------------");
		System.out.printf("ID: %s\n",this.getId());
		System.out.printf("Nombre: %s\n",this.getNombre());
		System.out.printf("Apellido1: %s\n", this.getApellido1());
		System.out.printf("Apellido2: %s\n", this.getApellido2() == null ? "" : this.getApellido2());
		System.out.printf("Teléfono: %s\n", this.getTelefono());
		System.out.printf("Email: %s\n", this.getEmail());
		System.out.printf("Documento: %s\n", this.getDocumento());
		System.out.printf("Nombre del ciclo: %s\n", this.getNombreCicloMatriculado() == null ? "" : this.getNombreCicloMatriculado());
		System.out.println("--------------------------------------------");
	}

}
