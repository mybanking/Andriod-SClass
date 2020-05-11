package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface DiscussService {
    JSONObject sendQuestion(String stuId,String stuName,String question,String date,String courseName);

    JSONObject sttdiscuss(String tsuId,String tsuName, String assess, String Tdate,String stuId,String date,String courseId);

    JSONObject enterQues(String courseName);

    JSONObject enterDiss(String courseName, String stuId, String date);

    JSONObject update(String totalgood, String stuId, String courseName, String date);
}
