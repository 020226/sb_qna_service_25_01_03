# DB 삭제, 생성, 선택
DROP DATABASE IF EXISTS qna_service;
CREATE DATABASE qna_service;
USE qna_service;

// 외래키 제약 비활성화
SET FOREIGN_KEY_CHECKS = 0;
// TRUNCATE 로 초기화한 데이터는 데이터 추가시 1번 번호로 시작한다.
TRUNCATE answer;
TRUNCATE question;
// 외래키 제약 활성화
SET FOREIGN_KEY_CHECKS = 1;