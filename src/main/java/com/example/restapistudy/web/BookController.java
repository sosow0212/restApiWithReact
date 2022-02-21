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
    // Spring Security - CORS 정책을 가지고 있음

    private final BookService bookService;

    @CrossOrigin // 외부에서 들어오는 자바스크립트 요청을 허용해줌 (리액트 CORS오류 해결)
    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @CrossOrigin // 외부에서 들어오는 자바스크립트 요청을 허용해줌 (리액트 CORS오류 해결)
    @GetMapping("/book")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(bookService.findAllBook(), HttpStatus.OK); // 200 응답
    }

    @CrossOrigin
    @GetMapping("/book/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.findBook(id), HttpStatus.OK); // 200 응답
    }

    @CrossOrigin
    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.editBook(id, book), HttpStatus.OK); // 200 응답
    }

    @CrossOrigin
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK); // 200
    }
}
