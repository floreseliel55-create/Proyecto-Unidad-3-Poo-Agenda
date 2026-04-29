import java.util.ArrayList;
import java.util.Scanner;

// Clase principal que ejecuta el programa de agenda.
public class Principal {
    // Método principal que inicia la aplicación.
    public static void main(String[] args) {
        // Inicialización del scanner para entrada de usuario y la agenda.
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        // Creación de contactos de prueba.
        Contacto c1 = new Contacto("Juan", "Perez", 'M', "juanp", "juan@gmail.com");
        Contacto c2 = new Contacto("Maria", "Lopez", 'F', "marial", "maria@hotmail.com");
        Contacto c3 = new Contacto("Carlos", "Ramirez", 'M', "carlosr", "carlos@gmail.com");
        Contacto c4 = new Contacto("Ana", "Torres", 'F', "anat", "ana@yahoo.com");
        Contacto c5 = new Contacto("Luis", "Gomez", 'M', "luisg", "luis@gmail.com");

        // Agregar contactos a la agenda.
        agenda.agregarContacto(c1);
        agenda.agregarContacto(c2);
        agenda.agregarContacto(c3);
        agenda.agregarContacto(c4);
        agenda.agregarContacto(c5);

        // Agregar teléfonos a los contactos.
        agenda.agregarTelefonoAContacto("juanp", new Telefono('M', "+52", "6671234567"));
        agenda.agregarTelefonoAContacto("marial", new Telefono('F', "+52", "6679876543"));
        agenda.agregarTelefonoAContacto("carlosr", new Telefono('M', "+52", "6671112233"));
        agenda.agregarTelefonoAContacto("anat", new Telefono('F', "+52", "6674445566"));
        agenda.agregarTelefonoAContacto("luisg", new Telefono('M', "+52", "6677778899"));

        // Variable para la opción del menú.
        int opcion;

        // Bucle principal del menú.
        do {
            // Mostrar menú de opciones.
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

            // Validar entrada como número entero.
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            // Manejo de opciones del menú.
            switch (opcion) {
                case 1: // Mostrar agenda completa.
                    System.out.println(agenda);
                    break;

                case 2: // Mostrar contactos por tipo de teléfono.
                    System.out.print("Tipo (M/F): ");
                    String entradaTipo = sc.nextLine().trim();
                    if (entradaTipo.isEmpty()) {
                        System.out.println("Debes ingresar M o F.");
                        break;
                    }
                    char tipo = entradaTipo.toUpperCase().charAt(0);
                    for (Contacto c : agenda.getContactosPorTipoTelefono(tipo)) {
                        System.out.println(c);
                    }
                    break;

                case 3: // Agregar nuevo contacto.
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Sexo (M/F): ");
                    char sexo = sc.nextLine().toUpperCase().charAt(0);
                    System.out.print("Alias: ");
                    String alias = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();

                    try {
                        Contacto nuevo = new Contacto(nombre, apellido, sexo, alias, correo);
                        if (agenda.agregarContacto(nuevo)) {
                            System.out.println("Contacto agregado.");
                        } else {
                            System.out.println("Ya existe un contacto con ese alias.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Dato inválido: " + e.getMessage());
                    }
                    break;

                case 4: // Agregar correo a contacto existente.
                    System.out.print("Alias: ");
                    String aliasCorreo = sc.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = sc.nextLine();

                    try {
                        if (agenda.agregarCorreoAContacto(aliasCorreo, nuevoCorreo)) {
                            System.out.println("Correo agregado");
                        } else {
                            System.out.println("No se encontró contacto o el correo es inválido");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error al agregar correo: " + e.getMessage());
                    }
                    break;

                case 5: // Agregar teléfono a contacto.
                    System.out.print("Alias: ");
                    String aliasTel = sc.nextLine();

                    System.out.print("Tipo (M/F): ");
                    char tipoTel = sc.nextLine().toUpperCase().charAt(0);

                    System.out.print("Clave país (ej. +52): ");
                    String clave = sc.nextLine();

                    System.out.print("Número (10 dígitos): ");
                    String numero = sc.nextLine();

                    try {
                        Telefono tel = new Telefono(tipoTel, clave, numero);
                        if (agenda.agregarTelefonoAContacto(aliasTel, tel)) {
                            System.out.println("Teléfono agregado correctamente.");
                        } else {
                            System.out.println("No se pudo agregar: contacto no encontrado o número repetido.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Dato inválido: " + e.getMessage());
                    }
                    break;

                case 6: // Eliminar contacto por alias.
                    System.out.print("Alias: ");
                    String aliasEliminar = sc.nextLine();
                    if (agenda.eliminarContactoPorAlias(aliasEliminar)) {
                        System.out.println("Eliminado");
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;

                case 7: // Eliminar teléfono de contacto.
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

                case 8: // Consultar contactos por nombre o alias.
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

                case 9: // Ordenar agenda alfabéticamente.
                    System.out.println("Ordenando agenda...");
                    agenda.ordenarAgenda();
                    System.out.println("Agenda ordenada.");
                    System.out.println(agenda);
                    break;

                case 0: // Salir del programa.
                    System.out.println("Saliendo...");
                    break;

                default: // Opción inválida.
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}
