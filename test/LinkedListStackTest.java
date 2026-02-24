import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedListStack<>();
    }

    @Test
    void lifoWorksCorrectly() {
        stack.push(5);
        stack.push(10);

        assertEquals(10, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    void peekDoesNotRemove() {
        stack.push(99);

        assertEquals(99, stack.peek());
        assertEquals(99, stack.pop());
    }
}