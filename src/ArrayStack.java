import java.util.ArrayList;
public class ArrayStack<T> implements IStack<T>{
    private ArrayList<T> items = new ArrayList<>();

    @Override
    public void push(T data){
        items.add(data);
    }

    @Override
    public T pop() {
        return items.removeLast();
    }

    @Override
    public boolean empty() {
        return items.isEmpty();
    }

    @Override
    public T top() {
        return items.getLast();
    }
}
