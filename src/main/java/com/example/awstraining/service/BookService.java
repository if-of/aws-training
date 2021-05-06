package com.example.awstraining.service;

import com.example.awstraining.entity.Book;
import com.example.awstraining.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void put(Book book) {
        bookRepository.put(book);
    }

    public Optional<Book> get(String jsbn) {
        return Optional.ofNullable(bookRepository.get(jsbn));
    }

    public void update(Book book) {
        bookRepository.update(book);
    }

    public void delete(String jsbn) {
        bookRepository.delete(jsbn);
    }
}
