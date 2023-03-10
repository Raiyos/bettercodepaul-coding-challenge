package de.bcxp.challenge.Entity;

import com.opencsv.bean.CsvBindByName;

public class CountryData {
  @CsvBindByName(column = "Name")
  private String name;
  @CsvBindByName(column = "Population")
  private int population;
  @CsvBindByName(column = "Area (km²)")
  private int area;

  @Override
  public String toString() {
    return "CountryData{" +
            "name='" + name + '\'' +
            ", population=" + population +
            ", area=" + area +
            ", populationDensity=" + populationDensity +
            '}';
  }

  private double populationDensity;

  public CountryData() {
  }

  public CountryData(String name, int population, int area) {
    this.name = name;
    this.population = population;
    this.area = area;
    this.populationDensity = this.population / (double)this.area;
  }

  public double getPopulationDensity() {
    return populationDensity;
  }

  public int getPopulation() {
    return population;
  }

  public int getArea() {
    return area;
  }

  public String getName() {
    return name;
  }

  public void setPopulationDensity() {

    this.populationDensity = this.population / (double)this.area;
  }
}
