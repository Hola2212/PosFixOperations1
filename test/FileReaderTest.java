import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    public FileReader test;
    @BeforeEach
    void setUp(){
        test = new FileReader();
    }
    @Test
    void readFile() {
        Vector<String> x = new Vector<>();
        x.add("1 2 + 4 * 3 +");
        x.add("1 2 - 4 / 3 +");
        x.add("1 2 + 4 / 3 +");
        x.add("1 2 - 4 * 3 +");
        x.add("1 2 + 4 - 3 +");
        Vector<String> text = test.ReadFile("target/data.txt");
        assertEquals(x.size(), text.size());
        assertEquals(x.toString(), text.toString());
    }
}