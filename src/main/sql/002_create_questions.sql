CREATE TABLE interview_question (
  id          INTEGER NOT NULL,
  userId      INTEGER,
  interviewId INTEGER,
  question    TEXT,
  PRIMARY KEY (id)
);

CREATE SEQUENCE interview_question_id START WITH 1;