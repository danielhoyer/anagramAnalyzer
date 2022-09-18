package de.danielhoyer.anagramFinder.analyzer;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class analyzes the given String-Stream and handles the operations for finding anagrams in the stream.
 */
public class AnagramAnalyzer implements GeneralAnalyzer {
    private final Stream<String> dataStream;
    private Map<Integer, List<String>> result;

    public AnagramAnalyzer(Stream<String> dataStream) {
        this.dataStream = dataStream;
    }

    public AnagramAnalyzer(){
        this.dataStream = null;
    }

    /**
     * This method is used for the grouping by mechanism in analyze().
     * It sets the characters in the given String to lowercase (unify) and sorts the characters in the String by alphabetical order.
     * By doing that a unified key is generated for each String in the stream.
     * @param originalString
     * @return the hashcode of the lowercase and by alphabetical order sorted word.
     */
    public static int getHashcodeOfUnifiedAndSortedWord(String originalString){
        char[] charsOfString = originalString.toLowerCase().toCharArray();
        Arrays.sort(charsOfString);
        return Arrays.hashCode(charsOfString);
    }

    /**
     * If the given dataStream is not null, this method groups the elements in the stream by using the unifyAndSortWord method and Streams.
     * The created map can be retrieved by calling getAnagramMap()
     */
    @Override
    public void analyze(){
        if(dataStream != null) {
            Map<Integer, List<String>> map = dataStream
                    .collect(Collectors.groupingBy(AnagramAnalyzer::getHashcodeOfUnifiedAndSortedWord));
            this.result = map;
        }
    }


    public Map<Integer, List<String>> getResult() {
        return result;
    }

    public void setResult(Map<Integer, List<String>> result) {
        this.result = result;
    }
}
