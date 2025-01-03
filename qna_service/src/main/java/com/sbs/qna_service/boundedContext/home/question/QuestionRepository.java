package com.sbs.qna_service.boundedContext.home.question;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
  // interface로 만들면 @Repository가 생략되어 있음
  // JpaRepository<Question, Integer> -> JpaRepository<엔티티 클래스 이름, id 타입>

  Question findBySubject(String subject);

  Question findBySubjectAndContent(String subject, String content);

  List<Question> findBySubjectLike(String subject);

  // 형태 암기
  @Modifying // INSERT, UPDATE, DELETE와 같은 데이터 변경 작업에서만 사용
  // nativeQuery = true 여야 MySQL 쿼리 사용이 가능
  @Transactional
  @Query(value = "ALTER TABLE question AUTO_INCREMENT = 1", nativeQuery = true)
  void clearAutoIncrement();
}
