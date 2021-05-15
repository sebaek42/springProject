package com.example.springProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); // option + enter 시 import가능
    }
}

// Application 클래스는 앞으로 만들 프로젝트의 메인 클래스가 된다.
// @SpringBootApplication으로 인해 스프링 부트의 자동 설정, 스프링  Bean 읽기 생성 모두 자동으로 설정됨.
// SpringApplication.run 으로 인해 내장 WAS가 돌아가게됨