public class StackFactory {

    public static <T> Stack<T> createStack(StackType type) {

        return switch (type) {
            case ARRAY -> new ArrayStack<>();
            case VECTOR -> new VectorStack<>();
            case LINKED_LIST -> new LinkedListStack<>();
            case DOUBLY_LINKED_LIST -> new DoubleLinkedListStack<>();
        };
    }
}