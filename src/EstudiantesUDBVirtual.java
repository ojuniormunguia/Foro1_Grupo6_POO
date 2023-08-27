import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EstudiantesUDBVirtual {

    public static void main(String[] args) {
        List<Map<String, String>> estudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Mostrar todos los alumnos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    ingresarAlumno(estudiantes, scanner);
                    break;
                case 2:
                    buscarAlumno(estudiantes, scanner);
                    break;
                case 3:
                    eliminarAlumno(estudiantes, scanner);
                    break;
                case 4:
                    mostrarAlumnos(estudiantes);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void ingresarAlumno(List<Map<String, String>> estudiantes, Scanner scanner) {
        Map<String, String> alumno = new HashMap<>();
        System.out.print("Ingrese el carnet del alumno: ");
        String carnet = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del alumno: ");
        String nombre = scanner.nextLine();
        alumno.put("carnet", carnet);
        alumno.put("nombre", nombre);
        estudiantes.add(alumno);
        System.out.println("Alumno ingresado exitosamente");
    }

    public static void buscarAlumno(List<Map<String, String>> estudiantes, Scanner scanner) {
        System.out.print("Ingrese el carnet del alumno a buscar: ");
        String carnet = scanner.nextLine();
        for (Map<String, String> alumno : estudiantes) {
            if (alumno.get("carnet").equals(carnet)) {
                System.out.println("Alumno encontrado:");
                System.out.println("Carnet: " + alumno.get("carnet"));
                System.out.println("Nombre: " + alumno.get("nombre"));
                return;
            }
        }
        System.out.println("Alumno no encontrado, no se puede Mostrar");
    }

    public static void eliminarAlumno(List<Map<String, String>> estudiantes, Scanner scanner) {
        System.out.print("Ingrese el carnet del alumno a eliminar: ");
        String carnet = scanner.nextLine();
        for (Map<String, String> alumno : estudiantes) {
            if (alumno.get("carnet").equals(carnet)) {
                estudiantes.remove(alumno);
                System.out.println("Alumno eliminado exitosamente");
                return;
            }
        }
        System.out.println("Alumno no encontrado, no se puede Eliminar");
    }

    public static void mostrarAlumnos(List<Map<String, String>> estudiantes) {
        System.out.println("Lista de alumnos:");
        for (Map<String, String> alumno : estudiantes) {
            System.out.println("Carnet: " + alumno.get("carnet"));
            System.out.println("Nombre: " + alumno.get("nombre"));
            System.out.println("----------------------");
        }
    }
}