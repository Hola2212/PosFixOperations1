import java.io.File;       // Import the File class
import java.io.IOException; // Import IOException to handle errors

public class FileDeleter {
    public void DeleteFile(String target) {
        File myObj = new File(target);
        if (!myObj.delete()) {
            throw new IllegalArgumentException("Couldn't delete the document");
        }
    }
}