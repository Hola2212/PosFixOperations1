import org.junit.jupiter.api.BeforeAll;
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
    void EmptyStackTopShowsError() {
        assertThrows(IllegalArgumentException.class, ()->
                items.top());
    }

    @Test
    void PushAndTopWork() {
        items.push(4);
        assertEquals(4,items.top());
    }

    @Test
    void IsItEmpty() {
        assertTrue(items.empty());
        items.push(2);
        assertFalse(items.empty());
    }

    @Test
    void EmptyStackPopShowsError() {
        assertThrows(IllegalArgumentException.class, ()->
                items.pop());
    }

    @Test
    void pop() {
        items.push(4);
        items.push(3);
        Integer num = items.pop();
        assertEquals(3,num);
    }
}