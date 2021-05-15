package com.example.springProject.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // JUnit 에 내장된 실행자 외 다른 실행자. 여기서는 SpringRunner라는 스프링 실행자를 사용합니다. 즉, 스프링 부트 테스트와 JUnit사이에 연결자 역할을 함
@WebMvcTest(controllers = HelloController.class) // 여러 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션..Service, Component, Repository등은 사용 불가. 컨트롤러만 사용하기 때문에 선언함. 매개변수로 어떤 컨트롤러클래스를 테스트할지 줄수있음ㄸㅌ
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc; // 웹 API테스트에 사용. 스프링의 MVC테스트 시작점. 이 클래스를 통해 API테스트 할 수 있음

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));
    }
}
