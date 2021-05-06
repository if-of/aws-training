package com.example.awstraining.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

    @Bean
    DynamoDbClient amazonDynamoDBClient() {
        return getDynamoDbClient();
    }

    @Bean
    DynamoDbEnhancedClient amazonDynamoDBEnhancedClient() {
        return DynamoDbEnhancedClient.builder().dynamoDbClient(getDynamoDbClient()).build();
    }

    private DynamoDbClient getDynamoDbClient() {
        ClientOverrideConfiguration.Builder overrideConfig =
                ClientOverrideConfiguration.builder();

        return DynamoDbClient.builder()
                .overrideConfiguration(overrideConfig.build())
                //.endpointOverride(URI.create("http://localhost:8000"))
                // .region(Region.US_EAST_1)
                //.credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

}