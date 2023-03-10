package de.bcxp.challenge.MappingStrategy;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvChainedException;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import de.bcxp.challenge.Entity.DayWeatherData;

public class WeatherMappingStrategy<T extends DayWeatherData> extends HeaderColumnNameMappingStrategy<T> {
  // need to set the spread temperature manually since the data does not appear in the csv file
  @Override
  public T populateNewBean(String[] line) throws CsvBeanIntrospectionException, CsvFieldAssignmentException, CsvChainedException {
    T bean = super.populateNewBean(line);
    bean.setSpreadTemp();
    return bean;
  }
}
