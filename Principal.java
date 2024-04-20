import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Agregar Nuevo Libro");
            System.out.println("2. Buscar Libro por Título");
            System.out.println("3. Buscar Libro por Autor");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Realizar Préstamo");
            System.out.println("6. Devolver Libro Prestado");
            System.out.println("7. Calcular Multas");
            System.out.println("8. Agregar Nuevo Usuario");
            System.out.println("9. Salir");
            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Agregar Nuevo Libro
                    System.out.print("Ingrese el título del libro: ");
                    String tituloLibro = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autorLibro = scanner.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbnLibro = scanner.nextLine();
                    System.out.print("Ingrese la editorial del libro: ");
                    String editorialLibro = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación del libro: ");
                    int anioPublicacionLibro = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el precio del libro: ");
                    double precioLibro = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    Libro nuevoLibro = new Libro(tituloLibro, autorLibro, isbnLibro, editorialLibro, anioPublicacionLibro, precioLibro);
                    biblioteca.agregarLibro(nuevoLibro);
                    break;
                case 2:
                    // Buscar Libro por Título
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    Libro libroEncontrado = biblioteca.buscarLibroPorTitulo(tituloBuscar);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println(libroEncontrado);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 3:
                    // Buscar Libro por Autor
                    System.out.print("Ingrese el autor del libro a buscar: ");
                    String autorBuscar = scanner.nextLine();
                    Libro libroAutor = biblioteca.buscarLibroPorAutor(autorBuscar);
                    if (libroAutor != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println(libroAutor);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    // Mostrar Inventario
                    biblioteca.mostrarInventario();
                    break;
                case 5:
                    // Realizar Préstamo
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestamo = scanner.nextLine();
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    biblioteca.realizarPrestamo(tituloPrestamo, nombreUsuario);
                    break;
                case 6:
                    // Devolver Libro Prestado
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    biblioteca.devolverLibro(tituloDevolucion);
                    break;
                case 7:
                    // Calcular Multas
                    biblioteca.calcularMultas();
                    break;
                case 8:
                    // Agregar Nuevo Usuario con multa
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuarioNuevo = scanner.nextLine();
                    System.out.print("Ingrese el DNI del usuario: ");
                    String dniUsuario = scanner.nextLine();
                    System.out.print("Ingrese la dirección del usuario: ");
                    String direccionUsuario = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del usuario: ");
                    String telefonoUsuario = scanner.nextLine();
                    System.out.print("Ingrese la multa del usuario: ");
                    double multaUsuario = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    Usuario nuevoUsuario = new Usuario(nombreUsuarioNuevo, dniUsuario, direccionUsuario, telefonoUsuario);
                    nuevoUsuario.setMulta(multaUsuario);
                    biblioteca.agregarUsuario(nuevoUsuario);
                    break;

                case 9:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
