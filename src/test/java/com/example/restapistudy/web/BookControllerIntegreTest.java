package com.example.restapistudy.web;

/*
 통합 테스트 (모든 Bean들을 똑같이 IoC에 올리고 테스트 하는 것

 @WebEnvironment.MOCK = 실제 톰켓을 올리는게 아니라 다른 톰켓으로 테스트한다는 것
 @WebEnvironment.RANDOM_POR = 실제 톰켓으로 테스트
 @AutoConfigureMockMvc = MockMvc를 IoC에 등록해줌

 @Transactional = 각각의 테스트 함수가 종료될 때마다 트랜잭션을 롤백 해준다.
 -> 즉 테스트 함수에서 DB Insert 같은 걸 할 때, 트랜잭션을 걸면 테스트가 끝나면 데이터를 다시 out 시켜준다. (원상복구)

 @Test = 전체의 테스트 함수가 종료되면 DB를 롤백 시켜준다. Transactional은 각각의 테스트 함수 범위라고 생각하면 된다.

 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 스프링 통합 테스트를 위한 어노테이션
public class BookControllerIntegreTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveTest() {
        System.out.println("saveTest() 시작 =======================");
    }

}
