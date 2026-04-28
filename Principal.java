// Equipo:
// Sergio Eliel Flores Urquidy
// Gael Fernando Aguirre Soto
// Carlos Eduardo Chairez Audelo

// Programación orientada a Objetos 
// Maria Lucia Barron Estrada
// Programa de la Agenda

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

// CONTACTOS DE PRUEBA
Contacto c1 = new Contacto("Juan", "Perez", 'M', "juanp", "juan@gmail.com");
c1.agregarTelefono(new Telefono('M', "+52", "6671234567"));

Contacto c2 = new Contacto("Maria", "Lopez", 'F', "marial", "maria@hotmail.com");
c2.agregarTelefono(new Telefono('F', "+52", "6679876543"));

Contacto c3 = new Contacto("Carlos", "Ramirez", 'M', "carlosr", "carlos@gmail.com");
c3.agregarTelefono(new Telefono('M', "+52", "6671112233"));

Contacto c4 = new Contacto("Ana", "Torres", 'F', "anat", "ana@yahoo.com");
c4.agregarTelefono(new Telefono('F', "+52", "6674445566"));

Contacto c5 = new Contacto("Luis", "Gomez", 'M', "luisg", "luis@gmail.com");
c5.agregarTelefono(new Telefono('M', "+52", "6677778899"));

// Agregar a la agenda
agenda.agregarContacto(c1);
agenda.agregarContacto(c2);
agenda.agregarContacto(c3);
agenda.agregarContacto(c4);
agenda.agregarContacto(c5);

        int opcion;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Mostrar agenda");
            System.out.println("2. Mostrar contactos por tipo de teléfono");
            System.out.println("3. Agregar contacto");
            System.out.println("4. Agregar correo");
            System.out.println("5. Agregar teléfono");
            System.out.println("6. Eliminar contacto");
            System.out.println("7. Eliminar teléfono");
            System.out.println("8. Consultar persona");
            System.out.println("9. Ordenar agenda");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                // Imprime Metodo toString para mostrar la agenda 
            case 1:
            System.out.println(agenda);
            break;
                // Imprime los contactos que tienen al menos un telefono del tipo dado (M o F)
            case 2:
            System.out.print("Tipo (M/F): ");
            // se pone charAt(0) para tomar solo el primer caracter si es que se ingresa algo mas
            char tipo = sc.nextLine().charAt(0);
            // recorro la lista de contactos que cumplen la condición y los imprimo    
            for (Contacto c : agenda.getContactosPorTipoTelefono(tipo)) {
                System.out.println(c);
            }
            break;
            case 3:
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Apellido: ");
            String apellido = sc.nextLine();

            System.out.print("Sexo (M/F): ");
            char sexo = sc.nextLine().charAt(0);

            System.out.print("Alias: ");
            String alias = sc.nextLine();

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            Contacto nuevo = new Contacto(nombre, apellido, sexo, alias, correo);
            // Si agenda.agregarContacto(nuevo) devuelve true, se agregó correctamente, si devuelve false es porque el alias ya existe
            if (agenda.agregarContacto(nuevo)) {
                System.out.println("Contacto agregado");
            } else {
            System.out.println("Contacto ya existe");
            }
            break;
            case 4:
            System.out.print("Alias: ");
            String aliasCorreo = sc.nextLine();

            System.out.print("Nuevo correo: ");
            String nuevoCorreo = sc.nextLine();

            if (agenda.agregarCorreoAContacto(aliasCorreo, nuevoCorreo)) {
                System.out.println("Correo agregado");
            } else {
                System.out.println("No se encontró contacto");
            }
            break;
            case 5:
            System.out.print("Alias: ");
            String aliasTel = sc.nextLine();

            System.out.print("Tipo (M/F): ");
            char tipoTel = sc.nextLine().charAt(0);

            System.out.print("Clave país: ");
            String clave = sc.nextLine();

            System.out.print("Número: ");
            String numero = sc.nextLine();

            Telefono tel = new Telefono(tipoTel, clave, numero);

            if (agenda.agregarTelefonoAContacto(aliasTel, tel)) {
                System.out.println("Teléfono agregado");
            } else {
            System.out.println("No se encontró contacto");
            }
            break;
            
            case 6:
    System.out.print("Alias: ");
    String aliasEliminar = sc.nextLine();

    if (agenda.eliminarContactoPorAlias(aliasEliminar)) {
        System.out.println("Eliminado");
    } else {
        System.out.println("No encontrado");
    }
    break;
    case 7:
    System.out.print("Alias: ");
    String aliaseTel = sc.nextLine();

    System.out.print("Número: ");
    String num = sc.nextLine();

    if (agenda.eliminarTelefonoDeContacto(aliaseTel, num)) {
        System.out.println("Teléfono eliminado correctamente.");
    } else {
        System.out.println("No se pudo eliminar (contacto o número no encontrado).");
    }
    break;
    case 8:
    System.out.print("Nombre o alias: ");
    String dato = sc.nextLine();

    ArrayList<Contacto> resultados = agenda.consultarPersona(dato);

    if (resultados.isEmpty()) {
        System.out.println("No encontrado");
    } else {
        for (Contacto c : resultados) {
            System.out.println(c);
        }
    }
    break;
    case 9:
    System.out.println("Ordenando agenda...");
    agenda.ordenarAgenda();
    System.out.println("Agenda ordenada.");
    System.out.println(agenda);
    break;
    case 0:
    System.out.println("Saliendo...");
    break;

    default:
    System.out.println("Opción inválida");

    }        
            
        } while (opcion != 0);
    }
}
