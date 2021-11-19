package com.sparta.weeklytestspring.service;

import com.sparta.weeklytestspring.domain.Article;
import com.sparta.weeklytestspring.dto.ArticleRequestDto;
import com.sparta.weeklytestspring.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long update(Long id, ArticleRequestDto requestDto) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("해당 아이디가 존재하지 않습니다.")
        );
        article.update(requestDto);
        return article.getId();
    }
}
