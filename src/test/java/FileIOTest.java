import de.danielhoyer.anagramFinder.io.FileIO;
import de.danielhoyer.anagramFinder.io.GeneralIO;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileIOTest {

    @Test
    public void getNullDataStreamWithNullLocation() throws IOException {
        GeneralIO fileIO = new FileIO(null);
        assertNull(fileIO.getDataStream());
    }

    @Test
    public void getNullDataStreamWithEmptyLocation() throws IOException {
        GeneralIO fileIO = new FileIO("");
        assertNull(fileIO.getDataStream());
    }

    @Test
    public void getNonExistentFile() {
        GeneralIO fileIO = new FileIO("test");
        assertThrows(FileNotFoundException.class, () -> fileIO.getDataStream());
    }

}
