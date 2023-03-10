package de.bcxp.challenge;

import de.bcxp.challenge.DataHandler.WeatherDataHandler;
import de.bcxp.challenge.Entity.DayWeatherData;
import de.bcxp.challenge.FileContentReader.CsvFileContentReader;
import de.bcxp.challenge.MappingStrategy.WeatherMappingStrategy;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        final String weatherFilePath = "src/main/resources/de/bcxp/challenge/weather.csv";
        WeatherMappingStrategy<DayWeatherData> weatherMappingStrategy = new WeatherMappingStrategy<>();
        CsvFileContentReader<DayWeatherData> weatherFileContentReader =
                new CsvFileContentReader<>(DayWeatherData.class, weatherMappingStrategy);
        WeatherDataHandler weatherDataHandler = new WeatherDataHandler(weatherFileContentReader, weatherFilePath);

        int dayWithSmallestTempSpread = weatherDataHandler.getDayWithLowestTemperatureSpread();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %d%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
