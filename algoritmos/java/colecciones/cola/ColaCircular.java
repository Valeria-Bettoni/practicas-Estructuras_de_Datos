package colecciones.cola;

public class ColaCircular<T> implements Cola<T> {

    private NodoCola fin; // el final apunta al final de la cola, el siguiente apunta al comienzo de la cola
    private int numElems; // la cantidad de elementos de la cola

    /**
    * Un constructor Basico, incializa todo con valores por defecto
    */
    public ColaCircular(){
        fin = null;
        numElems = 0; 
    }
    
    @Override
    public boolean esVacia(){
        return (numElems == 0);
    }

    @Override
    public boolean encolar(Object item){
        //Nuevo nodo en la cola
        NodoCola nuevoNodo = new NodoCola(); 
        //Se setea el nuevo item
        nuevoNodo.setItem(item); 
        //Si la cola es vacia el siguiente del nodo es el mismo
        if (esVacia()){ 
            nuevoNodo.setNext(nuevoNodo);
            numElems++;
        }
        //Si no es vacia se agrega el nodo a la lista
        else{ 
            numElems++;
            //El siguiente del nuevo nodo apunta al comienzo de la cola
            nuevoNodo.setNext(fin.getNext()); 
            //El siguiente del final actual es el nuevo nodo
            fin.setNext(nuevoNodo); 
        }
        //El nuevo nodo es el nuevo fin
        fin = nuevoNodo; 
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T desencolar(){
        if (numElems == 0) // si la cola es vacia, se tira la excepcion correspondiente
            throw new IllegalStateException("Cola vacia");
        else{
            numElems--;
            T result = (T) fin.getNext().getItem(); // el item del primero de la cola
            fin.setNext(fin.getNext().getNext()); // el comienzo de la cola se cambia por el siguiente
            //Devuelvo el item desencolado
            return result;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T primero(){
        return (T) fin.getNext().getItem();
    }

    @Override
    public void vaciar(){
        numElems = 0;
        fin = null;
    }
   
    @Override
    public int elementos(){
        return numElems;
    }

    public boolean repOK(){
        //Verificar si el tamaño de la pila es correcto
        int contador = 0;
        NodoCola current = fin;

        while (current.getNext() != fin){
            contador++;
            current = current.getNext();
        }
        contador++;

        if (contador == numElems) return true;
        return false;
    }

	@Override
	public String toString(){
        //El primero de la cola
        NodoCola current = fin.getNext();
        String cadena = "[";
        while (current != fin){
            cadena = cadena + current.getItem() + ", " ;
        }
        cadena = cadena + current.getItem() + "]";
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

        ColaCircular<T> otherCola = (ColaCircular<T>) other;

        //Si tienen diferente cantidad de elementos, retorno false
        if (this.elementos() != otherCola.elementos()) return false;

        //Si tienen los mismos elementos, retorno true
        //Primero de la cola this
        NodoCola currentThis = this.fin.getNext();
        //Primero de la cola other
        NodoCola currentOther = otherCola.fin.getNext();
        //Comparo todos los elementos excepto el ultimo
        while (currentThis != this.fin){
            if (currentThis.getItem() != currentOther.getItem())
                return false;
            currentThis = currentThis.getNext();
            currentOther = currentOther.getNext();
        }
        //Comparo el ultimo elemento
        if (currentThis.getItem() != currentOther.getItem())
            return false;
        return true;    
    }

    
}
