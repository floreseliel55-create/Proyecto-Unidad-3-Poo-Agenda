package ProyectoSolo;

public class Persona{
    // Atributos de clase con valores por defecto
    private String nombre="Sin nombre";
    private String apellido="Sin apellido";
    private char sexo='M';
    private String alias="Sin alias";
    // Constructor de la clase
    public Persona(String nombre, String apellido, char sexo, String alias){
       this.nombre = nombre;
       this.apellido = apellido;
       this.sexo = sexo;
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
        this.sexo = sexo;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + "]" + " alias=" + alias;
    }
}