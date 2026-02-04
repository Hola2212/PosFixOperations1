public class PostfiProcessor implements Calc{
    private String[] separados;
    private Stack<Float> numbersArray = new ArrayStack<Float>();
    private Stack<Float> numbersVector = new VectorStack<Float>();
    private Stack<Float> actualStack;
    private float result;
    public PostfiProcessor(){
        this.actualStack = this.numbersVector;
    }
    @Override
    public float Operate(String text){
        this.separados = text.split(" ");
        float num1 = 0;
        float num2 = 0;
        for (int i = 0; i < this.separados.length; i++){
            String actual = this.separados[i];
            switch (actual) {
                case "0","1","2","3","4","5","6","7","8","9":
                    float aux = Float.parseFloat(actual);
                    this.actualStack.push(aux);
                    break;
                case "+":
                    try {
                        num1 = this.actualStack.pop();
                        num2 = this.actualStack.pop();
                        this.result = num2 + num1;
                        this.actualStack.push(this.result);
                    } catch (Exception e) {
                        throw new IndexOutOfBoundsException("There aren't enough values to operate");
                    }
                    break;
                    case "-":
                    try {
                        num1 = this.actualStack.pop();
                        num2 = this.actualStack.pop();
                        this.result = num2 - num1;
                        this.actualStack.push(this.result);
                    } catch (Exception e) {
                        throw new IndexOutOfBoundsException("There aren't enough values to operate");
                    }
                    break;
                case "*":
                    try {
                        num1 = this.actualStack.pop();
                        num2 = this.actualStack.pop();
                        this.result = num2 * num1;
                        this.actualStack.push(this.result);
                    } catch (Exception e) {
                        throw new IndexOutOfBoundsException("There aren't enough values to operate");
                    }
                    break;
                    case "/":
                    try {
                        num1 = this.actualStack.pop();
                        num2 = this.actualStack.pop();
                        this.result = num2 / num1;
                        this.actualStack.push(this.result);
                    } catch (Exception e) {
                        throw new IndexOutOfBoundsException("There aren't enough values to operate");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("There is an illegal symbol on the expression.");
            }
        }
        return (float)(this.actualStack.pop());
    }
    public void ChangeToArray(){
        this.actualStack = this.numbersArray;
    }
    public void ChangeToVector(){ this.actualStack = this.numbersVector;}
    }

