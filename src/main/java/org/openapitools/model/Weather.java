package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.openapitools.model.Location;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Weather
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-22T09:18:47.043380800+02:00[Europe/Berlin]")
public class Weather   {
  @JsonProperty("location")
  private Location location;

  @JsonProperty("time")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime time;

  @JsonProperty("temperature")
  private BigDecimal temperature;

  @JsonProperty("description")
  private String description;

  @JsonProperty("windspeed")
  private BigDecimal windspeed;

  @JsonProperty("winddegree")
  private BigDecimal winddegree;

  @JsonProperty("winddirection")
  private String winddirection;

  @JsonProperty("pressure")
  private BigDecimal pressure;

  @JsonProperty("humidity")
  private BigDecimal humidity;

  @JsonProperty("cloudcover")
  private BigDecimal cloudcover;

  @JsonProperty("feelslike")
  private BigDecimal feelslike;

  @JsonProperty("visibility")
  private BigDecimal visibility;

  public Weather location(Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  @ApiModelProperty(value = "")

  @Valid

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Weather time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Creation date and time
   * @return time
  */
  @ApiModelProperty(example = "2021-01-30T08:30Z", value = "Creation date and time")

  @Valid

  public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public Weather temperature(BigDecimal temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * Get temperature
   * @return temperature
  */
  @ApiModelProperty(example = "1.23", value = "")

  @Valid

  public BigDecimal getTemperature() {
    return temperature;
  }

  public void setTemperature(BigDecimal temperature) {
    this.temperature = temperature;
  }

  public Weather description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(example = "fog", value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Weather windspeed(BigDecimal windspeed) {
    this.windspeed = windspeed;
    return this;
  }

  /**
   * Get windspeed
   * @return windspeed
  */
  @ApiModelProperty(example = "1.23", value = "")

  @Valid

  public BigDecimal getWindspeed() {
    return windspeed;
  }

  public void setWindspeed(BigDecimal windspeed) {
    this.windspeed = windspeed;
  }

  public Weather winddegree(BigDecimal winddegree) {
    this.winddegree = winddegree;
    return this;
  }

  /**
   * Get winddegree
   * @return winddegree
  */
  @ApiModelProperty(example = "1.23", value = "")

  @Valid

  public BigDecimal getWinddegree() {
    return winddegree;
  }

  public void setWinddegree(BigDecimal winddegree) {
    this.winddegree = winddegree;
  }

  public Weather winddirection(String winddirection) {
    this.winddirection = winddirection;
    return this;
  }

  /**
   * Get winddirection
   * @return winddirection
  */
  @ApiModelProperty(example = "N", value = "")


  public String getWinddirection() {
    return winddirection;
  }

  public void setWinddirection(String winddirection) {
    this.winddirection = winddirection;
  }

  public Weather pressure(BigDecimal pressure) {
    this.pressure = pressure;
    return this;
  }

  /**
   * Get pressure
   * @return pressure
  */
  @ApiModelProperty(example = "1.23", value = "")

  @Valid

  public BigDecimal getPressure() {
    return pressure;
  }

  public void setPressure(BigDecimal pressure) {
    this.pressure = pressure;
  }

  public Weather humidity(BigDecimal humidity) {
    this.humidity = humidity;
    return this;
  }

  /**
   * Get humidity
   * @return humidity
  */
  @ApiModelProperty(example = "1.23", value = "")

  @Valid

  public BigDecimal getHumidity() {
    return humidity;
  }

  public void setHumidity(BigDecimal humidity) {
    this.humidity = humidity;
  }

  public Weather cloudcover(BigDecimal cloudcover) {
    this.cloudcover = cloudcover;
    return this;
  }

  /**
   * Get cloudcover
   * @return cloudcover
  */
  @ApiModelProperty(example = "1.23", value = "")

  @Valid

  public BigDecimal getCloudcover() {
    return cloudcover;
  }

  public void setCloudcover(BigDecimal cloudcover) {
    this.cloudcover = cloudcover;
  }

  public Weather feelslike(BigDecimal feelslike) {
    this.feelslike = feelslike;
    return this;
  }

  /**
   * Get feelslike
   * @return feelslike
  */
  @ApiModelProperty(example = "1.23", value = "")

  @Valid

  public BigDecimal getFeelslike() {
    return feelslike;
  }

  public void setFeelslike(BigDecimal feelslike) {
    this.feelslike = feelslike;
  }

  public Weather visibility(BigDecimal visibility) {
    this.visibility = visibility;
    return this;
  }

  /**
   * Get visibility
   * @return visibility
  */
  @ApiModelProperty(example = "1.23", value = "")

  @Valid

  public BigDecimal getVisibility() {
    return visibility;
  }

  public void setVisibility(BigDecimal visibility) {
    this.visibility = visibility;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Weather weather = (Weather) o;
    return Objects.equals(this.location, weather.location) &&
        Objects.equals(this.time, weather.time) &&
        Objects.equals(this.temperature, weather.temperature) &&
        Objects.equals(this.description, weather.description) &&
        Objects.equals(this.windspeed, weather.windspeed) &&
        Objects.equals(this.winddegree, weather.winddegree) &&
        Objects.equals(this.winddirection, weather.winddirection) &&
        Objects.equals(this.pressure, weather.pressure) &&
        Objects.equals(this.humidity, weather.humidity) &&
        Objects.equals(this.cloudcover, weather.cloudcover) &&
        Objects.equals(this.feelslike, weather.feelslike) &&
        Objects.equals(this.visibility, weather.visibility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, time, temperature, description, windspeed, winddegree, winddirection, pressure, humidity, cloudcover, feelslike, visibility);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Weather {\n");
    
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    windspeed: ").append(toIndentedString(windspeed)).append("\n");
    sb.append("    winddegree: ").append(toIndentedString(winddegree)).append("\n");
    sb.append("    winddirection: ").append(toIndentedString(winddirection)).append("\n");
    sb.append("    pressure: ").append(toIndentedString(pressure)).append("\n");
    sb.append("    humidity: ").append(toIndentedString(humidity)).append("\n");
    sb.append("    cloudcover: ").append(toIndentedString(cloudcover)).append("\n");
    sb.append("    feelslike: ").append(toIndentedString(feelslike)).append("\n");
    sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

