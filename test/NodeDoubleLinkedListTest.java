import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NodeDoubleLinkedListTest {

    @Test
    void nodeStoresPreviousAndNext() {
        NodeDoubleLinkedList<Integer> node = new NodeDoubleLinkedList<>(5);
        NodeDoubleLinkedList<Integer> next = new NodeDoubleLinkedList<>(10);

        node.setNext(next);
        next.setPrevious(node);

        assertEquals(next, node.getNext());
        assertEquals(node, next.getPrevious());
    }
}