package colecciones.pila;

/**
* La clase {@code MainPila} implementa una aplicación simple para mostrar el uso de {@code Pila}.
* @see colecciones.pila
* @version 1.0
*/

public class Main {
    
    public static void main(String[] args){
        Pila<Integer> numeros = new PilaArreglo<Integer>(6);
        numeros.apilar(3);
        numeros.apilar(6);
        numeros.apilar(9);
        numeros.apilar(12);
        numeros.apilar(15);
        numeros.apilar(18);
        System.out.println(numeros.toString());
    }
}

/*
 * El comando java -cp . colecciones.pila.Main se utiliza para ejecutar el archivo Main de tu programa Java ubicado en el paquete colecciones.pila, utilizando la clase Pila y PilaArreglo.
El argumento -cp . indica que se debe utilizar el directorio actual como classpath, es decir, la ruta donde se encuentran los archivos compilados .class de las clases que necesitan ser cargadas por la JVM. De esta manera, se le indica al comando java que busque las clases necesarias en el directorio actual.
Luego, colecciones.pila.Main es la clase principal que se debe ejecutar, y es la que contiene el método main() que hace el llamado a los métodos de las otras clases.
En resumen, el comando java -cp . colecciones.pila.Main se utiliza para ejecutar un programa Java que está organizado en paquetes y utiliza varias clases compiladas, y se asegura de que se carguen correctamente en la JVM.
 */
