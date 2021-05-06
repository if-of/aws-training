package com.example.awstraining.repository;

import com.example.awstraining.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class BookRepository {

    private final DynamoDbTable<Book> bookTable;

    public BookRepository(@Autowired DynamoDbEnhancedClient dynamo) {
        this.bookTable = dynamo.table(Book.TABLE_NAME, TableSchema.fromBean(Book.class));
    }

    public void put(Book book) {
        bookTable.putItem(book);
    }

    public Book get(String jsbn) {
        return bookTable.getItem(Key.builder().partitionValue(jsbn).build());
    }

    public void update(Book book) {
        bookTable.updateItem(book);
    }

    public void delete(String jsbn) {
        bookTable.deleteItem(Key.builder().partitionValue(jsbn).build());
    }
}
