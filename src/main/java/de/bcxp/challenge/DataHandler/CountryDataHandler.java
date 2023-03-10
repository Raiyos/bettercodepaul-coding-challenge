package de.bcxp.challenge.DataHandler;

import de.bcxp.challenge.Entity.CountryData;
import de.bcxp.challenge.Entity.DayWeatherData;
import de.bcxp.challenge.FileContentReader.FileContentReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class CountryDataHandler {
  private final static Logger logger = LogManager.getLogger();
  private final FileContentReader fileContentReader;
  private List<CountryData> countryDataList;

  public CountryDataHandler(FileContentReader fileContentReader, String filePath) {
    this.fileContentReader = fileContentReader;
    try
    {
      addToDataViaCsvWithFilePath(filePath);
    }
    catch (FileNotFoundException fileNotFoundException)
    {
      logger.error(String.format("file with filePath %s was not found", filePath));
    }
  }

  public List<CountryData> getCountryDataList() {
    return countryDataList;
  }

  public void addToDataViaCsvWithFilePath(String filePath) throws FileNotFoundException {
    List<CountryData> countryList = this.fileContentReader.readFileWithPath(filePath);
    setCountryDataList(countryList);
  }

  public void setCountryDataList(List<CountryData> countryDataList) {
    if(countryDataList != null)
    {
      this.countryDataList = countryDataList;
    }
  }

  public String getCountryWithHighestPopulationDensity() {
    logger.trace("retrieving the country with the highest population density");
    CountryData countryWithHighestPopDensity = getCountryDataList()
            .stream()
            .max(Comparator.comparing(CountryData::getPopulationDensity))
            .orElseThrow(NoSuchElementException::new);
    System.out.println(getCountryDataList().size());
    return countryWithHighestPopDensity.getName();
  }
}
