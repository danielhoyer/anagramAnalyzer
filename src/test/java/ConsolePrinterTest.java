import de.danielhoyer.anagramFinder.analyzer.AnagramAnalyzer;
import de.danielhoyer.anagramFinder.printer.ConsolePrinter;
import de.danielhoyer.anagramFinder.printer.GeneralPrinter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsolePrinterTest {

    private static final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setSystemOutToCustomStream() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void printDummyResult() throws UnsupportedEncodingException {
        Map<Integer, List<String>> dummyMap = Map.of(Arrays.hashCode("eno".toCharArray()), Arrays.asList("one", "neo"),
                Arrays.hashCode("eehrt".toCharArray()), Arrays.asList("three"), Arrays.hashCode("otw".toCharArray()), Arrays.asList("two"));
        String expectedOutput = "one neo \n";

        AnagramAnalyzer aa = new AnagramAnalyzer();
        aa.setResult(dummyMap);
        GeneralPrinter printer = new ConsolePrinter(aa);

        printer.printResult();
        String returnedOutput = out.toString(StandardCharsets.UTF_8.name());

        assertEquals(expectedOutput, returnedOutput);

    }

    @AfterAll
    public static void resetSystemOutToDefault() {
        System.setOut(originalOut);
    }

}
