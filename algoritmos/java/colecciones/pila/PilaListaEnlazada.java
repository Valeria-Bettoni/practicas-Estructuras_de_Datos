package colecciones.pila;

/**
* Implementación basada en listas enlazadas de tamaño variable de la interfaz {@code Pila}.
* @see colecciones.pila.Pila
*/
public class PilaListaEnlazada<T> implements Pila<T> {

    NodoPila tope;
    int cantElem; // cantidad de elementos 

    /**
     * Construye una nueva pila vacía.
     */
    public PilaListaEnlazada() {
        tope = null;
        cantElem = 0;
    }

    @Override
    public boolean apilar(Object e) {
        NodoPila nodoTemp = new NodoPila(e, this.tope);
        this.tope = nodoTemp; 
        cantElem++;
        return true;
    }

    @Override
        public void vaciar() {
        this.tope = null;
        cantElem = 0;
    }

    @Override
    public boolean esVacia() {
        return (tope == null); 
    }

    @Override
    @SuppressWarnings("unchecked")
    public T tope() {
        return (T) tope.getItem();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T desapilar() {
        if (tope == null) // si pila vacia se tira la excepción
            throw new IllegalStateException("Desapilar sobre Pila Vacia");
        NodoPila desapilado = tope;
        tope = tope.getNext();
        cantElem--;;
        return (T) desapilado;
    }
    
    @Override
    public int elementos() {
        return cantElem;
    }

    public boolean repOK(){
        // Verificar si el tamaño de la pila es correcto
        int contador = 0;
        NodoPila current = tope;

        while (current != null){
            contador++;
            current = current.getNext();
        }

        if (contador == cantElem) return true;
        return false;
    }

}
