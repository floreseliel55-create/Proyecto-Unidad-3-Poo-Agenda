// Sergio Eliel Flores Urquidy
// Gael Fernando Aguirre Soto
// Carlos Eduardo Chairez Audelo

// Programación orientada a Objetos 
// Maria Lucia Barron Estrada
// Programa de la Agenda

// La agenda controla todo lo que se puede hacer con los contactos 
import java.util.ArrayList;
import java.util.Collections;

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

        StringBuffer resultado = new StringBuffer("=== AGENDA ===\n");
        // Recorro la lista de contactos y voy concatenando su representación en el resultado
        for (int i = 0; i < listaContacto.size(); i++) {
            // añade al "=== AGENDA ===\n" el toString de cada contacto con separaciones
            resultado.append(listaContacto.get(i).toString());
            resultado.append("\n");
            resultado.append("----------------------\n");
        }

        return resultado.toString();
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
        for (int i = 0; i < listaContacto.size(); i++) {
        if (listaContacto.get(i).getAlias().equalsIgnoreCase(alias)) {
            listaContacto.remove(i);
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
    public ArrayList<Contacto> consultarPersona(String dato){
    ArrayList<Contacto> resultados = new ArrayList<>();

    for (Contacto c : listaContacto) {
        if (c.getNombre().toLowerCase().contains(dato.toLowerCase()) ||
            c.getAlias().toLowerCase().contains(dato.toLowerCase())) {
            resultados.add(c);
        }
    }

    return resultados;
}

    // Metodo para Ordenar la agenda por nombre y apellido
    public void ordenarAgenda(){
        // Collection.sort aqui me pregunta que voy a comparar, le digo que voy a comparar de una 
        // lista de contactos un contacto con otro llamados c1 y c2
       Collections.sort(listaContacto, (c1, c2) -> {
        // Entonces compara el nombre de c1 con el nombre de c2, y con el metodo compareToIgnoreCase
        // ignora mayusculas y minusculas y eso compara en orden alfabetico 
        // me devuelve un valor entero que se que si es negativo, significa que c1 va antes y si es positivo al reves
    int resultado = c1.getNombre().compareToIgnoreCase(c2.getNombre());
        // en caso de ser iguales entonces compara los apellidos, y hace lo mismo que con los nombres
    if (resultado == 0) {
        resultado = c1.getApellido().compareToIgnoreCase(c2.getApellido());
        // si ambos son iguales, entonces devuelve 0, lo que significa que no hay un orden entre ellos
    }

    return resultado;
});
    }

}
