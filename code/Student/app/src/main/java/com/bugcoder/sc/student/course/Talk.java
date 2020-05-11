package com.bugcoder.sc.student.course;



public class Talk {
    private  String stuId;
    private  String stuName;
    private String question;
    private String date;
    private String good;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Talk(String stuId, String stuName, String question, String date, String good, String name) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.question = question;
        this.date = date;
        this.good = good;
        this.name = name;
    }



    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }


}
