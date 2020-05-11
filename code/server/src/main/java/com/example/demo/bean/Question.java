package com.example.demo.bean;

public class Question {

  private int QuestionId;
  private String description;
  private String answer;
  private String courseId;

  public int getQuestionId() {
    return QuestionId;
  }

  public void setQuestionId(int questionId) {
    QuestionId = questionId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public Question(int QuestionId, String description, String answer, String courseId) {
    this.QuestionId = QuestionId;
    this.description = description;
    this.answer = answer;
    this.courseId = courseId;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }



}
