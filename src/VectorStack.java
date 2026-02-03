import java.util.Vector;
public class VectorStack<T> implements Stack<T>{
    private Vector<T> items = new Vector<>();

    @Override
    public void push(T data){
        items.add(data);
    }

    @Override
    public T pop() {
        if (items.isEmpty()){
            throw new IllegalArgumentException("Stack is empty. Can't remove any data.");
        }
        return items.removeLast();
    }

    @Override
    public T peek() {
        if (items.isEmpty()){
            throw new IllegalArgumentException("Stack is empty. Can't retrieve any data.");
        }
        return items.getLast();
    }
}
