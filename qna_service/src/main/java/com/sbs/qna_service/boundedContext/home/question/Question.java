package com.sbs.qna_service.boundedContext.home.question;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity // 스프링부트가 Question를 Entity로 본다.
public class Question {
  @Id // PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
  private Integer id; // INT id
  @Column(length = 200) // VARCHAR(200)
  private String subject;
  @Column(columnDefinition = "TEXT") // TEXT
  private String content;
  private LocalDateTime createDate; // DATETIME

}
