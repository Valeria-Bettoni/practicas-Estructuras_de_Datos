package colecciones.pila;

public class NodoPila {
    private Object item;
    private NodoPila next;

    /**
    * Construye un nuevo item con valores por defecto, null.
    */
    public NodoPila(){
        item = null;
        next = null;
    }

    /*
    * Construye un nuevo nodo con un object y un next
    * @param item el nuevo item del nodo
    * @param next el nuevo next del nodo 
    */
    public NodoPila(Object item, NodoPila next) {
        this.item = item;
        this.next = next;
    }

    /*
    * Un getter para el item
    * @return el item asociado a la pila
    */
    public Object getItem() {
        return item;
    }

    /*
    * Un getter para el next
    * @return el sucesor del nodo
    */
    public NodoPila getNext() {
        return this.next;
    }

    /*
    * Un setter para el item
    * @param item el item a ser agregado al nodo
    */
    public void setItem(Object item){
        this.item = item;
    }

    /*
    * Un setter para el next
    * @param next el siguiente del nodo
    */
    public void setNext(NodoPila next){
        this.next = next;
    }
}
