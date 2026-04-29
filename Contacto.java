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

    if (esCorreoValido(correo)) {
        this.correo.add(correo);
    } else {
        System.out.println("Correo inicial inválido");
    }
}
    // Metodos GET y SET - Gael
    public ArrayList<String> getCorreo() {
        return correo;
    }
    public ArrayList<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }
    // Metodo para agregar un telefono a un contacto - Gael
    public void agregarTelefono(Telefono tel){

    String num = tel.getNumeroTelefonico();

    if (!esTelefonoValido(num)) {
        System.out.println("Número inválido");
        return;
    }

    // Evitar duplicados
    for (Telefono t : listaTelefonos) {
        if (t.getNumeroTelefonico().equals(num)) {
            System.out.println("Número repetido");
            return;
        }
    }

    listaTelefonos.add(tel);
}
    //Metodo para eliminar un telefono de un contacto - Gael
    public boolean eliminarTelefono(String numero) {
    for (int i = 0; i < listaTelefonos.size(); i++) {
        if (listaTelefonos.get(i).getNumeroTelefonico().equals(numero)) {
            listaTelefonos.remove(i);
            return true;
        }
    }
    return false;
}

        // Metodo para validar un numero de telefono - Gael
    private boolean esTelefonoValido(String numero) {
    if (numero == null) return false;

    // Debe tener exactamente 10 caracteres
    if (numero.length() != 10) return false;

    // Verificar que todos sean números
    for (int i = 0; i < numero.length(); i++) {
        if (!Character.isDigit(numero.charAt(i))) {
            return false;
        }
    }

    return true;
}
    @Override
    public String toString() {  return super.toString()+"," + correo + '\'' +"," + listaTelefonos +
'}';
    }
    // Metodo para poner un correo mas a una persona - Eliel
    public void agregarCorreo(String correo){
    if (esCorreoValido(correo)) {
        if (!this.correo.contains(correo)) {
            this.correo.add(correo);
        }
    } else {
        System.out.println("Correo inválido");
    }
}
    // Metodo para validar un correo - Gael
    private boolean esCorreoValido(String correo) {
    if (correo == null) return false;

    // Debe tener @ y .
    if (!correo.contains("@") || !correo.contains(".")) return false;

    // No debe tener espacios
    if (correo.contains(" ")) return false;

    return true;
}

}
