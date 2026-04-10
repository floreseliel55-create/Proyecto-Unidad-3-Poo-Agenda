//Proyecto Agenda
import java.util.ArrayList;

public class Contacto extends Persona{
    // Atributos de clase con valores por defecto - Gael
    private ArrayList<String> correo;
    private ArrayList<Telefono> listaTelefonos;
    // Constructor de la clase - Gael
    public Contacto(String nombre, String apellido, char sexo, String alias, String correo) {
        super(nombre, apellido, sexo, alias);
        this.correo = new ArrayList<>();
        this.correo.add(correo);
        this.listaTelefonos = new ArrayList<Telefono>();
    }
    // Metodos GET y SET - Gael
    public ArrayList<String> getCorreo() {
        return correo;
    }
    public void setCorreo(ArrayList<String> correo) {
        this.correo = correo;
    }
    public ArrayList<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }
    // Metodo para agregar un telefono a un contacto - Gael
    public void agregarTelefono(Telefono tel){
        this.listaTelefonos.add(tel);
    }
    //Metodo para eliminar un telefono de un contacto - Gael
    public void eliminarTelefono(Telefono tel){
        this.listaTelefonos.remove(tel);
    }
    //Metodo para devolver todos los telefonos de un tipo dado (M o F) - Gael
    public ArrayList<Telefono> getTelefonosPorTipo(char tipo){

        ArrayList<Telefono> resultado = new ArrayList<>();
        char t = Character.toUpperCase(tipo);

        for (Telefono tel : listaTelefonos) {
            if (tel.getTipoTelefono() == t) resultado.add(tel);
            }
        return resultado;
    }
    @Override
    public String toString() {        return "Contacto{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", sexo=" + getSexo() +
                ", alias='" + getAlias() + '\'' +
                ", correo='" + correo + '\'' +
                ", listaTelefonos=" + listaTelefonos +
                '}';
    }
    // Metodo para poner un correo mas a una persona - Eliel
    public void agregarCorreo(String correo){
        this.correo.add(correo);
    }

}
