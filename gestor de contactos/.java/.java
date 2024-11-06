import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagerSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> contactos = new ArrayList<>();
        int opcion;

        do {
            // Menú sencillo
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Mostrar Contactos");
            System.out.println("3. Eliminar Contacto");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    contactos.add(nombre);
                    break;
                case 2:
                    System.out.println("Contactos: " + contactos);
                    break;
                case 3:
                    System.out.print("Nombre del contacto a eliminar: ");
                    String eliminar = scanner.nextLine();
                    contactos.remove(eliminar);
                    break;
                case 4:
                    System.out.println("Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}

