package com.example.springProject.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 왜 안돼지? 테스트 실패. error: variable name not initialized in the default constructor 라는 메시지 -> gradle 버전문제였음. ./gradlew wrapper --gradle-version 4.10.2 로 다운그레이드 시켜셔 해결가능
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
