package org.openapitools.model;

/**
 * Class stores credentials
 */
public class Credentials
{
    private String weatherstackToken;
    private String caCertPath;
    private String certPath;
    private String caKeyPath;
    private String awsAccessKey;
    private String awsSecretKey;


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

    /**
     * get aws ca certificate path
     */
    public String getCaCertPath()
    {
        return caCertPath;
    }

    /**
     * set aws ca certificate path
     * @param caCertPath
     */
    public void setCaCertPath(String caCertPath)
    {
        this.caCertPath = caCertPath;
    }

    /**
     * get aws certificate path
     * @return
     */
    public String getCertPath()
    {
        return certPath;
    }

    /**
     * set aws certificate path
     * @param certPath
     */
    public void setCertPath(String certPath)
    {
        this.certPath = certPath;
    }

    /**
     * get aws key path
     * @return
     */
    public String getCaKeyPath()
    {
        return caKeyPath;
    }

    /**
     * set aws key path
     * @param caKeyPath
     */
    public void setCaKeyPath(String caKeyPath)
    {
        this.caKeyPath = caKeyPath;
    }

    /**
     * get aws sdk accesskey
     * @return
     */
    public String getAwsAccessKey()
    {
        return awsAccessKey;
    }

    /**
     * set aws sdk accesskey
     */
    public void setAwsAccessKey(String awsAccessKey)
    {
        this.awsAccessKey = awsAccessKey;
    }

    /**
     * get aws sdk securekey
     * @return
     */
    public String getAwsSecretKey()
    {
        return awsSecretKey;
    }

    /**
     * set aws sdk securekey
     */
    public void setAwsSecretKey(String awsSecretKey)
    {
        this.awsSecretKey = awsSecretKey;
    }
}
