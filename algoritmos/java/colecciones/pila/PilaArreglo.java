package colecciones.pila;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Pila}.
* @see colecciones.pila.Pila
*/
public class PilaArreglo<T> implements Pila<T> {

    /**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

    /**
	* Construye una nueva pila vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public PilaArreglo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva pila vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la pila
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public PilaArreglo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

    /**
	* Construye una pila a partir de elementos en una colección.
	* Los elementos en la colección se apilan de izquierda a derecha.
	* La capacidad de la pila va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la pila
	*/
	public PilaArreglo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			apilar(e);	
		}
	}
    
    @Override
    public boolean esVacia(){
        return (elementos == 0);
    }

    @Override
    public boolean apilar(T elem){
        if (this.elementos == arreglo.length)
            throw new StackOverflowError("Pila llena");
        arreglo[elementos] = elem;
        elementos++;
        return true;
    }

    @Override 
    @SuppressWarnings("unchecked")
    public T desapilar(){
        if (esVacia())
            throw new IllegalStateException("La pila está vacía");
        elementos--;
        return (T) arreglo[elementos];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T tope(){
        return (T) arreglo[elementos-1];
    }

    @Override
    public void vaciar(){
        elementos = 0;
    }

    @Override
    public int elementos(){
        return elementos;
    }

    public boolean repOK(){
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
    public String toString(){
        String cadena = new String();
        for (int i = 0; i < elementos; i++){
            cadena = cadena + (arreglo[i]) + "\n";
        }
        return cadena;
    }

    @Override
    @SuppressWarnings("unchecked")
	public boolean equals(Object other){
        //Si es el mism objeto, retorno true
        if (other == this) return true;
        //Si el objeto es nullo, retorno false
        if (other == null) return false;
        //Si son objetos de diferentes clases, retorno false
        if (other.getClass() != this.getClass()) return false;

        PilaArreglo<T> otherPila = (PilaArreglo<T>) other;

        //Si tienen diferente cantidad de elementos, retorno false
        if (this.elementos() != otherPila.elementos()) return false;

        //Si tienen los mismos elementos, retorno true
        for (int i = 0; i < this.elementos(); i++){
            if (!(otherPila.arreglo[i]).equals(this.arreglo[i])) return false;
        } 
        return true;
    }

}
