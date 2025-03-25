package org.generation.main;

import org.generation.model.Contacto;
import org.generation.service.AgendaService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaService agenda = crearAgenda(scanner);
        mostrarMenu(agenda, scanner);
    }

    private static AgendaService crearAgenda(Scanner scanner) {
        System.out.println("¿Desea crear una agenda con tamaño personalizado? (s/n)");
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("s")) {
            System.out.println("Ingrese el tamaño máximo de la agenda:");
            int tamaño = Integer.parseInt(scanner.nextLine());
            return new AgendaService(tamaño);
        } else {
            return new AgendaService();
        }
    }

    private static void mostrarMenu(AgendaService agenda, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ AGENDA ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Modificar teléfono");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Listar contactos");
            System.out.println("6. Verificar si agenda está llena");
            System.out.println("7. Mostrar espacios libres");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    añadirContacto(agenda, scanner);
                    break;
                case 2:
                    buscarContacto(agenda, scanner);
                    break;
                case 3:
                    modificarTelefono(agenda, scanner);
                    break;
                case 4:
                    eliminarContacto(agenda, scanner);
                    break;
                case 5:
                    agenda.listarContactos();
                    break;
                case 6:
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena" : "Hay espacio disponible");
                    break;
                case 7:
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void añadirContacto(AgendaService agenda, Scanner scanner) {
        System.out.println("\n--- AÑADIR CONTACTO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Contacto nuevo = new Contacto(nombre, apellido, telefono);
        agenda.añadirContacto(nuevo);
    }

    private static void buscarContacto(AgendaService agenda, Scanner scanner) {
        System.out.println("\n--- BUSCAR CONTACTO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        agenda.buscarContacto(nombre, apellido);
    }

    private static void modificarTelefono(AgendaService agenda, Scanner scanner) {
        System.out.println("\n--- MODIFICAR TELÉFONO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Nuevo teléfono: ");
        String telefono = scanner.nextLine();

        agenda.modificarTelefono(nombre, apellido, telefono);
    }

    private static void eliminarContacto(AgendaService agenda, Scanner scanner) {
        System.out.println("\n--- ELIMINAR CONTACTO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        Contacto aEliminar = new Contacto(nombre, apellido, "");
        agenda.eliminarContacto(aEliminar);
    }
}
