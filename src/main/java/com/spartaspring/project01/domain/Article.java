package com.spartaspring.project01.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import  javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter

public class Article extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

//    @Column(nullable = false)
//    private String date;
    //timestamp 값 불러와서 잘 만져보면 될 듯

    @Column(nullable = false)
    private String context;

    @CreatedDate
    private String createdDate;

    @LastModifiedDate
    private String lastModifiedDate;


    //생성자
    public Article(String title, String writer, String context) {
        this.title = title;
        this.writer = writer;
        this.context = context;
    }

    public Article(ArticleRequestDto requestDto) {
    this.title = requestDto.getTitle();
    this.writer = requestDto.getWriter();
    //date는 고민 필요
//    his.date = requestDto.getDate();
    this.context = requestDto.getContext();
    }

    public void update(ArticleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.context = requestDto.getContext();
    }
}