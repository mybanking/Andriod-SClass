package com.example.demo.bean;



public class Discussion {


  public String addQuestion(ITalker talker,String courseName, String date){
      System.out.println(talker.sendQuestion());
      return talker.sendQuestion()+"---"+courseName+"---"+date;
  }

}
