import java.util.ArrayList;
/**
 * @param <T> Generic class for a Stack Using Double Linked List
 */
public class DoubleLinkedListStack<T> implements Stack<T> {
    private NodeDoubleLinkedList<T> top = null;

    /**
     * @param data
     */
    @Override
    public void push(T data) {
        NodeDoubleLinkedList<T> newNode = new NodeDoubleLinkedList<>(data);
        if (top != null) {
            newNode.setPrevious(null);
            newNode.setNext(top);
            top.setPrevious(newNode);
        }
        top = newNode;
    }
    /**
     * @return last inserted item and delete it from stack
     * @throws IllegalArgumentException if stack is empty
     */
    @Override
    public T pop() {
        if (top == null) {
            throw new IllegalArgumentException("Stack is empty.");
        }
        T data = top.getData();
        top = top.getNext();

        if (top != null) {
            top.setPrevious(null);
        }
        return data;
    }

    /**
     * @return last inserted item
     * @throws IllegalArgumentException if stack is empty
     */
    @Override
    public T peek() {
        if (this.top == null){
            throw new IllegalArgumentException("Stack is empty. Can't retrieve any data.");
        }
        return top.getData();
    }
}
