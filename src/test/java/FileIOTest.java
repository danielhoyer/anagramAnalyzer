import de.danielhoyer.anagramFinder.io.FileIO;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class FileIOTest {

    @Test
    public void getNullDataStreamWithNullLocation() throws FileNotFoundException {
        FileIO fileIO = new FileIO(null);
        assertNull(fileIO.getDataStream());
    }

    @Test
    public void getNullDataStreamWithEmptyLocation() throws FileNotFoundException {
        FileIO fileIO = new FileIO("");
        assertNull(fileIO.getDataStream());
    }

    @Test
    public void getNonExistentFile() {
        FileIO fileIO = new FileIO("test");
        assertThrows(FileNotFoundException.class, () -> fileIO.getDataStream());
    }

}
