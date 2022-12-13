package com.example.FirstProject.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //해당 어노테이션을 붙여야 DB가 해당 객체를 인식 가능!
@AllArgsConstructor
@ToString
public class Article {

    @Id //대표값을 지정! 주민등록번호 같은
    @GeneratedValue // 1, 2, 3, ... 자동 생성 어노테이션!
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

}
