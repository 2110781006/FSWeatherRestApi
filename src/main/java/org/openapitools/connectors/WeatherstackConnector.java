package org.openapitools.connectors;

import com.google.gson.Gson;
import org.openapitools.model.Location;
import org.openapitools.model.Weather;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

        System.out.println(weather.toString());

        return weather;
    }
}
