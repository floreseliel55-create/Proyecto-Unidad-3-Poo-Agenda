// Sergio Eliel Flores Urquidy

// Programación orientada a Objetos 
// Maria Lucia Barron Estrada
// Programa de la Agenda

// Clase persona con 4 atributos para definir un contacto solo tiene los metodos get,set,toString
//  y un constructor para ser invocado cuando se inicialice.
import java.util.regex.Pattern;

public class Persona{
    // Atributos de clase con valores por defecto
    private String nombre;
    private String apellido;
    private char sexo;
    private String alias;

    // expresiones regulares para validar el formato de correo y telefono
    private static final Pattern regexSexo = Pattern.compile("^[MF]$");
    // Constructor de la clase
    public Persona(String nombre, String apellido, char sexo, String alias){
       this.nombre = nombre;
       this.apellido = apellido;
       setSexo(sexo);
       this.alias = alias;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        if (regexSexo.matcher(String.valueOf(sexo)).matches()) {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("Sexo inválido. Debe ser 'M' o 'F'.");
        }
    }
    @Override
    public String toString() {
        return nombre+","+apellido+","+sexo+","+alias;
    }
}