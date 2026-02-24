import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorStackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new VectorStack<>();
    }

    @Test
    void lifoOrderMaintained() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void peekWorksCorrectly() {
        stack.push(50);
        assertEquals(50, stack.peek());
        assertEquals(50, stack.pop());
    }

    @Test
    void popEmptyThrows() {
        assertThrows(IllegalArgumentException.class, stack::pop);
    }

    @Test
    void peekEmptyThrows() {
        assertThrows(IllegalArgumentException.class, stack::peek);
    }
}