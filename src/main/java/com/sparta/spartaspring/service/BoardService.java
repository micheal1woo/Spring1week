package com.sparta.spartaspring.service;

import com.sparta.spartaspring.dto.BoardDeleteDto;
import com.sparta.spartaspring.dto.BoardRequestDto;
import com.sparta.spartaspring.dto.BoardResponseDto;
import com.sparta.spartaspring.entity.Board;
import com.sparta.spartaspring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;
    @Transactional
    public Board creatBoard(BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        repository.save(board);
        return board;
    }

    @Transactional(readOnly = true)
    public List<Board> getPosts(){
        return repository.findAllByOrderByModifiedAtDesc();
    }

    public Board getPost(Long id){
        return repository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    @Transactional
    public BoardResponseDto update(Long id, BoardRequestDto requestDto){
        Board board = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아디이가 존재하지 않습니다.")
        );
        BoardResponseDto responseDto = new BoardResponseDto(board);
        if (requestDto.getPassword().equals(board.getPassword())){
           board.update(requestDto);
        }
        return responseDto;
    }

    @Transactional
    public BoardDeleteDto deleteDto(Long id, BoardRequestDto requestDto) {
        BoardDeleteDto b = new BoardDeleteDto();
        Board board = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (requestDto.getPassword().equals(board.getPassword())) {
            repository.deleteById(id);
            b.boardDeleteDto("삭제 완료");
        }else {
            b.boardDeleteDto("비밀번호가 다릅니다.");

        } return b;

    }
}
