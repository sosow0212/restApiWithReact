package com.example.restapistudy.service;

import com.example.restapistudy.domain.BookRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*

 단위 테스트 (Service와 관련된 것들만 메모리에 띄우면 됨)

 BoardRepository = Mock을 이용하여 가짜 객체로 만들 수 있음



 */



@ExtendWith(MockitoExtension.class) // Mock 환경으로 만듬
public class BookServiceUnitRepository {

    @InjectMocks // BookService 객체가 만들어질 때, BookServiceUnitTest 파일에 @Mock로 등록된 모든 애들을 주입 받는다.
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;
}
