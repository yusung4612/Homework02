package com.sparta.homework.service;

import com.sparta.homework.dto.BoardRequestDto;
import com.sparta.homework.dto.BoardResponseDto;
import com.sparta.homework.entity.Board;
import com.sparta.homework.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;


////////////게시글 수정(update)
    @Transactional
    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason ="해당 아이디가 존재하지 않습니다." )
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board1 = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board1.update(requestDto);
        return board1.getId();
    }
    
    ///////////게시글 하나 조회
    @Transactional
    public BoardResponseDto findById (Long id) {
        Board entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id =" +id));
        return new BoardResponseDto(entity);
    }

////////////게시글 비밀번호 비교
public boolean checkPassword(Long id, BoardRequestDto requsetDto) {
    //reposity에있는 id를 찾아서 post에 넣기
    Board board = boardRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
    );
    //post.getPassword :기존에 있는 패스워드를 가져와서
    //check에 euns가 있으면 true, 없으면 false

    return board.getPassword().equals(requsetDto.getPassword());
    }
}
