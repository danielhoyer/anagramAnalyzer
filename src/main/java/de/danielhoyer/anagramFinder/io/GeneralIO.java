package de.danielhoyer.anagramFinder.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public interface GeneralIO extends Closeable {

    List<String> getDataList() throws IOException;

}
