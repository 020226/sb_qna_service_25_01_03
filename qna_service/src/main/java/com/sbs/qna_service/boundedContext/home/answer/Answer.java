package com.sbs.qna_service.boundedContext.home.answer;

import com.sbs.qna_service.boundedContext.home.question.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(columnDefinition = "TEXT")
  private String content;
  private LocalDateTime createDate;

  @ManyToOne
  private Question question;
}
