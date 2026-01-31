import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files
import java.util.Vector;

public class FileReader {
    private final File myObj;
    public FileReader() {
        this.myObj = new File("target/data.txt");
    }
    public Vector<String> ReadFile() {
        Vector<String> ans = new Vector<>();
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ans.add(data);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Couldn't read the document");
        }
        return ans;
    }
}
