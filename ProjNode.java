public class ProjNode<T> {
    
    //fields
    private T data;         //data held by the node
    ProjNode<T> next;       //reference to next node

    //constructor
    public ProjNode(T data) {
        this.data = data;
        this.next = null;   //initially, next is null
    }

    //methods
    public void setNext(ProjNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public ProjNode<T> getNext() {
        return next;
    }
}