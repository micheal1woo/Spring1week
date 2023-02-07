package com.sparta.spartaspring.dto;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class BoardRequestDto {
    private String name;
    private String contents;
    private String title;
    private String password;

}
