import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListStackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new DoubleLinkedListStack<>();
    }

    @Test
    void lifoWorks() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
}