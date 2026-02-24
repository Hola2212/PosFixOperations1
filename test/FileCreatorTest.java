import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class FileCreatorTest {

    @Test
    void createAndDeleteFile() {
        FileCreator creator = new FileCreator();
        String name = "testFile.txt";

        creator.CreateFile(name);
        assertTrue(new File(name).exists());

        new File(name).delete();
    }

    @Test
    void creatingExistingFileThrows() {
        FileCreator creator = new FileCreator();
        String name = "existing.txt";

        creator.CreateFile(name);

        assertThrows(IllegalArgumentException.class,
                () -> creator.CreateFile(name));

        new File(name).delete();
    }
}