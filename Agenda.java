import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> listaContacto;

    public Agenda(){
        listaContacto = new ArrayList<Contacto>();
    }
    public String toString() {
        return "Agenda{" +
                "listaContacto=" + listaContacto +
                '}';
    }
    // Metodo que me devuelve una lista de contactos que tienen al menos un telefono del tipo dado (M o F) - Gael
    public ArrayList<Contacto> getContactosPorTipoTelefono(char tipo){
        // arreglo donde guardo los contactos que cumplen la condición
        ArrayList<Contacto> resultado = new ArrayList<>();
        // convierto el tipo a mayúscula para evitar problemas de comparación
        char t = Character.toUpperCase(tipo);
        // Recorro el arreglo de contactos y su lista
        for (Contacto contacto : listaContacto) {
            for (Telefono tel : contacto.getListaTelefonos()) {
                // si el tipo de telefono coincide con el tipo dado, lo agrego al array y salgo para evitar agregar el mismo contacto varias veces
                if (tel.getTipoTelefono() == t) {
                    resultado.add(contacto);
                    break;
                }
            }
        }
        return resultado;
    }
    // e) Metodo para agregar telefono a una persona - Gael
    public boolean agregarTelefonoAContacto(String alias, Telefono tel){
        for (Contacto contacto : listaContacto) {
            if (contacto.getAlias().equals(alias)) {
                contacto.agregarTelefono(tel);
                System.out.println("Telefono agregado al contacto " + alias);
                return true;
            }
        }
        System.out.println("No se encontró el contacto con alias " + alias);
        return false;
    } 
    // f) Metodo para eliminar un contacto por su alias - Gael
    public boolean eliminarContactoPorAlias(String alias){
        for (Contacto contacto : listaContacto) {
            if (contacto.getAlias().equals(alias)) {
                listaContacto.remove(contacto);
                System.out.println("Contacto con alias " + alias + " eliminado");
                return true;
            }
        }
        System.out.println("No se encontró el contacto con alias " + alias);
        return false;
    }


    
}
