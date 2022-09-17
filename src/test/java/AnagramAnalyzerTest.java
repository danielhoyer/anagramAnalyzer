import de.danielhoyer.anagramFinder.analyzer.AnagramAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
    public void analyzeDummyStringStream() {
        Stream<String> dummyStream = Stream.of("one", "two", "three", "neo");
        Map<Integer, List<String>> expectedOutput = Map.of(Arrays.hashCode("eno".toCharArray()), Arrays.asList("one", "neo"),
                Arrays.hashCode("eehrt".toCharArray()), Arrays.asList("three"), Arrays.hashCode("otw".toCharArray()), Arrays.asList("two"));

        AnagramAnalyzer aa = new AnagramAnalyzer(dummyStream);
        aa.analyze();
        Map<Integer, List<String>> returnedOutput = aa.getAnagramMap();

        assertEquals(expectedOutput, returnedOutput);
    }

    @Test
    public void analyzeNullString() {
        AnagramAnalyzer aa = new AnagramAnalyzer();
        aa.analyze();

        assertNull(aa.getAnagramMap());
    }

    @Test
    public void printDummyResult() throws UnsupportedEncodingException {
        Map<Integer, List<String>> dummyMap = Map.of(Arrays.hashCode("eno".toCharArray()), Arrays.asList("one", "neo"),
                Arrays.hashCode("eehrt".toCharArray()), Arrays.asList("three"), Arrays.hashCode("otw".toCharArray()), Arrays.asList("two"));
        String expectedOutput = "one neo \n";

        AnagramAnalyzer aa = new AnagramAnalyzer();
        aa.setAnagramMap(dummyMap);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(PrintStream ps = new PrintStream(baos, true, StandardCharsets.UTF_8.name())){
            aa.printResult(ps);
        }
        String returnedOutput = baos.toString(StandardCharsets.UTF_8.name());

        assertEquals(expectedOutput, returnedOutput);

    }

}
