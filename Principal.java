import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

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
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
            case 1:
            System.out.println(agenda);
            break;

            case 2:
            System.out.print("Tipo (M/F): ");
            char tipo = sc.nextLine().charAt(0);

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

            if (agenda.agregarContacto(nuevo)) {
                System.out.println("Contacto agregado");
            } else {
            System.out.println("Alias ya existe");
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

    Contacto c = agenda.consultarPersona(dato);

    if (c != null) {
        System.out.println(c);
    } else {
        System.out.println("No encontrado");
    }
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
