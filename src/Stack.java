/**
 * Generic interface that defines the behavior of a Stack (LIFO structure).
 * @param <T> Type of elements stored in the stack
 */
public interface Stack<T> {
    /**
     * Inserts an element at the top of the stack.
     * @param data Element to insert
     */
    public void push(T data);
    /**
     * Removes and returns the top element of the stack.
     * @return Top element
     * @throws IllegalArgumentException if the stack is empty
     */
    public T pop();
    /**
     * Returns the top element without removing it.
     * @return Top element
     * @throws IllegalArgumentException if the stack is empty
     */
    public T peek();
    /**
     * Checks whether the stack is empty.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty();
    /**
     * Removes all elements from the stack.
     */
    public void clear();
}
