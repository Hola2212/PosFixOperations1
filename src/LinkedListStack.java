import java.util.ArrayList;
/**
 * @param <T> Generic class for a Stack Using Linked List
 */
public class LinkedListStack<T> implements Stack<T> {
    private NodeLinkedList<T> top = null;

    /**
     * @param data
     */
    @Override
    public void push(T data){
        NodeLinkedList<T> newNode = new NodeLinkedList<>(data);
        newNode.setNext(top);
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
        return data;
    }

    /**
     * @return last inserted item
     * @throws IllegalArgumentException if stack is empty
     */
    @Override
    public T peek() {
        if (top == null) {
            throw new IllegalArgumentException("Stack is empty.");
        }

        return top.getData();
    }
}
