import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;
public class Controller {
    private final PrintStream imp;
    private final Scanner sc;
    private PostfiProcessor calculator;
    private FilesManagment fileControl;
    private String dataTarget;
    private String resultTarget;
        public Controller(){
        this.imp = System.out;
        this.sc = new Scanner(System.in);
        this.calculator = new PostfiProcessor();
        this.dataTarget = "target/data.txt";
        this.resultTarget = "target/results.txt";
    }
    public int EnterOnlyIntegers(){
        while (!sc.hasNextInt()) {
            System.out.println("Input is not an Integer.");
            sc.nextLine();
        }
        return sc.nextInt();
    }
    public void Initialize(){
        imp.println("Se ha inicializado el programa. Se inicia por default con Stack de Vectores. Escoja la opcion a realizar: ");
    }
}
