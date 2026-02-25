/**
 * Converts infix expressions into postfix notation.
 *
 * Uses a Stack implementation to apply operator precedence
 * and correctly transform mathematical expressions.
 */
public class InfixProcessor {

    private Stack<String> stack;
    /**
     * Creates an InfixProcessor with a specific Stack implementation.
     *
     * @param type The StackType to be used internally
     */
    public InfixProcessor(StackType type) {
        this.stack = StackFactory.createStack(type);
    }
    /**
     * Changes the internal Stack implementation.
     *
     * @param type The new StackType to use
     */
    public void setStackType(StackType type){
        this.stack = StackFactory.createStack(type);
    }
    /**
     * Converts an infix expression into postfix notation.
     *
     * @param infix Expression written in infix format
     * @return Expression converted to postfix format
     */
    public String convert(String infix) {

        stack.clear();
        StringBuilder postfix = new StringBuilder();
        String[] tokens = infix.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                postfix.append(token).append(" ");      //Manejo de StringBuilder
            }
            // Si es "("
            else if (token.equals("(")) {
                stack.push(token);
            }
            // Si es ")"
            else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // eliminar "("
            }
            // Si es operador
            else {
                while (!stack.isEmpty() &&
                        precedence(token) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }
        // Vaciar pila
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }

    private boolean isNumber(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int precedence(String op) { //Nivel de jerarquía de los operandos. 
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
}