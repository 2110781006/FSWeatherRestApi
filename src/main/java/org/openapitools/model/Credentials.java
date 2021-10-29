package org.openapitools.model;

/**
 * Class stores credentials
 */
public class Credentials
{
    private String weatherstackToken;

    private static final Credentials singleton = new Credentials();

    /**
     * return singleton instance
     * @return
     */
    public static Credentials getInstance()
    {
        return singleton;
    }

    /**
     * return weatherstack token
     * @return
     */
    public String getWeatherstackToken()
    {
        return weatherstackToken;
    }

    /**
     * set weatherstack token
     * @param weatherstackToken
     */
    public void setWeatherstackToken(String weatherstackToken)
    {
        this.weatherstackToken = weatherstackToken;
    }
}
