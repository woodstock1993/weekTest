package com.sparta.weeklytestspring.controller;

import com.sparta.weeklytestspring.domain.Article;
import com.sparta.weeklytestspring.dto.ArticleRequestDto;
import com.sparta.weeklytestspring.repository.ArticleRepository;
import com.sparta.weeklytestspring.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @PostMapping("/articles")
    public String setArticle(@RequestBody ArticleRequestDto requestDto){
        Article article = new Article(requestDto);
        articleRepository.save(article);
        return "success";
    }

    @GetMapping("/articles/")
    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

}
