package com.sparta.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.homework.dto.BoardRequestDto;
import com.sparta.homework.dto.BoardResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false) // null 값 오류가 안뜨게끔 false
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    public Board( String title, String writer,String password,String content) {
        this.title =title;
        this.writer = writer;
        this.password = password;
        this.content = content;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }


//
//    public Board(BoardResponseDto responseDto) {
//        this.title = responseDto.getTitle();
//        this.writer = responseDto.getWriter();
//        this.id = responseDto.getId();
//        this.content = responseDto.getContent();
//    }



    //게시글 생성
//    public  void save(BoardRequestDto requestDto) {  //BoardRequestDto는 Board 객체에 변경하거나 새롭게 생성할 데이터를 담는 그릇
//        this.title = requestDto.getTitle();
//        this.writer = requestDto.getWriter();
//        this.password = requestDto.getPassword();
//        this.content = requestDto.getContent();
//
//    }



    //게시글 수정
    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    //게시글 삭제
    public void delete(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
    }
}
