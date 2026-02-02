import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class

public class FileWritter {
    public void WriteToTarget(String target, String[] text){
        try {
            FileWriter myWriter = new FileWriter(target);
            for (String s : text) {
                myWriter.write(s + "\n");
            }
            myWriter.close();  // must close manually
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't write in the document");
        }
    }
}