package com.example.restapistudy.web;

import com.example.restapistudy.domain.Book;
import com.example.restapistudy.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
단위테스트 ( Controller 관련 로직만 띄움 )
ex) Controller ,Filter. ControllerAdvice ....

 */


@Slf4j
@WebMvcTest // 이 어노테이션을 붙이면 관련된 것만 IoC에 등록된다. 즉 단위테스트를 위한 어노테이션
public class BookControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // IoC 환경에 bean 등록됨
    private BookService bookService;

    @Test
    public void saveTest() throws JsonProcessingException {

        // BDDMockito 패턴 - given, when, then


        // given (테스트를 하기 위한 준비 단계)
        Book book = new Book(null, "책 제목", "홍길동");
        String content = new ObjectMapper().writeValueAsString(book);
        Mockito.when(bookService.saveBook(book)).thenReturn(new Book(null, "책 제목", "홍길동"));


        // when (테스트 실행)
        ResultActions resultAction= mockMvc.perform(MockServerHttpRequest.post("/book")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
                .accept(MediaType.APPLICATION_JSON_UTF8));



        //then (검증)
        ResultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("책 제목"))
                .andDo(MockMvcResultHandlers.print());
    }
}
