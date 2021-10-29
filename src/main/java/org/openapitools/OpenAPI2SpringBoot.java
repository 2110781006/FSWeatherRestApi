package org.openapitools;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.*;
import com.fasterxml.jackson.databind.Module;
import org.openapitools.connectors.WeatherstackConnector;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.openapitools.model.Credentials;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools", "org.openapitools.api" , "org.openapitools.configuration"})
public class OpenAPI2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception
    {
        Credentials credentials = Credentials.getInstance();

        //first idx weatherstack token
        credentials.setWeatherstackToken(args[0]);

        //awsdynamodbExample();
        new SpringApplication(OpenAPI2SpringBoot.class).run(args);
    }

    static void awsdynamodbExample()
    {
        BasicAWSCredentials credentials = new BasicAWSCredentials("x", "y");
        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-1").withCredentials(new AWSStaticCredentialsProvider(credentials)).build();

        DynamoDB dynamoDB = new DynamoDB(ddb);

        //Table table = dynamoDB.getTable("fsweather_dynamodb");


        Table table = dynamoDB.getTable("fsweather_dynamodb");

        /*QuerySpec spec = new QuerySpec()
                .withKeyConditionExpression("ID = :nn")
                .withValueMap(new ValueMap()
                        .withString(":nn", "Product Line 1#P1 Thread 1"));*/

        /*ItemCollection<QueryOutcome> items = table.query(new KeyAttribute("city", "Eisenstadt"));
        System.out.println("####"+items);
        Iterator<Item> iterator = items.iterator();
        Item item = null;*/

        Map<String, String> expressionAttributeNames = new HashMap<String, String>();
        //expressionAttributeNames.put("#time", "TIME");
        QuerySpec spec = new QuerySpec()
                .withKeyConditionExpression("city = :my_city and time > :my_time")
                .withNameMap(expressionAttributeNames)
                .withValueMap(new ValueMap()
                        .withString(":my_city", "Eisenstadt")
                        .withNumber(":my_time", 0));

        ItemCollection<QueryOutcome> s = table.query(spec);
        Iterator i = s.iterator();

        while (i.hasNext()) {
            System.out.println("#########");
        }
        System.out.println("sss"+table.getTableName()+table.getDescription());
        QueryRequest request1 = new QueryRequest("fsuweather_dynamodb");
//ddb.query(request1);

        /*QueryRequest queryRequest = new QueryRequest();
        queryRequest.setTableName("fsweather_dynamodb");
        QueryResult result = ddb.query(queryRequest);
        System.out.println(result.getItems().get(0).toString());*/

        ListTablesRequest request;

        boolean more_tables = true;
        String last_name = null;

        while(more_tables)
        {
            try
            {
                if (last_name == null)
                {
                    request = new ListTablesRequest().withLimit(10);
                }
                else
                {
                    request = new ListTablesRequest()
                            .withLimit(10)
                            .withExclusiveStartTableName(last_name);
                }

                ListTablesResult table_list = ddb.listTables(request);
                List<String> table_names = table_list.getTableNames();

                if (table_names.size() > 0)
                {
                    for (String cur_name : table_names)
                    {
                        System.out.format("* %s\n", cur_name);
                    }
                }
                else
                {
                    System.out.println("No tables found!");
                    System.exit(0);
                }

                last_name = table_list.getLastEvaluatedTableName();
                if (last_name == null)
                {
                    more_tables = false;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }



    static class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }

    @Bean
    public WebMvcConfigurer webConfigurer() {
        return new WebMvcConfigurer() {
            /*@Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("Content-Type");
            }*/
        };
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}
