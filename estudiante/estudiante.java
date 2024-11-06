package estudiante;

public class estudiante {
    
    import java.util.ArrayList;
    import java.util.List;
    
    class Estudiante {
        String nombre;
        int edad;
        String matricula;
    
        public Estudiante(String nombre, int edad, String matricula) {
            this.nombre = nombre;
            this.edad = edad;
            this.matricula = matricula;
        }
    
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
        }
    
        public Estudiante buscarEstudiante(String nombre) {
            for (Estudiante e : estudiantes) {
                if (e.nombre.equals(nombre)) {
                    return e;
                }
            }
            return null;
        }
    
        public boolean eliminarEstudiante(String nombre) {
            for (Estudiante e : estudiantes) {
                if (e.nombre.equals(nombre)) {
                    estudiantes.remove(e);
                    return true;
                }
            }
            return false;
        }
    
        public boolean actualizarEstudiante(String matricula, String nuevoNombre, int nuevaEdad) {
            for (Estudiante e : estudiantes) {
                if (e.matricula.equals(matricula)) {
                    e.nombre = nuevoNombre;
                    e.edad = nuevaEdad;
                    return true;
                }
            }
            return false;
        }
    
        public void ordenarEstudiantesPorNombre() {
            estudiantes.sort((e1, e2) -> e1.nombre.compareTo(e2.nombre));
        }
    
        public void mostrarEstudiantes() {
            for (Estudiante e : estudiantes) {
                System.out.println(e);
            }
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Curso curso = new Curso("CS101", "Introducción a la Programación");
    
            Estudiante est1 = new Estudiante("Ana", 18, "A001");
            Estudiante est2 = new Estudiante("Luis", 19, "A002");
            
            curso.agregarEstudiante(est1);
            curso.agregarEstudiante(est2);
    
            System.out.println("Lista de estudiantes:");
            curso.mostrarEstudiantes();
    
            System.out.println("\nBuscando a 'Ana':");
            Estudiante encontrado = curso.buscarEstudiante("Ana");
            if (encontrado != null) {
                System.out.println("Encontrado: " + encontrado);
            } else {
                System.out.println("Estudiante no encontrado");
            }
    
            System.out.println("\nActualizando a 'Ana':");
            curso.actualizarEstudiante("A001", "Ana María", 19);
            curso.mostrarEstudiantes();
    
            System.out.println("\nEliminando a 'Luis':");
            boolean eliminado = curso.eliminarEstudiante("Luis");
            if (eliminado) {
                System.out.println("Estudiante eliminado.");
            } else {
                System.out.println("Estudiante no encontrado.");
            }
    
            System.out.println("\nOrdenando estudiantes por nombre:");
            curso.ordenarEstudiantesPorNombre();
            curso.mostrarEstudiantes();
        }
    }
    
}