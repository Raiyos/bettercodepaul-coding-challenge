package de.bcxp.challenge.MappingStrategy;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvChainedException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import de.bcxp.challenge.Entity.CountryData;
import de.bcxp.challenge.Entity.DayWeatherData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Map;

public class CountryMappingStrategy<T extends CountryData> extends HeaderColumnNameMappingStrategy<T> {
  @Override
  public T populateNewBean(String[] line) throws CsvBeanIntrospectionException, CsvFieldAssignmentException, CsvChainedException {
    T bean = super.populateNewBean(line);
    bean.setPopulationDensity();
    return bean;
  }
}
