package com.example.demo.bean;



public class Teacher  implements ITalker {

  private String teacherId;
  private String teacherName;
  private String answer;

  public Teacher(String teacherId, String teacherName,String answer) {
    this.teacherId = teacherId;
    this.teacherName = teacherName;
    this.answer=answer;
  }
  @Override
  public String sendQuestion() {
     return "老师："+teacherId+" " +teacherName+":"+answer;
  }


}
