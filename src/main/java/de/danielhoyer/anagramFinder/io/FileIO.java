package de.danielhoyer.anagramFinder.io;

import java.io.*;
import java.util.List;

/**
 * This class expects the string representation of a filepath to parse. The handling of the file is completely done here.
 */
public class FileIO implements GeneralIO {

    private final String filePath;
    private BufferedReader reader;

    public FileIO(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Gets the list representation of the specified file.
     *
     * @return null if the filepath is null or empty otherwise the Stream representation of the file. Every element in the Stream represents one line.
     * @throws FileNotFoundException if the file cannot be found.
     */
    @Override
    public List<String> getDataList() throws FileNotFoundException {
        if(this.filePath != null && !this.filePath.isEmpty()) {
            FileInputStream inputStream = new FileInputStream(this.filePath);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            return reader.lines().toList();
        } else {
            return null;
        }
    }


    @Override
    public void close() throws IOException {
        if(this.reader != null){
            this.reader.close();
        }
    }
}
