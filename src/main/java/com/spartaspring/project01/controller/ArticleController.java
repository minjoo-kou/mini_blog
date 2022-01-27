package com.spartaspring.project01.controller;

import com.spartaspring.project01.domain.Article;
import com.spartaspring.project01.domain.ArticleRepository;
import com.spartaspring.project01.domain.ArticleRequestDto;
import com.spartaspring.project01.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController

public class ArticleController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @GetMapping("/api/articles")
    public List<Article> getArticles(ArticleRequestDto requestDto) {
        return articleRepository.findAllByOrderByCreatedDateDesc();
    }

    @GetMapping("/api/articles/{id}")
    public List<Article> showArticles(@PathVariable String id){
        long longId = Long.parseLong(id);
        return articleRepository.findAllById(Collections.singleton(longId));
    }

//    @RequestMapping("/write")
//    public String writepost(){
//        return "write.html";
//    }

//    @RequestMapping("/api/articles")
//    public String wpost(){
//        return "index.html";
//    }

    @PostMapping("/api/articles")
    public Article createArticle(@RequestBody ArticleRequestDto requestDto){
        Article article = new Article(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return articleRepository.save(article);
    }

    @PutMapping("/api/articles/{id}")
    public Long updateArticle(@PathVariable Long id, @RequestBody ArticleRequestDto requestDto) {
        return articleService.update(id, requestDto);
    }

    @DeleteMapping("/api/articles/{id}")
    public Long deleteCourse(@PathVariable Long id){
        articleRepository.deleteById(id);
        return id;
    }

}
