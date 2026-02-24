import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class FileWriterTest {

    @Test
    void writesFileCorrectly() {
        String name = "writeTest.txt";
        Vector<String> lines = new Vector<>();
        lines.add("A");
        lines.add("B");

        FileWritter writer = new FileWritter();
        writer.WriteToTarget(name, lines);

        assertTrue(new File(name).exists());
        new File(name).delete();
    }
}