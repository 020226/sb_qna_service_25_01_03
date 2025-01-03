package com.sbs.qna_service.boundedContext.home.answer;

import com.sbs.qna_service.boundedContext.home.question.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(columnDefinition = "TEXT")
  private String content;
  private LocalDateTime createDate;
  private Question question;
}
