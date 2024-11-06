import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Estudiante {
    String nombre;
    int edad;
    String matricula;

    public Estudiante(String nombre, int edad, String matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Matrícula: " + matricula;
    }
}

class Curso {
    String codigo;
    String nombre;
    List<Estudiante> estudiantes;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        System.out.println("Estudiante agregado: " + estudiante);
    }

    public Estudiante buscarEstudiante(String nombreOMatricula) {
        for (Estudiante e : estudiantes) {
            if (e.nombre.equals(nombreOMatricula) || e.matricula.equals(nombreOMatricula)) {
                return e;
            }
        }
        return null;
    }

    public boolean eliminarEstudiante(String nombreOMatricula) {
        boolean eliminado = estudiantes.removeIf(e -> e.nombre.equals(nombreOMatricula) || e.matricula.equals(nombreOMatricula));
        if (eliminado) {
            System.out.println("Estudiante eliminado: " + nombreOMatricula);
        } else {
            System.out.println("Estudiante no encontrado para eliminar.");
        }
        return eliminado;
    }

    public boolean actualizarEstudiante(String matricula, String nuevoNombre, int nuevaEdad) {
        for (Estudiante e : estudiantes) {
            if (e.matricula.equals(matricula)) {
                e.nombre = nuevoNombre;
                e.edad = nuevaEdad;
                System.out.println("Estudiante actualizado: " + e);
                return true;
            }
        }
        System.out.println("Estudiante no encontrado para actualizar.");
        return false;
    }

    public void ordenarEstudiantesPorNombre() {
        estudiantes.sort((e1, e2) -> e1.nombre.compareTo(e2.nombre));
    }

    public void mostrarEstudiantes() {
        System.out.println("Lista de estudiantes en el curso:");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Curso curso = new Curso("CS101", "Introducción a la Programación");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Actualizar estudiante");
            System.out.println("5. Ordenar estudiantes por nombre");
            System.out.println("6. Mostrar todos los estudiantes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del estudiante:");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese la edad del estudiante:");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese la matrícula del estudiante:");
                    String matricula = scanner.nextLine();

                    curso.agregarEstudiante(new Estudiante(nombre, edad, matricula));
                    break;

                case 2:
                    System.out.println("Ingrese el nombre o matrícula del estudiante a buscar:");
                    String busqueda = scanner.nextLine();
                    Estudiante encontrado = curso.buscarEstudiante(busqueda);
                    if (encontrado != null) {
                        System.out.println("Estudiante encontrado: " + encontrado);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el nombre o matrícula del estudiante a eliminar:");
                    String eliminar = scanner.nextLine();
                    curso.eliminarEstudiante(eliminar);
                    break;

                case 4:
                    System.out.println("Ingrese la matrícula del estudiante a actualizar:");
                    String matriculaActual = scanner.nextLine();

                    System.out.println("Ingrese el nuevo nombre del estudiante:");
                    String nuevoNombre = scanner.nextLine();

                    System.out.println("Ingrese la nueva edad del estudiante:");
                    int nuevaEdad = scanner.nextInt();
                    scanner.nextLine();

                    curso.actualizarEstudiante(matriculaActual, nuevoNombre, nuevaEdad);
                    break;

                case 5:
                    curso.ordenarEstudiantesPorNombre();
                    System.out.println("Estudiantes ordenados por nombre.");
                    break;

                case 6:
                    curso.mostrarEstudiantes();
                    break;

                case 7:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
