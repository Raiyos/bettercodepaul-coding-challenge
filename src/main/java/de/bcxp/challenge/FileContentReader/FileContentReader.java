package de.bcxp.challenge.FileContentReader;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class FileContentReader {

  public abstract <T> List<T> readFileWithPath(String filePath) throws FileNotFoundException;
}
