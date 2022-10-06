package com.sparta.homework.controller;
import com.sparta.homework.dto.BoardRequestDto;
import com.sparta.homework.dto.BoardResponseDto;

import com.sparta.homework.entity.Board;
import com.sparta.homework.repository.BoardRepository;

import com.sparta.homework.service.BoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController  // json으로 data를 주고받음을 선언
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    //////////////////게시글 목록 조회
    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        LocalDateTime start = LocalDateTime.now().minusDays(1); // LocalDateTime start
        LocalDateTime end = LocalDateTime.now(); // LocalDateTime end
        return boardRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start,end);
    }

    ////////////////////게시글 작성
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
           return boardRepository.save(board);
    }
    //////////// 게시글 하나만 조회하기
    @GetMapping("/api/boards/{id}")
    public BoardResponseDto findById(@PathVariable Long id) {
        return boardService.findById(id);
    }
    ///////////게시글 수정
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id , @RequestBody BoardRequestDto requestDto){
         boardService.update(id,requestDto);
         return id;
    }
//    ////////////게시글 삭제
    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
    boardRepository.deleteById(id);
    return id;
}
    /////////////비밀번호 확인
    @PostMapping("/api/boards/{id}")
    public boolean checkPassword(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        //dto에 있는 패스워드를 boardservice로 반환
        return boardService.checkPassword(id, requestDto);
    }
//    @PostMapping("/api/boards/{id}")
//    public Boolean passwordCheck(@PathVariable Long id, @RequestBody BoardCheckRequestDto requestDto) {
//        return boardService.passwordCheck(id, requestDto);
//    }
}
