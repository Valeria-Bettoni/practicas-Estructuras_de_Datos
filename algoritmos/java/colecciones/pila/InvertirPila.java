package colecciones.pila;

public class InvertirPila {
    public static void main(String[] args){

        Pila<Integer> numeros = new PilaArreglo<Integer>(6);
        numeros.apilar(3);
        numeros.apilar(6);
        numeros.apilar(9);
        numeros.apilar(12);
        numeros.apilar(15);
        numeros.apilar(18);
        System.out.println(numeros.toString());

        while (!numeros.esVacia()) {
            int num = numeros.desapilar();
            System.out.println(num);
        }

    }
}
/*
 * C:\Users\valeb\OneDrive\Documentos\Materias Universidad\Estructuras de datos y algoritmos\Practicas\practicas-Estructuras_de_Datos\algoritmos\java> java -cp . colecciones.pila.InvertirPila
 */
