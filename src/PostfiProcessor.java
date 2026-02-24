/**
 * Postif Operations Calculator class
 */
public class PostfiProcessor implements Calc {
    private static PostfiProcessor instance;
    private Stack<Float> stack;

    private PostfiProcessor() {
        stack = StackFactory.createStack(StackType.VECTOR); // default
    }

    public static PostfiProcessor getInstance() {
        if (instance == null) {
            instance = new PostfiProcessor();
        }
        return instance;
    }

    public void setStackType(StackType type){
        stack = StackFactory.createStack(type);
    }
    /**
     * @param text
     * @return result of the expression
     * @throws IndexOutOfBoundsException when the signs are badly placed, ending in not enough data to operate
     */
    @Override
    public float Operate(String text) {
        String[] tokens = text.split(" ");
        for (String token : tokens) {

            switch (token) {
                case "+" -> {
                    float a = stack.pop();
                    float b = stack.pop();
                    stack.push(b + a);
                }
                case "-" -> {
                    float a = stack.pop();
                    float b = stack.pop();
                    stack.push(b - a);
                }
                case "*" -> {
                    float a = stack.pop();
                    float b = stack.pop();
                    stack.push(b * a);
                }
                case "/" -> {
                    float a = stack.pop();
                    float b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Float.parseFloat(token));
            }
        }
        return stack.pop();
    }
}

