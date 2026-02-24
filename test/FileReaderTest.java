import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    @Test
    void readFileReturnsCorrectLines() throws Exception {
        File tempFile = File.createTempFile("test", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Line1\n");
            writer.write("Line2\n");
        }
        FileReader reader = new FileReader();
        Vector<String> lines = reader.ReadFile(tempFile.getAbsolutePath());
        assertEquals(2, lines.size());
        assertEquals("Line1", lines.get(0));
        assertEquals("Line2", lines.get(1));
        tempFile.delete();
    }

    @Test
    void readNonExistingFileThrowsException() {
        FileReader reader = new FileReader();
        assertThrows(IllegalArgumentException.class,
                () -> reader.ReadFile("non_existing_file.txt"));
    }
}