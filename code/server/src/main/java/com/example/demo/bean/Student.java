package com.example.demo.bean;

public class Student {

  private String stuId;
  private String stuName;
  private String question;
  public Student(String stuId, String stuName,String question) {
    this.stuId = stuId;
    this.stuName = stuName;
    this.question=question;
  }

  public String sendQuestion(){
    return stuId+" " +stuName+":"+question;
  }

}
