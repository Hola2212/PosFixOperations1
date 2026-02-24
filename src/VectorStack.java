import java.util.Vector;

/**
 * @param <T> Generic class for a Stack Using Vector
 */
public class VectorStack<T> implements Stack<T>{
    private Vector<T> items = new Vector<>();

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
        return items.remove(items.size() - 1);
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
        return items.get(items.size() - 1);
    }
}
