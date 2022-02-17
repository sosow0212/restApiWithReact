package com.example.restapistudy.web;

import com.example.restapistudy.domain.Book;
import com.example.restapistudy.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/book")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(bookService.findAllBook(), HttpStatus.OK); // 200 응답
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.findBook(id), HttpStatus.OK); // 200 응답
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.editBook(id, book), HttpStatus.OK); // 200 응답
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }
}
