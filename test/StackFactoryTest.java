import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackFactoryTest {

    @Test
    void createsArrayStack() {
        Stack<Integer> stack = StackFactory.createStack(StackType.ARRAY);
        assertTrue(stack instanceof ArrayStack);
    }

    @Test
    void createsLinkedListStack() {
        Stack<Integer> stack = StackFactory.createStack(StackType.LINKED_LIST);
        assertTrue(stack instanceof LinkedListStack);
    }
}