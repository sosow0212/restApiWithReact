package com.example.restapistudy.domain;

// 단위 테스트 (DB 관련된 Bean이 IoC에 등록되면 됨)


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional // 실행하고 롤백 시킴
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // 가짜 DB로 테스트, Replace.NONE은 실제 DB로 테스트
@DataJpaTest // Jpa 관련된 애들만 메모리에 뜸
public class BookRepositoryUnitTest {

    @Autowired
    private BookRepository bookRepository;
}
