package com.example.demo.bean;




public class Sc {

  private String stuId;
  private String courseId;
  private long currentPoint;
  private long totalPoint;
  private long being;
  private long totalbeing;
  private String myProgress;


  public String getStuId() {
    return stuId;
  }

  public void setStuId(String stuId) {
    this.stuId = stuId;
  }


  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }


  public long getCurrentPoint() {
    return currentPoint;
  }

  public void setCurrentPoint(long currentPoint) {
    this.currentPoint = currentPoint;
  }


  public long getTotalPoint() {
    return totalPoint;
  }

  public void setTotalPoint(long totalPoint) {
    this.totalPoint = totalPoint;
  }


  public long getBeing() {
    return being;
  }

  public void setBeing(long being) {
    this.being = being;
  }


  public long getTotalbeing() {
    return totalbeing;
  }

  public void setTotalbeing(long totalbeing) {
    this.totalbeing = totalbeing;
  }


  public String getMyProgress() {
    return myProgress;
  }

  public void setMyProgress(String myProgress) {
    this.myProgress = myProgress;
  }

}
