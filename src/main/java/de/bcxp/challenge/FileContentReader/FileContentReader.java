package de.bcxp.challenge.FileContentReader;

import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.util.List;

public abstract class FileContentReader {

  public abstract <T> List<T> readFileWithPath(String filePath);
}
