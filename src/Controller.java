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

    /**
     * Main logicall controler and UI
     */
    public Controller() {
        this.imp = System.out;
        this.sc = new Scanner(System.in);
        this.calculator = new PostfiProcessor();
        this.fileControl = new FilesManagment();
        this.dataTarget = "target/data.txt";
        this.resultTarget = "target/results.txt";
    }

    /**
     * @return input but only if it is Integer
     */
    public int EnterOnlyIntegers() {
        while (!sc.hasNextInt()) {
            System.out.println("Input is not an Integer.");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    /**
     * Initial Statement of the program shown to the User
     */
    public void Initialize() {
        imp.println("Se ha inicializado el programa. Se inicia por default con Stack de Vectores. Escoja la opcion a realizar: ");
        menuInteraction();
    }

    /**
     * Control of action the User can ask to do
     */
    public void menuInteraction() {
        imp.println("\t1) Cambiar a Stack de Vectores. \n\t2) Cambiar a Stack de ArrayList \n\t3) Operar instrucciones guardadas en data.txt \n\t Salir");
        int opcion = EnterOnlyIntegers();
        switch (opcion) {
            case 1 -> {
                calculator.ChangeToVector();
                menuInteraction();
            }
            case 2 -> {
                calculator.ChangeToArray();
                menuInteraction();
            }
            case 3 -> {
                this.fileControl.DeleteFile(this.resultTarget);
                this.fileControl.CreateFile(this.resultTarget);
                Vector<String> lineas = this.fileControl.ReadFile(this.dataTarget);
                Vector<String> results = new Vector<>();
                for (int i = 0; i < lineas.size(); i++) {
                    float result = this.calculator.Operate(lineas.get(i));
                    results.add(String.valueOf(result));
                }
                showResults(results);
                menuInteraction();
            }
            case 4 -> {
                System.exit(0);
            }
            default -> {
                imp.println("Invalid option.");
                menuInteraction();
            }
        }
    }

    /**
     * @param results
     * Shows the results to the User and saves them in another document
     */
    public void showResults(Vector<String> results) {
        this.fileControl.WriteToTarget(this.resultTarget, results);
        for (int i = 0; i < results.size(); i++) {
            imp.println(results.get(i));
        }
    }
}
