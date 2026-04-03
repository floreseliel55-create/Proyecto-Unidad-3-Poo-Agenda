import java.util.Scanner;
public class Principal {
    // Metodo que imprime el menu de opciones para el usuario
    public void menuOpciones(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Agenda de Contactos");
        System.out.println("1. Agregar Contacto");
        System.out.println("2. Eliminar Contacto");
        System.out.println("3. Buscar Contacto");
        System.out.println("4. Mostrar Contactos");
        System.out.println("5. Ordenar Contactos");
        System.out.println("6. Salir");
        int key = sc.nextInt();
        switch (key) {
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 5:
                break;
                case 6:
                System.out.println("Saliendo del programa...");
                return;
        
            default:
                break;
        }
    }
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.menuOpciones();

    }
}
