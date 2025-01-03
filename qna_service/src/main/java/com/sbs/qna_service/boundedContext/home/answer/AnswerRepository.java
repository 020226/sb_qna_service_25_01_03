package com.sbs.qna_service.boundedContext.home.answer;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

  @Modifying // INSERT, UPDATE, DELETE와 같은 데이터 변경 작업에서만 사용
  // nativeQuery = true 여야 MySQL 쿼리 사용이 가능
  @Transactional
  @Query(value = "ALTER TABLE answer AUTO_INCREMENT = 1", nativeQuery = true)
  void clearAutoIncrement();
}
