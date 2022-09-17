package de.danielhoyer.anagramFinder;

import de.danielhoyer.anagramFinder.analyzer.AnagramAnalyzer;
import de.danielhoyer.anagramFinder.analyzer.GeneralAnalyzer;
import de.danielhoyer.anagramFinder.io.FileIO;
import de.danielhoyer.anagramFinder.io.GeneralIO;
import de.danielhoyer.anagramFinder.printer.ConsolePrinter;
import de.danielhoyer.anagramFinder.printer.GeneralPrinter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * The main class of the application.
 * If a path to a file is specified in the commandline arguments, the program will read this file and search for anagrams.
 * After that an output is printed to the console.
 *
 * If there is no file specified, the program will print an error the console.
 */
public class Application {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        long readTime = 0;
        if(args != null && args.length > 0){
            String filePath = args[0];
            try(GeneralIO fileIO = new FileIO(filePath)) {
                List<String> dataList = fileIO.getDataList();
                readTime = System.currentTimeMillis();
                System.out.printf("Reading time: %d ms\n", readTime - startTime);
                GeneralAnalyzer anagramAnalyzer = new AnagramAnalyzer(dataList);
                anagramAnalyzer.analyze();
                endTime = System.currentTimeMillis();
                GeneralPrinter printer = new ConsolePrinter(anagramAnalyzer);
                printer.printResult();
            } catch (IOException e) {
                System.out.println("Error while getting data stream!");
            }
        } else {
            System.out.println("No filepath specified in command line arguments!");
        }

        System.out.printf("Calculation time: %d ms\n", endTime - readTime);
    }
}