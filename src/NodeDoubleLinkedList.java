/**
 * @param <T> Generic class for a Node used for the Linked List stack
 */
public class NodeDoubleLinkedList<T>{
    private T data;
    private NodeDoubleLinkedList<T> next;
    private NodeDoubleLinkedList<T> previous;
    public NodeDoubleLinkedList(T value){
        this.data = value;
        this.next = null;
        this.previous = null;
    }
    public T getData(){ return this.data; }
    public NodeDoubleLinkedList<T> getNext(){ return this.next; }
    public NodeDoubleLinkedList<T> getPrevious(){ return this.previous; }
    public void setNext(NodeDoubleLinkedList<T> next){
        this.next = next;
    }
    public void setPrevious(NodeDoubleLinkedList<T> previous){
        this.previous = previous;
    }
}
