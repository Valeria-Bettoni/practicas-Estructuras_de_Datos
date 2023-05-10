package ejercicio2;


public class Libro {

    private String titulo;
    private String autor;
    private int nroPag;

    public Libro() {
        titulo = null;
        autor = null;
        nroPag = 0;
    }

    public Libro(String t, String a, int p) {
        titulo = t;
        autor = a;
        nroPag = p;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public void asignarTitulo(String t) {
        titulo = t;
    }

    public String obtenerAutor() {
        return autor;
    }

    public void asignarAutor(String a) {
        autor = a;
    }

    public int obtenerNroPag() {
        return nroPag;
    }

    public void asignarNroPag(int n) {
        nroPag = n;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", Paginas: " + nroPag;
    }
    
    @Override
    public boolean equals(Object other) {
        //Si es el mism objeto, retorno true
        if (other == this) return true;
        //Si el objeto es nullo, retorno false
        if (other == null) return false;
        //Si son objetos de diferentes clases, retorno false
        if (other.getClass() != this.getClass()) return false;
        //Si tienen el mismo autor, mismo título y mismo número de páginas, retorno true.
    	return (this.obtenerAutor().equals(((Libro)other).obtenerAutor()) &&
    			this.obtenerTitulo().equals(((Libro)other).obtenerTitulo()) &&
    			this.obtenerNroPag() == ((Libro)other).obtenerNroPag());
    }

}
