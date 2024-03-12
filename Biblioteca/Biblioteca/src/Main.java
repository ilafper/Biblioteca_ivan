import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Usuario usuario1 = new Usuario("Juan", "Perez", "123456789", "juan@example.com");
        Usuario usuario2 = new Usuario("Maria", "Gomez", "987654321", "maria@example.com");

        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);

        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "9788497593695");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "9786077350407");
        Libro libro3 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "9788478884453");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar datos usuario");
            System.out.println("2. Ver libros disponibles");
            System.out.println("3. Ver libros pendientes de devolver por usuario");
            System.out.println("4. Pedir un libro");
            System.out.println("5. Devolver un libro");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.next();
                    for (Usuario usuario : biblioteca.usuarios) {
                        if (usuario.getNombre().equals(nombreUsuario)) {
                            System.out.println(usuario.toString());
                            break;
                        }
                    }
                    break;
                case 2:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario2 = scanner.nextLine();
                    for (Usuario usuario : biblioteca.usuarios) {
                        if (usuario.getNombre().equals(nombreUsuario2)) {
                            usuario.mostrarLibrosPendientes();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String UsuarioNombre = scanner.nextLine();
                    System.out.print("Ingrese el título del libro: ");
                    String tituloLibro = scanner.nextLine();
                    for (Usuario usuario : biblioteca.usuarios) {
                        if (usuario.getNombre().equals(UsuarioNombre)) {
                            for (Libro libro : biblioteca.libros) {
                                if (libro.toString().equals(tituloLibro)) {
                                    biblioteca.pedirLibro(usuario, libro);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del usuario: ");
                    nombreUsuario = scanner.next();
                    System.out.print("Ingrese el título del libro: ");
                    tituloLibro = scanner.next();
                    for (Usuario usuario : biblioteca.usuarios) {
                        if (usuario.getNombre().equals(nombreUsuario)) {
                            for (Libro libro : usuario.getLibrosPendientes()) {
                                if (libro.toString().equals(tituloLibro)) {
                                    usuario.devolverLibro(libro);
                                    libro.setDisponible(true);
                                    System.out.println(usuario + " ha devuelto " + libro);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 6:

                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}
