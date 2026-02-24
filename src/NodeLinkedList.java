/**
 * @param <T> Generic class for a Node used for the Linked List stack
 */
public class NodeLinkedList<T>{
    private T data;
    private NodeLinkedList<T> next;
    public NodeLinkedList(T value){
        this.data = value;
        this.next = null;
    }
    public T getData(){ return this.data; }
    public NodeLinkedList<T> getNext(){ return this.next; }
    public void setNext(NodeLinkedList<T> next){
        this.next = next;
    }

}
