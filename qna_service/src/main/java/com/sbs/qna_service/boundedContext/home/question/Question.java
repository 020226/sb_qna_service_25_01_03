package com.sbs.qna_service.boundedContext.home.question;

import com.sbs.qna_service.boundedContext.home.answer.Answer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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

  // @OneToMany 자바세상에서의 편의를 위해 필드 생성
  // 이 녀석은 실에 DB 테이블에 칼럼이 생성되지 않는다.
  // DB는 리스트나 배열을 만들 수 없다.
  // answerList : 만들어도 되고 만들지 않아도 된다.
  // 다만 만들면 해당 객체(질문객체)에서 관련된 답변을 찾을 때 편하다.
  // CascadeType.REMOVE : 질문이 삭제되면 답변도 같이 삭제된다.
  @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
  private List<Answer> answerList = new ArrayList<>(); // nullPointException 방지 초기화

  // 외부에서 answerList 필드에 접근하는 것을 차단 = 캡슐화
  public void addAnswer(Answer a) {
    a.setQuestion(this);
    answerList.add(a);
  }
}
