package com.spartaspring.project01.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class ArticleRequestDto {
    private final String title;
    private final String writer;
    private final String context;
//    private final String date;//더 추가해야할까? date, id 등?
}
