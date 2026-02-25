/**
 * Interface representing a postfix expression calculator.
 */
public interface Calc {
    /**
     * Evaluates a postfix expression.
     * @param input Postfix expression as a String
     * @return Result of the evaluated expression
     * @throws ArithmeticException if division by zero occurs
     * @throws IllegalStateException if the expression is invalid
     */
    public float Operate(String input);
}
