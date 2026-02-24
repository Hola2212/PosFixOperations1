import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NodeLinkedListTest {

    @Test
    void nodeStoresDataAndNext() {
        NodeLinkedList<Integer> node = new NodeLinkedList<>(10);
        NodeLinkedList<Integer> next = new NodeLinkedList<>(20);

        node.setNext(next);

        assertEquals(10, node.getData());
        assertEquals(next, node.getNext());
    }
}