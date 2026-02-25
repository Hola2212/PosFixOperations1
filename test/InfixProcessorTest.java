import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixProcessorTest {

    private InfixProcessor processor;

    @BeforeEach
    void setUp() {
        // Puedes cambiar el tipo si quieres probar otro stack
        processor = new InfixProcessor(StackType.ARRAY);
    }

    @Test
    void testSimpleSum() {
        String result = processor.convert("2 + 3");
        assertEquals("2 3 +", result);
    }

    @Test
    void testPrecedenceMultiplication() {
        String result = processor.convert("2 + 3 * 4");
        assertEquals("2 3 4 * +", result);
    }

    @Test
    void testParentheses() {
        String result = processor.convert("( 2 + 3 ) * 4");
        assertEquals("2 3 + 4 *", result);
    }

    @Test
    void testComplexExpression() {
        String result = processor.convert("5 + 6 * 2 - 3");
        assertEquals("5 6 2 * + 3 -", result);
    }

    @Test
    void testDivision() {
        String result = processor.convert("8 / 4");
        assertEquals("8 4 /", result);
    }

    @Test
    void testSingleValue() {
        String result = processor.convert("7");
        assertEquals("7", result);
    }

    @Test
    void testDifferentStackImplementation() {
        InfixProcessor processorList = new InfixProcessor(StackType.LINKED_LIST);
        String result = processorList.convert("2 + 2");
        assertEquals("2 2 +", result);
    }
}