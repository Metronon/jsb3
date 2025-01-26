package com.ll.sbb3.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 설정
    private Integer id;

    @Column(length = 200) // 제목 200자 제한
    private String subject;

    @Column(columnDefinition = "TEXT") // 본문 TEXT 형식
    private String content;

    private LocalDateTime createDate; // 생성일시 LocalDateTime (밀리초까지 표시)

    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // CascadeType Remove 설정으로 Question 삭제시 AnswerList 전부 삭제
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;
}
