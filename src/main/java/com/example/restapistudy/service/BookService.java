package com.example.restapistudy.service;

import com.example.restapistudy.domain.Book;
import com.example.restapistudy.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional // 저장 실패시 롤백됨
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional(readOnly = true) // JPA 변경감지라는 내부 기능 활성화X, update시의 정합성 유지함. insert의 유령데이터 현상 못 막음
    public Book findBook(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요."));
    }

    @Transactional(readOnly = true)
    public List<Book> findAllBook() {
        return null;
    }

    @Transactional
    public Book editBook(int id, Book book) {
        Book bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요.")); // 영속화
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        return bookEntity;
    } // 함수 종료 > 트랜잭션 종료 > 영속화 된 데이터를 DB로 갱신(flush) > commit ====> 더티체킹

    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "delete OK";
    }

}
