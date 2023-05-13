package ejercicio3;
import ejercicio1.Libro;


public class Catalogo {
    
    private Libro[] libros;
    private int nroLibros;
    private final int DEFAULT_MAX = 50;

    public Catalogo() {
        libros = new Libro[DEFAULT_MAX];
        nroLibros = 0;
    }

    public Catalogo(int max) {
        libros = new Libro[max];
        nroLibros = 0;
    }

    // Si el catalogo no esta lleno inserta el libro al final del arreglo 
    public boolean agregarLibro(Libro l) {
    	// Insertar siempre en la ultima posicion del arreglo
        if (nroLibros < DEFAULT_MAX){
            libros[this.nroLibros] = l;
            nroLibros++;
            return true;
        }
        return false;
    }

    // Si hay un libro con titulo t en el catalogo lo retorna, sino devuelve null.
    public Libro buscarPorTitulo(String t) {
    	// recorrer libros hasta encontrar un libro con titulo t
        for (int i = 0; i< nroLibros; i++){
            if (libros[i].obtenerTitulo().equals(t)){
                return libros[i];
            }
        }
        return null; 
    }

    public void mostrar() {
        for (int i = 0; i<nroLibros; i++) 
            System.out.println("Libro " + i + ": " + libros[i].toString());
    }
}
