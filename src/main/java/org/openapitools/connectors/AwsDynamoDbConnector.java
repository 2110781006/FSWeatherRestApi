package org.openapitools.connectors;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import org.openapitools.model.Weather;

import java.util.ArrayList;
import java.util.Map;

/**
 * aws dynamo db connector via java sdk
 */
public class AwsDynamoDbConnector
{
    private String accessKey;
    private String secureKey;

    /**
     * constructor
     * @param accessKey
     * @param secureKey
     */
    public AwsDynamoDbConnector(String accessKey, String secureKey)
    {
        this.accessKey = accessKey;
        this.secureKey = secureKey;
    }

    /**
     * get stored weather of city
     * @param city
     * @return
     */
    public ArrayList<Weather> getStoredWeatherSetOfLocation(String city)
    {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secureKey);

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard()
                .withRegion("us-east-1")
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        ScanRequest scanRequest = new ScanRequest().withTableName("fsweather_dynamodb");

        ScanResult result = ddb.scan(scanRequest);

        ArrayList<Weather> ret = new ArrayList<>();

        for (Map<String, AttributeValue> item : result.getItems())
        {
            if ( item.containsKey("data_raw") )
            {
                var buffer = item.get("data_raw");

                Weather temp = null;

                String json = new String(buffer.getB().array()).replace("'", "\"");

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                objectMapper.registerModule(new JavaTimeModule());

                try
                {
                    temp = objectMapper.readValue(json, Weather.class);

                    if ( temp.getLocation().getCity().equals(city) )
                        ret.add(temp);
                }
                catch (Exception e)
                {
                    //wrong format could not deserialize
                }
            }
        }

        return ret;
    }
}
