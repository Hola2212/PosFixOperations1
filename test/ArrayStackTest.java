import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    private Stack<Integer> items;
    @BeforeEach
    void SetUp(){
        this.items = new ArrayStack<>();
    }

    @Test
    void pushAndPopMaintainsLifoOrder() {
        items.push(1);
        items.push(2);
        items.push(3);

        assertEquals(3, items.pop());
        assertEquals(2, items.pop());
        assertEquals(1, items.pop());
    }

    @Test
    void peekReturnsTopWithoutRemoving() {
        items.push(10);

        assertEquals(10, items.peek());
        assertEquals(10, items.peek()); // sigue ahí
        assertEquals(10, items.pop());
    }

    @Test
    void popOnEmptyThrowsException() {
        assertThrows(IllegalArgumentException.class, items::pop);
    }

    @Test
    void peekOnEmptyThrowsException() {
        assertThrows(IllegalArgumentException.class, items::peek);
    }

    @Test
    void stressTestPushPop() {
        for (int i = 0; i < 1000; i++) {
            items.push(i);
        }

        for (int i = 999; i >= 0; i--) {
            assertEquals(i, items.pop());
        }
    }
}