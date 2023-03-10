package de.bcxp.challenge.Entity;

import com.opencsv.bean.CsvBindByName;

public class DayWeatherData {
  @CsvBindByName(column = "Day")
  private int day;
  @CsvBindByName(column = "MxT")
  private int maxTemp;
  @CsvBindByName(column = "MnT")
  private int minTemp;
  private int spreadTemp;

  public DayWeatherData() {
  }

  @Override
  public String toString() {
    return "DayWeatherData{" +
            "day=" + day +
            ", maxTemp=" + maxTemp +
            ", minTemp=" + minTemp +
            ", spreadTemp=" + spreadTemp +
            '}';
  }

  public void setSpreadTemp() {
    this.spreadTemp = this.maxTemp - this.minTemp;
  }

  public int getDay() {
    return day;
  }
  public int getSpreadTemp() {
    return spreadTemp;
  }
}
