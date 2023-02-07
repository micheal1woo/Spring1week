package com.sparta.spartaspring.dto;

import lombok.Getter;

@Getter
public class BoardDeleteDto {
    private String message;
    public void boardDeleteDto(String message){
        this.message = message;
    }
}
