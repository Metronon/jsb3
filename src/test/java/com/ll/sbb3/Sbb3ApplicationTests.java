package com.ll.sbb3;

import com.ll.sbb3.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        for (int i = 0; i < 300; i++) {
            String subject = String.format("[%03d]번째 테스트 제목입니다.", i);
            String content = String.format("[%03d]번째 테스트 본문입니다.", i);
            this.questionService.create(subject, content);
        }
    }
}