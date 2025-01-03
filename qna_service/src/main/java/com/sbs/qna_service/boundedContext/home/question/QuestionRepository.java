package com.sbs.qna_service.boundedContext.home.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
  // interface로 만들면 @Repository가 생략되어 있음
  // JpaRepository<Question, Integer> -> JpaRepository<엔티티 클래스 이름, id 타입>

  Question findBySubject(String subject);

  Question findBySubjectAndContent(String subject, String content);

  List<Question> findBySubjectLike(String subject);
}
