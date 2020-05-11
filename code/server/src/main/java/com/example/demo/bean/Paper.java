package com.example.demo.bean;




public class Paper {

  private String papaerId;
  private String teacherId;
  private String courseId;
  private String content;

  public Paper(String paperId, String teacherId, String courseId, String content) {
  }


  public String getPapaerId() {
    return papaerId;
  }

  public void setPapaerId(String papaerId) {
    this.papaerId = papaerId;
  }


  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }


  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
