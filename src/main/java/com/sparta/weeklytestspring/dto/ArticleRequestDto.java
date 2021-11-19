package com.sparta.weeklytestspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class ArticleRequestDto {
    private String title;
    private String content;
}
