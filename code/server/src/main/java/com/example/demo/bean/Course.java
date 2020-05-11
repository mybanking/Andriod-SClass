package com.example.demo.bean;


public class Course {

  private String courseId;
  private String teacherId;
  private String courseName;
  private String information;
  private java.sql.Timestamp date;
  private String major;
  private long taskNum;



  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }


  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }


  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }


  public long getTaskNum() {
    return taskNum;
  }

  public void setTaskNum(long taskNum) {
    this.taskNum = taskNum;
  }

}
