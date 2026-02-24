import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class FileDeleterTest {

    @Test
    void deletesFileSuccessfully() throws Exception {
        String name = "deleteTest.txt";
        new File(name).createNewFile();

        FileDeleter deleter = new FileDeleter();
        deleter.DeleteFile(name);

        assertFalse(new File(name).exists());
    }

    @Test
    void deletingNonExistingFileThrows() {
        FileDeleter deleter = new FileDeleter();

        assertThrows(IllegalArgumentException.class,
                () -> deleter.DeleteFile("notExists.txt"));
    }
}