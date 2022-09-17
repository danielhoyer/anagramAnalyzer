package de.danielhoyer.anagramFinder.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.stream.Stream;

public interface GeneralIO extends Closeable {

    Stream<String> getDataStream() throws IOException;

}
