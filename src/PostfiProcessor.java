import java.util.Stack;

public class PostfiProcessor implements Calc{
    private String[] separados;
    private Stack<Float> numbersArray = new ArrayStack<>();
    private Stack<Float> numbersVector = new VectorStack<>();
    private Stack<Float> actual;
    private float result;
    public PostfiProcessor(){
        this.actual = this.numbersVector;
    }
     @Override
    public String operate(String text){
        this.separados = text.split(" ");
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < this.separados.length; i++){
            String actual = this.separados[i];
            switch (actual) {
                case "0","1","2","3","4","5","6","7","8","9":
                    actual.push(Float.parseFloat(actual));
                    break;
                case "+":
                    try {
                        num1 = actual.pop();
                        num2 = actual.pop();
                        this.result = num2 + num1;
                        actual.push(this.result);
                    } catch (Exception e) {
                        throw new IndexOutOfBoundsException("There aren't enough values to operate");
                    }
                    break;
                    case "-":
                    try {
                        num1 = actual.pop();
                        num2 = actual.pop();
                        this.result = num2 - num1;
                        actual.push(this.result);
                    } catch (Exception e) {
                        throw new IndexOutOfBoundsException("There aren't enough values to operate");
                    }
                    break;
                case "*":
                    try {
                        num1 = actual.pop();
                        num2 = actual.pop();
                        this.result = num2 * num1;
                        actual.push(this.result);
                    } catch (Exception e) {
                        throw new IndexOutOfBoundsException("There aren't enough values to operate");
                    }
                    break;
