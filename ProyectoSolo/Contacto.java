package ProyectoSolo;

import java.util.ArrayList;

public class Contacto extends Persona {

    private String correo="Sin correo";
    private ArrayList<Telefono> listaTelefonos;
    
    public Contacto(String nombre, String apellido, char sexo, String alias,String correo , ArrayList<Telefono> listaTelefonos){
        super(nombre, apellido, sexo, alias);
        this.correo=correo;
        this.listaTelefonos=listaTelefonos;
    }
    
}
