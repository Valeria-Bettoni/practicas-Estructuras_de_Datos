package ejercicio2;
/*
* Compilar y ejecutar con:
* javac ejercicio2/Libro.java
* javac ejercicio2/Main.java
* java ejercicio2.Main
*/

public class Main {
    
    public static void main(String args[]) {

        int i = 0, j = 0;
        // Comparacion de tipos basicos
        System.out.println("Iguales i y j: " + (i == j));

        Libro l1 = new Libro();
        l1.asignarTitulo("Harry Potter");
        l1.asignarAutor("J. K. Rowling");
        l1.asignarNroPag(600); 
        System.out.println(l1.toString());

        Libro l2 = new Libro("The Lord of the Rings", "J. R. R. Tolkien", 1000);
        System.out.println(l2.toString());
       
        Libro l3 = new Libro("The Lord of the Rings", "J. R. R. Tolkien", 1000);
        System.out.println(l3.toString());
        
        // Comparacion de objetos
        System.out.println("Iguales l1 y l2: " + l1.equals(l2));
        // l2 y l3 son iguales porque equals compara el valor de sus atributos
        System.out.println("Iguales l2 y l3: " + l2.equals(l3));
        // Cual es el significado del resultado a continuacion?
        // l2 y l3 son distintos porque == compara si son el mismo objeto
        System.out.println("Iguales l2 y l3: " + (l2 == l3));
        
        
    }

}
