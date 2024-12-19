public class ProjLinkedList<T> {

    //fields
    private ProjNode<T> head;
    private int length;

    //constructor
    public ProjLinkedList() {
        this.head = null;
    }

    //methods
    public void add(T data) {
        ProjNode<T> newNode = new ProjNode<T>(data);
        newNode.setNext(head);
        this.head = newNode;
        length ++;
    }

    public ProjNode<T> getHead() {
        return head;
    }

    //get data at the index entered
    public T getAt(int input) {
        int index = input;
        int count = 0;
        ProjNode<T> currentNode = head;
        while (currentNode != null) {
            if (count == index) {
                return currentNode.getData();
            }
            count ++;
            currentNode = currentNode.getNext();
        }
        //wasn't found, return null
        return null;
    }

    //return length of linked list
    public int getLength() {
        return length;
    }
}