import org.junit.jupiter.api.Test;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class FilesManagmentTest {

    @Test
    void fullFileFlowWorks() {
        FilesManagment manager = new FilesManagment();

        String file = "flowTest.txt";

        manager.CreateFile(file);

        Vector<String> lines = new Vector<>();
        lines.add("Hello");
        manager.WriteToTarget(file, lines);

        Vector<String> read = manager.ReadFile(file);

        assertEquals(1, read.size());
        assertEquals("Hello", read.get(0));

        manager.DeleteFile(file);
    }
}