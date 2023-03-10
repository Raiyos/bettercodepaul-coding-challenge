package de.bcxp.challenge;

import de.bcxp.challenge.DataHandler.CountryDataHandler;
import de.bcxp.challenge.Entity.CountryData;
import de.bcxp.challenge.FileContentReader.CsvFileContentReader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

public class CountryDataHandlerTest {
  @Test
  public void getCountryWithHighestPopulationDensityTest() {
    CsvFileContentReader<CountryData> mockObject = Mockito.mock(CsvFileContentReader.class);
    CountryData[] countryDataArray = { new CountryData("Singapur", 5454000, 729),
            new CountryData("Bali", 4362000, 5780),
            new CountryData("Austria", 8926000,83855)};
    List<CountryData> countryDataList = new ArrayList(Arrays.asList(countryDataArray));
    try
    {
      when(mockObject.readFileWithPath("mock-path")).thenReturn(countryDataList);
    }
    catch (FileNotFoundException fileNotFoundException)
    {
      System.out.println("error in test");
      assertEquals(true, false);
    }

    CountryDataHandler countryDataHandler = new CountryDataHandler(mockObject, "mock-path");
    String country = countryDataHandler.getCountryWithHighestPopulationDensity();
    assertEquals(country, "Singapur");
  }
}
