package org.openapitools.connectors;

import com.google.gson.Gson;
import org.joda.time.field.OffsetDateTimeField;
import org.openapitools.model.Location;
import org.openapitools.model.Weather;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Weatherstack connector class
 */
public class WeatherstackConnector
{
    private String apiToken;

    /**
     * Constructor
     * @param apiToken weatherstack api token
     */
    public WeatherstackConnector(String apiToken)
    {
        this.apiToken = apiToken;
    }

    /**
     * Get current weather of the given location
     * @param city city
     * @return
     */
    public Weather getCurrentWeatherOfLocation(String city) throws IOException, InterruptedException
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.weatherstack.com/current?access_key="+apiToken+"&query="+ URLEncoder.encode( city, "UTF-8")))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();


        Map weatherMap = gson.fromJson(response.body(), Map.class);

        Weather weather = new Weather();
        Location location = new Location();

        Map locationMap = (Map) weatherMap.get("location");

        location.setCity(locationMap.get("name").toString());
        location.setCountry(locationMap.get("country").toString());
        location.setRegion(locationMap.get("region").toString());
        location.setLat(new BigDecimal(Double.valueOf(locationMap.get("lat").toString())));
        location.setLon(new BigDecimal(Double.valueOf(locationMap.get("lon").toString())));
        location.setTimezone(locationMap.get("timezone_id").toString());

        weather.setLocation(location);

        Map currentMap = (Map) weatherMap.get("current");

        weather.setTime(locationMap.get("localtime").toString());
        weather.setTemperature(new BigDecimal(Double.valueOf(currentMap.get("temperature").toString())));
        weather.setDescription(currentMap.get("weather_descriptions").toString());
        weather.setWindspeed(new BigDecimal(Double.valueOf(currentMap.get("wind_speed").toString())));
        weather.setWinddegree(new BigDecimal(Double.valueOf(currentMap.get("wind_degree").toString())));
        weather.setWinddirection(currentMap.get("wind_dir").toString());
        weather.setPressure(new BigDecimal(Double.valueOf(currentMap.get("pressure").toString())));
        weather.setHumidity(new BigDecimal(Double.valueOf(currentMap.get("humidity").toString())));
        weather.setCloudcover(new BigDecimal(Double.valueOf(currentMap.get("cloudcover").toString())));
        weather.setFeelslike(new BigDecimal(Double.valueOf(currentMap.get("feelslike").toString())));
        weather.setVisibility(new BigDecimal(Double.valueOf(currentMap.get("visibility").toString())));

        return weather;
    }
}
