package com.example.restapistudy.web;

/*
 통합 테스트 (모든 Bean들을 똑같이 IoC에 올리고 테스트 하는 것

 @WebEnvironment.MOCK = 실제 톰켓을 올리는게 아니라 다른 톰켓으로 테스트한다는 것
 @WebEnvironment.RANDOM_POR = 실제 톰켓으로 테스트

 */


import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 스프링 통합 테스트를 위한 어노테이션
public class BookControllerIntegreTest {
}
