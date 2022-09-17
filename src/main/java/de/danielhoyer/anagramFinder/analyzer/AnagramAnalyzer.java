package de.danielhoyer.anagramFinder.analyzer;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class analyzes the given list of Strings and handles the operations for finding anagrams in the stream.
 */
public class AnagramAnalyzer implements GeneralAnalyzer {
    private final List<String> dataList;
    private Map<Integer, List<String>> result;

    public AnagramAnalyzer(List<String> dataList) {
        this.dataList = dataList;
    }

    public AnagramAnalyzer(){
        this.dataList = null;
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
     * If the given dataString is not null, this method groups the elements in the list by using the unifyAndSortWord method and Streams.
     * The created map can be retrieved by calling getAnagramMap()
     */
    @Override
    public void analyze(){
        if(dataList != null) {
            Map<Integer, List<String>> map = dataList.stream().parallel()
                    .collect(Collectors.groupingByConcurrent(AnagramAnalyzer::getHashcodeOfUnifiedAndSortedWord));
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
