package validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase para realizar las validaciones de la aplicacion.
 */
public class Validar 
{
    /**
     * Metodo principal para probar la validacion de un texto segun un patron.
     * @param args Los argumentos de la linea de comandos (no se utilizan).
     */
    public static void main(String[] args) 
    {
        boolean ok = validarPatron("minombre@alumno.es","^[a-zA-Z0-9_]+@alumno\\.[a-zA-Z0-9]{2,3}$");
                
        if(ok) 
            System.out.println("Validado");
        else
            System.out.println("No validado");
    }
    
    /**
     * Valida si un texto cumple con un patron determinado.
     * @param texto El texto a validar.
     * @param patron El patron contra el cual se valida el texto.
     * @return True si el texto cumple con el patron, False de lo contrario.
     */
    public static boolean validarPatron(String texto, String patron) 
    {
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(texto);
        
        return m.matches();
    }
}
