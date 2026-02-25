/**
 * Factory class responsible for creating different Stack implementations
 * based on the selected StackType.
 */
public class StackFactory {
    /**
     * Creates a Stack implementation based on the given type.
     * @param <T>  Generic type of the stack
     * @param type Type of stack implementation to create
     * @return A concrete Stack implementation
     */
    public static <T> Stack<T> createStack(StackType type) {

        return switch (type) {
            case ARRAY -> new ArrayStack<>();
            case VECTOR -> new VectorStack<>();
            case LINKED_LIST -> new LinkedListStack<>();
            case DOUBLY_LINKED_LIST -> new DoubleLinkedListStack<>();
        };
    }
}