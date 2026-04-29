// Gael Fernando Aguirre Soto

// Programación orientada a Objetos 
// Maria Lucia Barron Estrada
// Programa de la Agenda

// Clase contacto del proyeto que deriva de persona y tiene 2 atributos de arraylists de correo 
// y de lista de telefonos, asi como un constructor, metodos set y get y su tostring 
// y unas validaciones
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Contacto extends Persona {
    // Atributos de clase con valores por defecto
    private String correo;
    private ArrayList<Telefono> listaTelefonos;
    // Expresión regular para validar el formato del correo electrónico
    private static final Pattern regexCorreo = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,3}(\\.[a-z]{2,3})*$");
    // Expresion regular para validar el formato del número telefónico
    // Constructor de la clase
    public Contacto(String nombre, String apellido, char sexo, String alias, String correo) {
        super(nombre, apellido, sexo, alias);
        this.listaTelefonos = new ArrayList<>();
        setCorreo(correo);
    }

    public String getCorreo() {
        return correo;
    }

    public ArrayList<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }
    public void setCorreo(String correo){
        if (regexCorreo.matcher(correo).matches()) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo inválido. Debe tener un formato válido.");
        }
    }
    public void setlistaTelefonos(ArrayList<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    @Override
    public String toString() {
        return super.toString() + "," + (correo == null ? "sin correo" : correo) + "," + listaTelefonos;
    }

    

    
}
