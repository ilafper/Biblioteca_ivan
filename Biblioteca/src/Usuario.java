import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private ArrayList<Libro> librosPendientes;

    public Usuario(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.librosPendientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Libro> getLibrosPendientes() {
        return librosPendientes;
    }

    public void setLibrosPendientes(ArrayList<Libro> librosPendientes) {
        this.librosPendientes = librosPendientes;
    }

    public void mostrarLibrosPendientes() {
        System.out.println("Libros pendientes de devolver por " + nombre + ":");
        for (Libro libro : librosPendientes) {
            System.out.println(libro.toString());
        }
    }
    public void agregarLibroPendiente(Libro libro) {
        librosPendientes.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosPendientes.remove(libro);
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                "\napellido='" + apellido + '\'' +
                "\ntelefono='" + telefono + '\'' +
                "\nemail='" + email + '\''
                ;
    }
}
