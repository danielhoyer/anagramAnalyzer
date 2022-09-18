package de.danielhoyer.anagramFinder.printer;

import de.danielhoyer.anagramFinder.analyzer.AnagramAnalyzer;
import de.danielhoyer.anagramFinder.analyzer.GeneralAnalyzer;

import java.io.PrintStream;

/**
 * This class prints the results of the analyzation to the default console.
 */
public class ConsolePrinter implements GeneralPrinter {

    private final PrintStream printStream;
    private final GeneralAnalyzer analyzer;

    public ConsolePrinter(GeneralAnalyzer analyzer) {
        this.printStream = System.out;
        this.analyzer = analyzer;
    }

    @Override
    public void printResult() {
        if(analyzer instanceof AnagramAnalyzer){
            AnagramAnalyzer aa = (AnagramAnalyzer) analyzer;
            aa.getResult().forEach((key, value) -> {
                if(value.size() > 1) {
                    value.forEach(v -> {
                        printStream.print(v);
                        printStream.print(" ");
                    });
                    printStream.print("\n");
                }
            });
        } else {
            System.out.println("Analyzer is not known yet, result can not be printed correctly.");
        }
    }
}
