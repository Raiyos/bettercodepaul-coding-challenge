package de.bcxp.challenge.FileContentReader;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.MappingStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvFileContentReader<T> extends FileContentReader {
  Logger logger = LogManager.getLogger();
  private final Class<T> type;
  private final MappingStrategy<T> mappingStrategy;
  private final char delimiter;

  public CsvFileContentReader(Class<T> type, MappingStrategy<T> mappingStrategy, char delimiter) {
    this.type = type;
    this.mappingStrategy = mappingStrategy;
    this.delimiter = delimiter;
  }

  @Override
  public List<T> readFileWithPath(String filePath) throws FileNotFoundException {
    List<T> content = new ArrayList<>();
    try
    {
      FileReader reader = new FileReader(filePath);
      CsvToBeanBuilder<T> csvToBeanBuilder = new CsvToBeanBuilder<T>(reader);
      mappingStrategy.setType(type);
      content = csvToBeanBuilder
              .withSeparator(delimiter)
              .withThrowExceptions(false)
              .withMappingStrategy(mappingStrategy)
              .build().parse();
    }
    catch (FileNotFoundException fileNotFoundException)
    {
      this.logger.error(String.format("file with filePath %s was not found", filePath));
      fileNotFoundException.printStackTrace();
      throw new FileNotFoundException();
    }
    if(content.size() == 0)
    {
      this.logger.error("the file read seemed to be empty");
    }
    return content;
  }
}
