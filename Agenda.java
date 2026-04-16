import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> listaContacto;

    public Agenda(){
        listaContacto = new ArrayList<Contacto>();
    }
    // a) Metodo toString para mostrar la agenda - Eliel
    @Override
    public String toString() {
        if (listaContacto.isEmpty()) {
            return "La agenda está vacía.";
        }

        String resultado = "=== AGENDA ===\n";
        // Recorro la lista de contactos y voy concatenando su representación en el resultado
        for (int i = 0; i < listaContacto.size(); i++) {
            // añade al "=== AGENDA ===\n" el toString de cada contacto con separaciones
            resultado += listaContacto.get(i).toString() + "\n";
            resultado += "----------------------\n";
        }

        return resultado;
    }
    // b) Metodo que me devuelve una lista de contactos que tienen al menos un telefono del tipo dado (M o F) - Eliel
    public ArrayList<Contacto> getContactosPorTipoTelefono(char tipo){
        // arreglo donde guardo los contactos que cumplen la condición
        ArrayList<Contacto> resultado = new ArrayList<>();
        // convierto el tipo a mayúscula para evitar problemas de comparación
        char t = Character.toUpperCase(tipo);
        // Recorro la lista de contactos
        for (Contacto contacto : listaContacto) {
            // Recorro la lista de teléfonos de cada contacto
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
    // c) Metodo para agregar una persona a la agenda, evitando duplicados por alias - Eliel
    public boolean agregarContacto(Contacto c){
    for (int i = 0; i < listaContacto.size(); i++) {
        // comparo el alias del contacto a agregar con los alias de los contactos ya en la agenda, ignorando mayúsculas y minúsculas
        if (listaContacto.get(i).getAlias().equalsIgnoreCase(c.getAlias())) {
            return false; // evita duplicados
        }
    }
    listaContacto.add(c);
    return true;
    }
    // d) Metodo para agregar correo a una persona 
    public boolean agregarCorreoAContacto(String alias, String correo){
    for (int i = 0; i < listaContacto.size(); i++) {
        if (listaContacto.get(i).getAlias().equalsIgnoreCase(alias)) {
            listaContacto.get(i).agregarCorreo(correo);
            return true;
        }
    }
    return false;
    }
    // e) Metodo para agregar telefono a una persona - Gael
    public boolean agregarTelefonoAContacto(String alias, Telefono tel){
        for (Contacto contacto : listaContacto) {
            if (contacto.getAlias().equalsIgnoreCase(alias)) {
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
            if (contacto.getAlias().equalsIgnoreCase(alias)) {
                listaContacto.remove(contacto);
                System.out.println("Contacto con alias " + alias + " eliminado");
                return true;
            }
        }
        System.out.println("No se encontró el contacto con alias " + alias);
        return false;
    }
    // g) Metodo para eliminar un telefono de un contacto dado su alias y el numero de telefono - Carlos
    public boolean eliminarTelefonoDeContacto(String alias, String numero) {
        for (Contacto contacto : listaContacto) {
            if (contacto.getAlias().equalsIgnoreCase(alias)) {
                // esta función devuelve true si se eliminó el teléfono y false si no se encontró el teléfono en el contacto
                boolean eliminado = contacto.eliminarTelefono(numero);
                if (eliminado) {
                    System.out.println("Teléfono " + numero + " eliminado del contacto " + alias);
                } else {
                    System.out.println("No se encontró el teléfono " + numero + " en el contacto " + alias);
                }
                return eliminado;
            }
        }
        System.out.println("No se encontró el contacto con alias " + alias);
        return false;
    }
    // h) Metodo para consultar a una persona por nombre o alias
    public Contacto consultarPersona(String dato){
    for (int i = 0; i < listaContacto.size(); i++) {
        Contacto c = listaContacto.get(i);

        if (c.getNombre().equalsIgnoreCase(dato) ||
            c.getAlias().equalsIgnoreCase(dato)) {
            return c;
        }
    }
    return null;
}


    
}
