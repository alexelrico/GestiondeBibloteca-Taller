import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private Map<String, Libro> inventario;
    private Map<String, Usuario> usuarios;
    private Map<String, Prestamo> prestamos;

    public Biblioteca() {
        this.inventario = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.prestamos = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        if (!inventario.containsKey(libro.getTitulo())) {
            inventario.put(libro.getTitulo(), libro);
            System.out.println("Libro agregado correctamente.");
        } else {
            System.out.println("El libro ya existe en el inventario.");
        }
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        return inventario.get(titulo);
    }

    public Libro buscarLibroPorAutor(String autor) {
        for (Libro libro : inventario.values()) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Libro libro : inventario.values()) {
            System.out.println(libro);
        }
    }

    public void realizarPrestamo(String tituloLibro, String nombreUsuario) {
        if (inventario.containsKey(tituloLibro)) {
            Libro libro = inventario.get(tituloLibro);
            if (!libro.isPrestado()) {
                LocalDate fechaPrestamo = LocalDate.now();
                LocalDate fechaDevolucion = fechaPrestamo.plusWeeks(2); // Se devuelve en 2 semanas
                Prestamo nuevoPrestamo = new Prestamo(tituloLibro, nombreUsuario, fechaPrestamo, fechaDevolucion);
                prestamos.put(tituloLibro, nuevoPrestamo);
                libro.setPrestado(true);
                System.out.println("Préstamo realizado correctamente.");
            } else {
                System.out.println("El libro ya está prestado.");
            }
        } else {
            System.out.println("Libro no encontrado en el inventario.");
        }
    }

    public void devolverLibro(String tituloLibro) {
        if (prestamos.containsKey(tituloLibro)) {
            Prestamo prestamo = prestamos.get(tituloLibro);
            Libro libro = inventario.get(tituloLibro);
            libro.setPrestado(false);
            prestamos.remove(tituloLibro);
            System.out.println("Libro devuelto correctamente:");
            System.out.println("  Título: " + libro.getTitulo());
            System.out.println("  Fecha de préstamo: " + prestamo.getFechaPrestamo());
            System.out.println("  Fecha de devolución: " + prestamo.getFechaDevolucion());
        } else {
            System.out.println("No hay registro de préstamo para este libro.");
        }
    }
    

    public void calcularMultas() {
        // Supongamos que la multa es de $1 por día de retraso
        double multaTotal = 0;
        LocalDate hoy = LocalDate.now();
        for (Prestamo prestamo : prestamos.values()) {
            if (prestamo.getFechaDevolucion().isBefore(hoy)) {
                long diasDeRetraso = prestamo.getFechaDevolucion().until(hoy).getDays();
                double multaPorLibro = diasDeRetraso * 1; // $1 por día de retraso
                System.out.println("Usuario: " + prestamo.getNombreUsuario() + ", Libro: " + prestamo.getTituloLibro() +
                        ", Días de retraso: " + diasDeRetraso + ", Multa: $" + multaPorLibro);
                multaTotal += multaPorLibro;
            }
        }
        System.out.println("Multa total: $" + multaTotal);
    }

    public void agregarUsuario(Usuario usuario) {
        if (!usuarios.containsKey(usuario.getNombre())) {
            usuarios.put(usuario.getNombre(), usuario);
            System.out.println("Usuario agregado correctamente.");
        } else {
            System.out.println("El usuario ya existe.");
        }
    }

    public Usuario buscarUsuario(String nombre) {
        return usuarios.get(nombre);
    }
}
