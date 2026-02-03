import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors

public class FileCreator {
    public void CreateFile(String name) { //Includes target path
        try {
            File myObj = new File(name); // Create File object
            boolean newFile = myObj.createNewFile();
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't create the document");
        }
    }
}