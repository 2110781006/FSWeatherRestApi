package org.openapitools.connectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.openapitools.model.Weather;

import java.util.Base64;

/**
 * Aws iot connector class
 */
public class AwsIotConnector
{
    private String caCertPath;
    private String certPath;
    private String caKeyPath;

    /**
     * Constructor
     * @param caCertPath
     * @param certPath
     * @param caKeyPath
     */
    public AwsIotConnector(String caCertPath, String certPath, String caKeyPath)
    {
        this.caCertPath = caCertPath;
        this.certPath = certPath;
        this.caKeyPath = caKeyPath;
    }

    /**
     * push weather to aws iot
     */
    public void pushWeather(Weather weather)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            String weatherJson = mapper.writeValueAsString(weather);

            String curl = "curl";

            if (System.getProperty("os.name").toLowerCase().contains("win"))
                curl = "C:\\FH\\fsuWeatherRestApi\\ca\\curl.exe";

            String cmd = curl+"  --tlsv1.2 " +
                    "--cacert "+caCertPath+" " +
                    "--cert "+certPath+" " +
                    "--key "+caKeyPath+" " +
                    "--request POST " +
                    "--data \""+weatherJson.replace("\"", "'")+"\" "+
                    "\"https://a19itjop5c4o1d-ats.iot.us-east-1.amazonaws.com:8443/topics/fsuweather/" + weather.getLocation().getCity() + "/store_data?qos=1\"";
            Process p = Runtime.getRuntime().exec(cmd);

            p.waitFor();

            if ( p.exitValue() != 0 )
                throw new Exception();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
