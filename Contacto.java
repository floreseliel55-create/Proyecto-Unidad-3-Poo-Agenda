// Gael Fernando Aguirre Soto

// Programación orientada a Objetos 
// Maria Lucia Barron Estrada
// Programa de la Agenda

// Clase contacto del proyeto que deriva de persona y tiene 2 atributos de arraylists de correo 
// y de lista de telefonos, asi como un constructor, metodos set y get y su tostring 
// y unas validaciones
import java.util.ArrayList;

public class Contacto extends Persona{
    // Atributos de clase con valores por defecto - Gael
    private ArrayList<String> correo;
    private ArrayList<Telefono> listaTelefonos;
    // Constructor de la clase - Gael
    public Contacto(String nombre, String apellido, char sexo, String alias, String correo) {
    super(nombre, apellido, sexo, alias);
    this.correo = new ArrayList<>();
    this.listaTelefonos = new ArrayList<>();
}
    // Metodos GET y SET - Gael
    public ArrayList<String> getCorreo() {
        return correo;
    }
    public ArrayList<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setCorreo(ArrayList<String> correo) {
    this.correo = correo;
}

    public void setListaTelefonos(ArrayList<Telefono> listaTelefonos) {
    this.listaTelefonos = listaTelefonos;
}
     
    @Override
    public String toString() {  return super.toString()+"," + correo + '\'' +"," + listaTelefonos +
'}';
    }
}