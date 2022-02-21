package com.example.restapistudy.web;

// 단위테스트 ( Controller 관련 로직만 띄움 )
// ex) Controller ,Filter. ControllerAdvice ....

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest // 이 어노테이션을 붙이면 관련된 것만 IoC에 등록된다. 즉 단위테스트를 위한 어노테이션
public class BookControllerUnitTest {
}
