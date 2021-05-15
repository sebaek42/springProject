package com.example.springProject.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

// RestController 는 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
// GetMapping은 Http GET method 요청을 받을 수 있는 API를 만들어줌
// 이제 /hello 로 요청이 오면 문자열 hello를 반환하는 기능을 가지게 됨
