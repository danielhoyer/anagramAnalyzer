import de.danielhoyer.anagramFinder.analyzer.AnagramAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramAnalyzerTest {

    @Test
    public void unifyAndSortWordWithSampleString() {
        String sampleString = "cat";
        int expectedOutput = Arrays.hashCode("act".toCharArray());

        int returnedOutput = AnagramAnalyzer.getHashcodeOfUnifiedAndSortedWord(sampleString);

        assertEquals(returnedOutput, expectedOutput);
    }

    @Test
    public void analyzeDummyStringList() {
        List<String> dummyList = Arrays.asList("neo", "two", "three", "one");
        Map<Integer, List<String>> expectedOutput = Map.of(Arrays.hashCode("eno".toCharArray()), Arrays.asList("one", "neo"),
                Arrays.hashCode("eehrt".toCharArray()), Arrays.asList("three"), Arrays.hashCode("otw".toCharArray()), Arrays.asList("two"));

        AnagramAnalyzer aa = new AnagramAnalyzer(dummyList);
        aa.analyze();
        Map<Integer, List<String>> returnedOutput = aa.getResult();

        assertEquals(expectedOutput, returnedOutput);
    }

    @Test
    public void analyzeNullString() {
        AnagramAnalyzer aa = new AnagramAnalyzer();
        aa.analyze();

        assertNull(aa.getResult());
    }



}
