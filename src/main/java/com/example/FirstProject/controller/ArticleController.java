package com.example.FirstProject.controller;

import com.example.FirstProject.DTO.ArticleForm;
import com.example.FirstProject.Repository.ArticleRepository;
import com.example.FirstProject.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {

    //Spring Boot가 자체적으로 객체를 생성했기에 객체 생성 필요 X\
    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm){
        //System.out.println(articleForm.toString()); -> 로깅기능으로 대체!
        log.info(articleForm.toString());
        //1. DTO를 변환! Entity로 변환!
        Article article = articleForm.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());

        //2. Repository에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "";
    }
}
