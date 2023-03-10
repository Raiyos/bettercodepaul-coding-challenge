package de.bcxp.challenge;

import de.bcxp.challenge.Entity.DayWeatherData;
import de.bcxp.challenge.FileContentReader.CsvFileContentReader;
import de.bcxp.challenge.MappingStrategy.WeatherMappingStrategy;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileContentReaderTest {
  @Test
  // testing with an invalid file path
  public void testReadFileContentWrongFilePath() {
    WeatherMappingStrategy<DayWeatherData> weatherMappingStrategy = new WeatherMappingStrategy<>();
    CsvFileContentReader csvFileContentReader = new CsvFileContentReader(DayWeatherData.class, weatherMappingStrategy, ',');
    try
    {
      csvFileContentReader.readFileWithPath("filepath-wrong");
    }
    catch (Exception exception)
    {
      assertEquals(FileNotFoundException.class, exception.getClass());
    }
  }
}
