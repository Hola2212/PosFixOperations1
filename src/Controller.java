/**
 * Main controller of the application.
 *
 * Handles user interaction, menu navigation, stack type selection,
 * file operations, and coordination between the infix converter
 * and postfix calculator.
 */
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;

public class Controller {
    private final PrintStream imp;
    private final Scanner sc;
    private InfixProcessor infixConverter;
    private PostfiProcessor calculator;
    private FilesManagment fileControl;
    private final String dataTarget = "target/data.txt";
    private final String resultTarget = "target/results.txt";

    /**
     * Main logicall controler and UI
     */
    public Controller() {
        this.imp = System.out;
        this.sc = new Scanner(System.in);
        this.calculator = PostfiProcessor.getInstance();
        this.fileControl = new FilesManagment();
        this.infixConverter = new InfixProcessor(StackType.VECTOR);
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
        imp.println("""
                1) Cambiar a Vector
                2) Cambiar a ArrayList
                3) Cambiar a Lista Encadenada
                4) Cambiar a Lista Doblemente Encadenada
                5) Operar data.txt
                6) Salir
                """);
        int opcion = EnterOnlyIntegers();
        switch (opcion) {
            case 1 -> {
                calculator.setStackType(StackType.VECTOR);
                infixConverter.setStackType(StackType.VECTOR);
            }
            case 2 -> {
                calculator.setStackType(StackType.ARRAY);
                infixConverter.setStackType(StackType.ARRAY);
            }
            case 3 -> {
                calculator.setStackType(StackType.LINKED_LIST);
                infixConverter.setStackType(StackType.LINKED_LIST);
            }
            case 4 -> {
                calculator.setStackType(StackType.DOUBLY_LINKED_LIST);
                infixConverter.setStackType(StackType.DOUBLY_LINKED_LIST);
            }
            case 5 -> operateFile();
            case 6 -> System.exit(0);
            default -> {
                imp.println("Invalid option.");
                menuInteraction();
            }
        }
    }

    /**
     * Operates the file and shows the result
     */
    private void operateFile() {
        fileControl.DeleteFile(resultTarget);
        fileControl.CreateFile(resultTarget);
        Vector<String> lineas = fileControl.ReadFile(dataTarget);
        Vector<String> results = new Vector<>();
        for (String linea : lineas) {
            String postfix = infixConverter.convert(linea);
            float result = calculator.Operate(postfix);
            results.add(String.valueOf(result));
        }
        fileControl.WriteToTarget(resultTarget, results);
        for (String r : results) {
            imp.println(r);
        }
    }
}
