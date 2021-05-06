package com.example.awstraining.controller;

import com.example.awstraining.dto.BookDto;
import com.example.awstraining.entity.Book;
import com.example.awstraining.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/jsbn/{jsbn}")
    ResponseEntity<Book> getBook(@PathVariable String jsbn) {
        return bookService.get(jsbn)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/books")
    ResponseEntity<Book> putBook(@RequestBody BookDto bookDto) {
        Book book = Book.builder()
                .jsbn(bookDto.getJsbn())
                .title(bookDto.getTitle())
                .description(bookDto.getDescription())
                .build();
        bookService.put(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/books")
    ResponseEntity<Book> updateBook(@RequestBody BookDto bookDto) {
        Book book = Book.builder()
                .jsbn(bookDto.getJsbn())
                .title(bookDto.getTitle())
                .description(bookDto.getDescription())
                .build();
        bookService.update(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/books/jsbn/{jsbn}")
    ResponseEntity<Book> deleteBook(@PathVariable String jsbn) {
        bookService.delete(jsbn);
        return ResponseEntity.ok().build();
    }

}
