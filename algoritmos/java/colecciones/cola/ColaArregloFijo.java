package colecciones.cola;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	@Override
	public boolean esVacia() {
		return elementos == 0;	
	}

	@Override
	public int elementos() {
		return elementos;
	}

	@Override
	public boolean encolar(T elem) {
		if (elementos == arreglo.length)
			return false;	
		arreglo[elementos] = elem;
		elementos++;
		return true;	
	}

	@Override
	@SuppressWarnings("unchecked")
	public T desencolar() {
		if (elementos == 0)
			throw new IllegalStateException("Cola vacia");
		elementos--;
		return (T) arreglo[elementos];
	}

	@Override
	@SuppressWarnings("unchecked")
	public T primero() {
		if (esVacia())
			throw new IllegalStateException("Cola vacia");
		T primero = (T) arreglo[0];
		//Corro los elementos hacia adelante
		for (int i = 0; i<elementos-1; i++){
			arreglo[i] = arreglo[i+1];
		}
		return primero;
	}

	@Override
	public void vaciar() {
		elementos = 0;	
	}

	@Override
	public boolean repOK() {
		if (arreglo.length == 0) {
            return false;
        }
        if (elementos < 0 || elementos > CAPACIDAD_POR_DEFECTO) {
            return false;
        }
        for (int i = 0; i < elementos; i++) {
            if (arreglo[i] == null) {
                return false;
            }
        }
        return true;	
	}

	@Override
	public String toString() {
		String cadena = new String();
		cadena = "INICIO [";
        for (int i = 0; i < elementos-1; i++){
            cadena = cadena + (arreglo[i]) + ", ";
        }
		cadena = cadena + (arreglo[elementos-1]) + "] FIN";
        return cadena;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object other) {
		//Si es el mism objeto, retorno true
        if (other == this) return true;
        //Si el objeto es nullo, retorno false
        if (other == null) return false;
        //Si son objetos de diferentes clases, retorno false
        if (other.getClass() != this.getClass()) return false;

        ColaArregloFijo<T> otherCola = (ColaArregloFijo<T>) other;

        //Si tienen diferente cantidad de elementos, retorno false
        if (this.elementos() != otherCola.elementos()) return false;

        //Si tienen los mismos elementos, retorno true
        for (int i = 0; i < this.elementos(); i++){
            if (!(otherCola.arreglo[i]).equals(this.arreglo[i])) return false;
        } 
        return true;	
	}

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	private T elemento(int index) {
        	return (T) arreglo[index];
    	}

}
