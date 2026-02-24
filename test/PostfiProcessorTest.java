import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfiProcessorTest {

    private PostfiProcessor calculator;

    @BeforeEach
    void setUp() {
        calculator = PostfiProcessor.getInstance();
        calculator.setStackType(StackType.ARRAY); // reset strategy before each test
    }

    // ---------------------------
    // Singleton behavior
    // ---------------------------

    @Test
    void singletonReturnsSameInstance() {
        PostfiProcessor c1 = PostfiProcessor.getInstance();
        PostfiProcessor c2 = PostfiProcessor.getInstance();

        assertSame(c1, c2);
    }

    // ---------------------------
    // Basic operations
    // ---------------------------

    @Test
    void additionWorks() {
        float result = calculator.Operate("3 4 +");
        assertEquals(7.0f, result);
    }

    @Test
    void subtractionWorks() {
        float result = calculator.Operate("10 3 -");
        assertEquals(7.0f, result);
    }

    @Test
    void multiplicationWorks() {
        float result = calculator.Operate("6 5 *");
        assertEquals(30.0f, result);
    }

    @Test
    void divisionWorks() {
        float result = calculator.Operate("8 2 /");
        assertEquals(4.0f, result);
    }

    // ---------------------------
    // Complex expression
    // ---------------------------

    @Test
    void complexExpressionWorks() {
        float result = calculator.Operate("5 1 2 + 4 * + 3 -");
        assertEquals(14.0f, result);
    }

    // ---------------------------
    // Strategy switching
    // ---------------------------

    @Test
    void changingStackTypeWorks() {
        calculator.setStackType(StackType.VECTOR);
        assertEquals(7.0f, calculator.Operate("3 4 +"));

        calculator.setStackType(StackType.LINKED_LIST);
        assertEquals(6.0f, calculator.Operate("2 4 +"));

        calculator.setStackType(StackType.DOUBLY_LINKED_LIST);
        assertEquals(9.0f, calculator.Operate("4 5 +"));
    }

    // ---------------------------
    // Error cases
    // ---------------------------

    @Test
    void invalidExpressionThrowsException() {
        assertThrows(Exception.class,
                () -> calculator.Operate("5 +"));
    }

    @Test
    void illegalTokenThrowsException() {
        assertThrows(NumberFormatException.class,
                () -> calculator.Operate("2 3 &"));
    }

    @Test
    void stackIsCleanAfterException() {
        PostfiProcessor calc = PostfiProcessor.getInstance();
        calc.setStackType(StackType.ARRAY);

        // First call throws exception
        assertThrows(Exception.class,
                () -> calc.Operate("5 +"));

        // Second call should work normally (no leftover data)
        float result = calc.Operate("3 4 +");
        assertEquals(7.0f, result);
    }

    @Test
    void invalidExpressionWithExtraOperandsThrows() {
        PostfiProcessor calc = PostfiProcessor.getInstance();
        calc.setStackType(StackType.VECTOR);

        assertThrows(IllegalStateException.class,
                () -> calc.Operate("3 4 5 +"));
    }

    @Test
    void consecutiveOperationsAreIndependent() {
        PostfiProcessor calc = PostfiProcessor.getInstance();
        calc.setStackType(StackType.LINKED_LIST);

        float first = calc.Operate("2 3 +");
        float second = calc.Operate("4 5 +");

        assertEquals(5.0f, first);
        assertEquals(9.0f, second);
    }

    @Test
    void divisionByZeroThrowsException() {
        PostfiProcessor calc = PostfiProcessor.getInstance();
        calc.setStackType(StackType.ARRAY);

        assertThrows(ArithmeticException.class,
                () -> calc.Operate("5 0 /"));
    }
}