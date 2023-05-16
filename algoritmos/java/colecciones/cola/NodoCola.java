package colecciones.cola;

public class NodoCola {
    private Object item;
    private NodoCola next;

    /**
    * Construye un nuevo item con valores por defecto, null.
    */
    public NodoCola(){
        item = null;
        next = null;
    }

    /*
    * Construye un nuevo nodo con un object y un next
    * @param item el nuevo item del nodo
    * @param next el nuevo next del nodo 
    */
    public NodoCola(Object item, NodoCola next) {
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
    public NodoCola getNext() {
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
    public void setNext(NodoCola next){
        this.next = next;
    }
}

