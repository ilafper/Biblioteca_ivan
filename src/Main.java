import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Usuario usuario1 = new Usuario("Juan", "Perez", "123456789", "juan@example.com");
        Usuario usuario2 = new Usuario("Maria", "Gomez", "987654321", "maria@example.com");

        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);

        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "9788497593695",true);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "9786077350407",true);
        Libro libro3 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "9788478884453",true);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        int opcion;
        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su nombre: ");
                    String nombre1=scanner.nextLine();
                    System.out.println("Ingrese su contraseña:");
                    String contrasena=scanner.nextLine();
                    for (Usuario usuario : biblioteca.usuarios){
                        if (usuario.getNombre().equals(nombre1)){
                            if (usuario.getTelefono().equals(contrasena)){
                                System.out.println("Bienvenido/a"+ usuario.getNombre());
                                Scanner scanner2 = new Scanner(System.in);
                                int menu2;
                                do {
                                    System.out.println("\nMenú:");
                                    System.out.println("1. Mostrar datos usuario");
                                    System.out.println("2. Ver libros disponibles");
                                    System.out.println("3. Ver libros pendientes de devolver por usuario");
                                    System.out.println("4. Pedir un libro");
                                    System.out.println("5. Devolver un libro");
                                    System.out.println("0. Salir");
                                    System.out.print("Ingrese su opción: ");

                                    menu2 = scanner2.nextInt();

                                    switch (menu2) {
                                        case 1:
                                            System.out.print(usuario.toString());
                                            break;
                                        case 2:
                                           biblioteca.mostrarLibrosDisponibles();
                                            break;
                                        case 3:
                                            System.out.print("Ingrese el nombre del usuario: ");
                                            String nombreUsuario1 = scanner.nextLine();
                                            for (Usuario usuario3 : biblioteca.usuarios) {
                                                if (usuario3.getNombre().equals(nombreUsuario1)) {
                                                    usuario3.mostrarLibrosPendientes();
                                                    break;
                                                }
                                            }
                                            break;
                                        case 4:
                                            System.out.print("Ingrese el nombre del usuario: ");
                                            String nombreUsuario2 = scanner.nextLine();
                                            System.out.print("Ingrese el título del libro: ");
                                            String tituloLibro1 = scanner.nextLine();
                                            for (Usuario usuario4 : biblioteca.usuarios) {
                                                if (usuario.getNombre().equals(nombreUsuario2)) {
                                                    for (Libro libro : biblioteca.libros) {
                                                        if (libro.toString().equals(tituloLibro1)) {
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
                                            String nombreUsuario5 = scanner.nextLine();
                                            System.out.print("Ingrese el título del libro: ");
                                            String tituloLibro2 = scanner.nextLine();
                                            for (Usuario usuario5 : biblioteca.usuarios) {
                                                if (usuario.getNombre().equals(nombreUsuario5)) {
                                                    for (Libro libro : usuario.getLibrosPendientes()) {
                                                        if (libro.toString().equals(tituloLibro2)) {
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
                                } while (menu2 != 0);
                                scanner2.close();

                            }else {
                                System.out.println("Usuario  o contrasenha incorrecta");
                            }

                        }

                    }
                    break;
                case 2:
                    System.out.print("Ingrese un nuevo nombre:");
                    String nuevo_nombre = scanner.nextLine();
                    System.out.println("Ingrese un nuevo apellido:");
                    String nuevo_apellido=scanner.nextLine();
                    System.out.println("Ingrese un nuevo telefono:");
                    String nuevo_telefono=scanner.nextLine();
                    System.out.println("Ingrese un nuevo correo:");
                    String nuevo_email=scanner.nextLine();

                    Usuario nuevo_usuario= new Usuario(nuevo_nombre, nuevo_apellido, nuevo_telefono, nuevo_email);
                    biblioteca.agregarUsuario(nuevo_usuario);
                    System.out.print(nuevo_usuario.toString());

                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
        scanner.close();

    }
}
