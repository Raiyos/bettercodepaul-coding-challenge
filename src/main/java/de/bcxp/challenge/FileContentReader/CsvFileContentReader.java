package de.bcxp.challenge.FileContentReader;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.MappingStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvFileContentReader<T> extends FileContentReader {
  Logger logger = LogManager.getLogger();
  private final Class<T> type;
  private final MappingStrategy<T> mappingStrategy;

  public CsvFileContentReader(Class<T> type, MappingStrategy<T> mappingStrategy) {
    this.type = type;
    this.mappingStrategy = mappingStrategy;
  }

  @Override
  public List<T> readFileWithPath(String filePath) {
    List<T> content = new ArrayList<>();
    try
    {
      FileReader reader = new FileReader(filePath);
      CsvToBeanBuilder<T> csvToBeanBuilder = new CsvToBeanBuilder<T>(reader);
      mappingStrategy.setType(type);
      content = csvToBeanBuilder
              .withMappingStrategy(mappingStrategy)
              .build().parse();
    }
    catch (FileNotFoundException fileNotFoundException)
    {
      this.logger.error(String.format("file with filePath %s was not found", filePath));
      fileNotFoundException.printStackTrace();
    }
    return content;
  }
}
