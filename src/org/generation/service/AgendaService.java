package org.generation.service;

import org.generation.model.Contacto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AgendaService {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    // Constructor con tamaño personalizado
    public AgendaService(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    // Constructor con tamaño por defecto (10)
    public AgendaService() {
        this(10);
    }

    // Añadir un contacto
    public boolean añadirContacto(Contacto nuevo) {
        // Validar campos no vacíos
        if (nuevo.getNombre().isEmpty() || nuevo.getApellido().isEmpty()) {
            System.out.println("Error: Nombre y apellido no pueden estar vacíos");
            return false;
        }

        // Verificar si ya existe
        if (existeContacto(nuevo)) {
            System.out.println("Error: Ya existe un contacto con ese nombre y apellido");
            return false;
        }

        // Verificar si hay espacio
        if (agendaLlena()) {
            System.out.println("Error: La agenda está llena");
            return false;
        }

        contactos.add(nuevo);
        return true;
    }

    // Verificar si existe un contacto
    public boolean existeContacto(Contacto buscado) {
        return contactos.stream().anyMatch(c -> c.equals(buscado));
    }

    // Listar contactos ordenados
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía");
            return;
        }

        // Ordenar por nombre y apellido
        contactos.sort(Comparator.comparing(Contacto::getNombre)
                .thenComparing(Contacto::getApellido));

        System.out.println("--- LISTA DE CONTACTOS ---");
        contactos.forEach(System.out::println);
    }

    // Buscar contacto por nombre y apellido
    public void buscarContacto(String nombre, String apellido) {
        Contacto buscado = new Contacto(nombre, apellido, "");
        boolean encontrado = false;

        for (Contacto c : contactos) {
            if (c.equals(buscado)) {
                System.out.println("Teléfono encontrado: " + c.getTelefono());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado");
        }
    }

    // Eliminar contacto
    public boolean eliminarContacto(Contacto aEliminar) {
        boolean eliminado = contactos.removeIf(c -> c.equals(aEliminar));

        if (eliminado) {
            System.out.println("Contacto eliminado correctamente");
        } else {
            System.out.println("No se encontró el contacto a eliminar");
        }

        return eliminado;
    }

    // Modificar teléfono
    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Contacto buscado = new Contacto(nombre, apellido, "");

        for (Contacto c : contactos) {
            if (c.equals(buscado)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado correctamente");
                return true;
            }
        }

        System.out.println("No se encontró el contacto para modificar");
        return false;
    }

    // Verificar si la agenda está llena
    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    // Mostrar espacios libres
    public int espaciosLibres() {
        return capacidadMaxima - contactos.size();
    }
}
