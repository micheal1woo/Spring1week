package com.sparta.spartaspring.controller;

import com.sparta.spartaspring.dto.BoardDeleteDto;
import com.sparta.spartaspring.dto.BoardRequestDto;
import com.sparta.spartaspring.dto.BoardResponseDto;
import com.sparta.spartaspring.entity.Board;
import com.sparta.spartaspring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;
    @PostMapping("/api/post")
    public Board creatBoard(@RequestBody BoardRequestDto requestDto){
        return boardService.creatBoard(requestDto);
    }
    @GetMapping("/api/posts")
    public List<Board> getPosts(){
        return boardService.getPosts();
    }
    @GetMapping("/api/post/{id}")
    public Board getPost(@PathVariable Long id){
        return boardService.getPost(id);
    }

    @PutMapping("/api/post/{id}")
    public BoardResponseDto updateMemo(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) throws Exception {
        return boardService.update(id, requestDto);
    }
    @DeleteMapping("/api/post/{id}")
    public BoardDeleteDto deletePost(@PathVariable Long id, @RequestBody BoardRequestDto requestsDto) throws Exception {
        return boardService.deleteDto(id, requestsDto);
    }
}
