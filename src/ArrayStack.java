import java.util.ArrayList;

/**
 * @param <T> Generic class for a Stack Using ArrayList
 */
public class ArrayStack<T> implements Stack<T>{
    private ArrayList<T> items = new ArrayList<>();

    /**
     * @param data
     */
    @Override
    public void push(T data){
        items.add(data);
    }

    /**
     * @return last inserted item and delete it from stack
     * @throws IllegalArgumentException if stack is empty
     */
    @Override
    public T pop() {
        if (items.isEmpty()){
            throw new IllegalArgumentException("Stack is empty. Can't remove any data.");
        }
        return items.removeLast();
    }

    /**
     * @return last inserted item
     * @throws IllegalArgumentException if stack is empty
     */
    @Override
    public T peek() {
        if (items.isEmpty()){
            throw new IllegalArgumentException("Stack is empty. Can't retrieve any data.");
        }
        return items.getLast();
    }
}
