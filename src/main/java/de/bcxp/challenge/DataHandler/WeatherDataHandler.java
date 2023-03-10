package de.bcxp.challenge.DataHandler;

import de.bcxp.challenge.Entity.DayWeatherData;
import de.bcxp.challenge.FileContentReader.FileContentReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class WeatherDataHandler {
  private final static Logger logger = LogManager.getLogger();
  private final FileContentReader fileContentReader;
  private List<DayWeatherData> weatherDataList;

  public WeatherDataHandler(FileContentReader fileContentReader, String filePath) {
    this.fileContentReader = fileContentReader;
    addToDataViaCsvWithFilePath(filePath);
  }

  public List<DayWeatherData> getWeatherDataList() {
    return weatherDataList;
  }

  public void addToDataViaCsvWithFilePath(String filePath) {
    List<DayWeatherData> weatherList = this.fileContentReader.readFileWithPath(filePath);
    setWeatherDataList(weatherList);
  }

  public void setWeatherDataList(List<DayWeatherData> weatherDataList) {
    this.weatherDataList = weatherDataList;
  }

  public int getDayWithLowestTemperatureSpread() {
    logger.trace("retrieving the day with the lowest difference in temperature via Java stream API");
    DayWeatherData dayWithMinTemperatureDifference = getWeatherDataList()
            .stream()
            .min(Comparator.comparing(DayWeatherData::getSpreadTemp))
            .orElseThrow(NoSuchElementException::new);
    return dayWithMinTemperatureDifference.getDay();
  }
}

