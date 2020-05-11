package com.example.demo.implement;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Question;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public String insert(String courseId,String que) {
        String description = JSONObject.parseObject(que).getJSONObject("data").getString("description");
        String answer = JSONObject.parseObject(que).getString("data");
        Question question = new Question(questionMapper.findId()+1,description,answer,courseId);
        int a = questionMapper.insertQue(question);
        if (a>0){
            return "ok";
        }
        return "cannot";





    }
}
