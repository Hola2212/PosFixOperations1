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
