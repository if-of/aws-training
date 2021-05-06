package com.example.awstraining.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class Book {

    public static final String TABLE_NAME = "books";

    @Getter(onMethod_ = {@DynamoDbPartitionKey, @DynamoDbAttribute("JSBN")})
    private String jsbn;

    @Getter(onMethod_ = {@DynamoDbAttribute("title")})
    private String title;

    @Getter(onMethod_ = {@DynamoDbAttribute("description")})
    private String description;
}
