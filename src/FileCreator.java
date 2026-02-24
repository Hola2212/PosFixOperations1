import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors

/**
 * Creates a file in target path and name
 * @throws IllegalArgumentException when the document was allready created
 */
public class FileCreator {
    public void CreateFile(String name) { //Includes target path
        try {
            File file = new File(name);
            if (file.exists()) {
                throw new IllegalArgumentException("File already exists.");
            }
            if (!file.createNewFile()) {
                throw new IllegalArgumentException("Could not create file.");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't create the document.");
        }
    }
}