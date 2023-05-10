package ejercicio1;
/* Compila y ejecuta con:
* javac ejercicio1/Libro.java
* javac ejercicio1/Main.java
* java ejercicio1.Main
*/

public class Main {
    
    public static void main(String args[]) {

        Libro l1 = new Libro();
        l1.asignarTitulo("Harry Potter");
        l1.asignarAutor("J. K. Rowling");
        l1.asignarNroPag(600); 
        System.out.println(l1.toString());

        Libro l2 = new Libro("The Lord of the Rings", "J. R. R. Tolkien", 1000);
        System.out.println(l2.toString());
       
        // TODO: Crear un libro nuevo y mostrarlo.
        Libro l3 = new Libro("El corazón de la piedra", "J. M. G. López", 560);
        System.out.println(l3.toString());

        Libro l4 = new Libro("Los días de la revolución", "Eduardo Sacheri", 630);
        System.out.println(l4.toString());

        Libro l5 = new Libro("¿Hola? Un réquiem para el teléfono", "Martín Kohan", 400);
        System.out.println(l5.toString());

        Libro l6 = new Libro("El tercer paraíso", "Cristian Alarcón", 350);
        System.out.println(l6.toString());

        Libro l7 = new Libro("El tiempo de las moscas", "Claudia Piñeiro", 560);
        System.out.println(l7.toString());
    }

}
