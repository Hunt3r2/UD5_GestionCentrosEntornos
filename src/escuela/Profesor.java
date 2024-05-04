package escuela;

import validacion.Validar;

/**
 * La clase Profesor representa a un profesor en la escuela, con diversas características como nombre, apellido, 
 * telefono, email, documento de identidad, sueldo, entre otros.
 */
public class Profesor 
{
	private String idProfesor; // PROFXXXX
	private String nombre; // ^\w{1,30}$
	private String apellido1; // ^\w{1,40}$
	private String apellido2; // opcional
	private String telefono; // [679][0-9]{8}
	private String email; // XXXXXX@PROFESOR.COM
	private String documento; //NIF: ^[0-9]{8}[A-Z]$ ; NIE: ^[XYZ][0-9]{7}[A-Z]$
	
	private boolean esTutor;
	private double sueldo; // > 0
	private int diasAsuntosPropios; // >= 0
	
	/**
     * Metodo principal que realiza pruebas sobre los metodos de la clase Profesor.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
	public static void main(String[] args) 
	{
		try 
		{
			Profesor nuevoProfesor = new Profesor();
			
			boolean validar = nuevoProfesor.setId("PRUEBA");
			
			if(validar)
				System.out.println("ID profesor 'PRUEBA' OK");
			else
				System.out.println("ID profesor 'PRUEBA' KO");
			
			validar = nuevoProfesor.setId("ALUM0001");
			
			if(validar)
				System.out.println("ID profesor 'PROF0001' OK");
			else
				System.out.println("ID profesor 'PROF0001' KO");
			
			System.out.println("--------------------------------");
			
			validar = nuevoProfesor.setNombre("sdsadsadsadsadsadasdasdsadasasdsadadas");
			
			if(validar)
				System.out.println("Nombre profesor 'sdsadsadsadsadsadasdasdsadasasdsadadas' OK");
			else
				System.out.println("Nombre profesor 'sdsadsadsadsadsadasdasdsadasasdsadadas' KO");
			
			validar = nuevoProfesor.setNombre("Hugo");
			
			if(validar)
				System.out.println("Nombre profesor 'Hugo' OK");
			else
				System.out.println("Nombre profesor 'Hugo' KO");
			
			System.out.println("--------------------------------");
			
			validar = nuevoProfesor.setApellido1(" ");
			
			if(validar)
				System.out.println("Apellido 1 profesor ' ' OK");
			else
				System.out.println("Apellido 1 profesor ' ' KO");
			
			validar = nuevoProfesor.setApellido1("Vegas");
			
			if(validar)
				System.out.println("Apellido 1 profesor 'Vegas' OK");
			else
				System.out.println("Apellido 1 profesor 'Vegas' KO");
			
			System.out.println("--------------------------------");
			
			nuevoProfesor.setApellido2("Carrasco");
			
			validar = nuevoProfesor.setTelefono("555555555");
			
			if(validar)
				System.out.println("Telefono profesor '555555555' OK");
			else
				System.out.println("Telefono profesor '555555555' KO");
			
			validar = nuevoProfesor.setTelefono("915435701");
			
			if(validar)
				System.out.println("Telefono profesor '915435701' OK");
			else
				System.out.println("Telefono profesor '915435701' KO");
			
			System.out.println("--------------------------------");
			
			validar = nuevoProfesor.setEmail("hugovegas@alumno.es");
			
			if(validar)
				System.out.println("Email profesor 'hugovegas@profesor.es' OK");
			else
				System.out.println("Email profesor 'hugovegas@profesor.es' KO");
			
			validar = nuevoProfesor.setEmail("hugovegas@profesor.es");
			
			if(validar)
				System.out.println("Email profesor 'hugovegas@alumno.es' OK");
			else
				System.out.println("Email profesor 'hugovegas@alumno.es' KO");
			
			System.out.println("--------------------------------");
			
			validar = nuevoProfesor.setDocumento("123456789Z");
			
			if(validar)
				System.out.println("Documento profesor '123456789Z' OK");
			else
				System.out.println("Documento profesor '123456789Z' KO");
			
			validar = nuevoProfesor.setDocumento("Y1234567Z");
			
			if(validar)
				System.out.println("Documento profesor 'Y1234567Z' OK");
			else
				System.out.println("Documento profesor 'Y1234567Z' KO");
			
			System.out.println("--------------------------------");
			
			nuevoProfesor.setEsTutor(true);
			nuevoProfesor.setDiasAsuntosPropios(5);
			
			validar = nuevoProfesor.setSueldo(-1000);
			
			if(validar)
				System.out.println("Sueldo profesor -1000 OK");
			else
				System.out.println("Sueldo profesor -1000 KO");
			
			validar = nuevoProfesor.setSueldo(1500.75);
			
			if(validar)
				System.out.println("Sueldo profesor 1500.75 OK");
			else
				System.out.println("Sueldo profesor 1500.75 KO");
			
			System.out.println("--------------------------------");
			
			nuevoProfesor.mostrarInformacion();
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	/**
     * Constructor por defecto de la clase Profesor.
     */
	public Profesor() {
		this.idProfesor = null;
		this.nombre = null;
		this.apellido1 = null;
		this.apellido2 = null;
		this.telefono = null;
		this.email = null;
		this.documento = null;
		this.esTutor = false;
		this.sueldo = 0.0;
		this.diasAsuntosPropios = 0;
	}
	
	/**
     * Constructor de la clase Profesor.
     * @param idProfesor El ID del profesor.
     * @param nombre El nombre del profesor.
     * @param apellido1 El primer apellido del profesor.
     * @param apellido2 El segundo apellido del profesor (opcional).
     * @param telefono El número de teléfono del profesor.
     * @param email El correo electrónico del profesor.
     * @param documento El documento de identidad del profesor.
     * @param esTutor Indica si el profesor es tutor o no.
     * @param sueldo El sueldo del profesor.
     * @param diasAsuntosPropios Los días de asuntos propios del profesor.
     */
	public Profesor(String idProfesor, String nombre, String apellido1, String apellido2,
			String telefono, String email, String documento, boolean esTutor, double sueldo,
			int diasAsuntosPropios) {
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.email = email;
		this.documento = documento;
		this.esTutor = esTutor;
		this.sueldo = sueldo;
		this.diasAsuntosPropios = diasAsuntosPropios;
	}
	
	/**
     * Constructor de copia de la clase Profesor.
     * @param profesor El profesor a copiar.
     */
	public Profesor(Profesor profesor) {
		this.idProfesor = profesor.getId();
		this.nombre = profesor.getNombre();
		this.apellido1 = profesor.getApellido1();
		this.apellido2 = profesor.getApellido2();
		this.telefono = profesor.getTelefono();
		this.email = profesor.getEmail();
		this.documento = profesor.getDocumento();
		this.esTutor = profesor.getEsTutor();
		this.sueldo = profesor.getSueldo();
		this.diasAsuntosPropios = profesor.getDiasAsuntosPropios();
	}

	/**
     * Obtiene el ID del profesor.
     * @return El ID del profesor.
     */
	public String getId() {
		return idProfesor;
	}

	/**
     * Establece el ID del profesor.
     * @param idProfesor El nuevo ID del profesor.
     * @return True si el ID es válido, False de lo contrario.
     */
	public boolean setId(String idProfesor) {
		
		boolean validacionOK = Validar.validarPatron(idProfesor.toString(), "^PROF[0-9]{4}$");
		
		if(validacionOK)
			this.idProfesor = idProfesor;
		
		return validacionOK;
	}

	/**
     * Obtiene el nombre del profesor.
     * @return El nombre del profesor.
     */
	public String getNombre() {
		return nombre;
	}

	/**
     * Establece el nombre del profesor.
     * @param nombre El nuevo nombre del profesor.
     * @return True si el nombre es valido, False de lo contrario.
     */
	public boolean setNombre(String nombre) {
		boolean validacionOK = Validar.validarPatron(nombre.toString(), "^\\w{1,30}$");
		
		if (validacionOK)
			this.nombre = nombre;
		
		return validacionOK;
	}

	/**
     * Obtiene el primer apellido del profesor.
     * @return El primer apellido del profesor.
     */
	public String getApellido1() {
		return apellido1;
	}

	/**
     * Establece el primer apellido del profesor.
     * @param apellido1 El nuevo primer apellido del profesor.
     * @return True si el apellido es valido, False de lo contrario.
     */
	public boolean setApellido1(String apellido1) 
	{
		boolean validacionOK = Validar.validarPatron(apellido1.toString(), "^\\w{1,40}$");
		
		if (validacionOK)
			this.apellido1 = apellido1;
		
		return validacionOK;
	}

	/**
     * Obtiene el segundo apellido del profesor.
     * @return El segundo apellido del profesor.
     */
	public String getApellido2() {
		return apellido2;
	}

	/**
     * Establece el segundo apellido del profesor.
     * @param apellido2 El nuevo segundo apellido del profesor.
     */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
     * Obtiene el telefono del profesor.
     * @return El telefono del profesor.
     */
	public String getTelefono() {
		return telefono;
	}

	/**
     * Establece el telefono del profesor.
     * @param telefono El nuevo telefono del profesor.
     * @return True si el telefono es valido, False de lo contrario.
     */
	public boolean setTelefono(String telefono) {
		
		boolean validacionOK = Validar.validarPatron(telefono.toString(), "^[679][0-9]{8}$");
		
		if (validacionOK)
			this.telefono = telefono;
		
		return validacionOK;
	}

	/**
     * Obtiene el email del profesor.
     * @return El email del profesor.
     */
	public String getEmail() {
		return email;
	}

	/**
     * Establece el email del profesor.
     * @param email El nuevo email del profesor.
     * @return True si el email es valido, False de lo contrario.
     */
	public boolean setEmail(String email) 
	{
		boolean validacionOK = Validar.validarPatron(email.toString().toLowerCase(), "^[a-zA-Z0-9_]+@profesor\\.es$");
		
		if (validacionOK)
			this.email = email;
		
		return validacionOK;
	}

	/**
     * Obtiene el documento de identidad del profesor.
     * @return El documento de identidad del profesor.
     */
	public String getDocumento() {
		return documento;
	}

	/**
     * Establece el documento de identidad del profesor.
     * @param documento El nuevo documento de identidad del profesor.
     * @return True si el documento es valido, False de lo contrario.
     */
	public boolean setDocumento(String documento) 
	{
		boolean validacionDNI = Validar.validarPatron(documento.toUpperCase(), "^[0-9]{8}[A-Z]$");
		boolean validacionNIE = Validar.validarPatron(documento.toUpperCase(), "^[XYZ][0-9]{7}[A-Z]$");
		
		boolean validacionOK = validacionDNI || validacionNIE;
		
		if (validacionOK)
			this.documento = documento;
		
		return validacionOK;
	}

	/**
     * Indica si el profesor es tutor o no.
     * @return True si el profesor es tutor, False de lo contrario.
     */
	public boolean getEsTutor() {
		return esTutor;
	}

	/**
     * Establece si el profesor es tutor o no.
     * @param esTutor True si el profesor es tutor, False de lo contrario.
     */
	public void setEsTutor(boolean esTutor) {
		this.esTutor = esTutor;
	}

	/**
     * Obtiene el sueldo del profesor.
     * @return El sueldo del profesor.
     */
	public double getSueldo() {
		return sueldo;
	}

	/**
     * Establece el sueldo del profesor.
     * @param sueldo El nuevo sueldo del profesor.
     * @return True si el sueldo es valido, False de lo contrario.
     */
	public boolean setSueldo(double sueldo) 
	{
		boolean validar = sueldo > 0;
		
		if (validar)
			this.sueldo = sueldo;
		
		return validar;
	}

	/**
     * Obtiene los dias de asuntos propios del profesor.
     * @return Los dias de asuntos propios del profesor.
     */
	public int getDiasAsuntosPropios() {
		return diasAsuntosPropios;
	}

	/**
     * Establece los dias de asuntos propios del profesor.
     * @param diasAsuntosPropios Los nuevos días de asuntos propios del profesor.
     * @return True si los días son validos, False de lo contrario.
     */
	public boolean setDiasAsuntosPropios(int diasAsuntosPropios) {
		boolean validar = diasAsuntosPropios >= 0;
		
		if (validar)
			this.diasAsuntosPropios = diasAsuntosPropios;
		
		return validar;
	}
	
	/**
     * Muestra la informacion del profesor.
     */
	public void mostrarInformacion() 
	{
		System.out.println("--------------------------------------------");
		System.out.println("INFO PROFESOR:");
		System.out.println("--------------------------------------------");
		System.out.printf("ID: %s\n",this.getId());
		System.out.printf("Nombre: %s\n",this.getNombre());
		System.out.printf("Apellido1: %s\n", this.getApellido1());
		System.out.printf("Apellido2: %s\n", this.getApellido2() == null ? "" : this.getApellido2());
		System.out.printf("Teléfono: %s\n", this.getTelefono());
		System.out.printf("Email: %s\n", this.getEmail());
		System.out.printf("Documento: %s\n", this.getDocumento());
		System.out.printf("Es tutor: %s\n", (this.getEsTutor() ? "Sí" : "No"));
		System.out.printf("Sueldo: %.2f euros\n", this.getSueldo());
		System.out.printf("Días de asuntos propios: %d\n", this.getDiasAsuntosPropios());
		System.out.println("--------------------------------------------");
	}
}
