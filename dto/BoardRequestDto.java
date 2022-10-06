package com.sparta.homework.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String title; //제목
    private String writer; //작성자
    private String content; //내용
    private String password; //비밀번호
//    private LocalDateTime createdAt;
//    private LocalDateTime modifiedAt;
}

