import java.util.ArrayList;
public class ArrayStack<T> implements IStack<T>{
    private ArrayList<T> items = new ArrayList<>();

    @Override
    public void push(T data){
        items.add(data);
    }

    @Override
    public T pop() {
        if (empty()){
            throw new IllegalArgumentException("Stack is empty. Can't remove any data.");
        }
        return items.removeLast();
    }

    @Override
    public boolean empty() {
        return items.isEmpty();
    }

    @Override
    public T top() {
        if (empty()){
            throw new IllegalArgumentException("Stack is empty. Can't retrieve any data.");
        }
        return items.getLast();
    }
}
