package com.example.demo.implement;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Course;
import com.example.demo.bean.Discussion;
import com.example.demo.bean.Student;
import com.example.demo.bean.Talk;
import com.example.demo.mapper.DiscussMapper;
import com.example.demo.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussImpl implements DiscussService {
    @Autowired
    private DiscussMapper discussMapper;


    @Override
    public JSONObject sendQuestion(String stuId,String stuName,String question,String date,String courseName) {

        JSONObject res = new JSONObject();

        Student student=new Student(stuId,stuName,question);
        Discussion discuss = new Discussion();
        discuss.addQuestion(student,courseName,date);

        int a = discussMapper.sendQueInt(discuss);
        if(a>=0){
            res.put("check",true);
            return res;
        }else{
            res.put("check",false);
            return res;
        }
    }

    @Override
    public JSONObject sttdiscuss(String tsuId, String tsuName, String assess, String Tdate, String stuId, String date, String courseName) {
        JSONObject res = new JSONObject();

        Talk talk = new Talk();
        talk.setTsuId(tsuId);
        talk.setStuId(stuId);
        talk.setTsuName(tsuName);
        talk.setAssess(assess);
        talk.setTdate(Tdate);
        talk.setDate(date);
        talk.setCourseName(courseName);

        int a = discussMapper.sttdis(talk);
        if(a>=0){
            res.put("check",true);
            return res;
        }else{
            res.put("check",false);
            return res;
        }


    }

    @Override//加载
    public JSONObject enterQues(String courseName) {
        JSONObject res = new JSONObject();
        List<Discussion> discussions = discussMapper.findByCourseId(courseName);
        if (res!=null){
            res.put("data",discussions);

        }
        else {
            res.put("check",false);
        }
        return res;

    }

    @Override
    public JSONObject enterDiss(String courseName, String stuId, String date) {
        JSONObject res = new JSONObject();
        List<Talk> talks = discussMapper.findBystu(courseName,stuId,date);
        if (res!=null){
            res.put("data",talks);

        }
        else {
            res.put("check",false);
        }
        return res;
    }

    @Override//更新
    public JSONObject update(String totalgood,String stuId,String courseName,String date) {
        discussMapper.update(totalgood,stuId,courseName,date);
        JSONObject res = new JSONObject();
        res.put("message","update");
        return res;
    }
}
