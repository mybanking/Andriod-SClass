package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMapper questionMapper;

    public int point() {
        int []numbers = {40,80,100};
        Random random = new Random();
        int index = random.nextInt(numbers.length);
        return (numbers[index]);
    }

    @RequestMapping("/stu/sendAnswer")
    public String receiveAnswer(@RequestBody String json){
            System.out.println("3333333333333333333333333333333333333333"+json);
//        String tea = "{\"data\":{\"description\":\"64365\",\"options\":\"A:3465346,B:34653465,C:346534634,D:536436436\",\"answer\":\"C\"},\"check\":1}";
//        String stuAn = "{\"data\":{\"answer\":\"B\"},\"check\":0}";
            String tea = CourseController.que;
            String stuAn = json;
            // System.out.println(json);
            JSONObject temp1 = JSONObject.parseObject(tea);

        JSONObject stu_temp = JSONObject.parseObject(stuAn);
        if(temp1.getString("check").equals(0)) {
            String temp1_stu = stu_temp.getString("data");
            String temp2 = temp1.getString("data");
            JSONObject temp3 = JSONObject.parseObject(temp2);
            String answer = temp3.getString("answer");
            System.out.println("1" + answer);
            JSONObject stu_ob = JSONObject.parseObject(temp1_stu);
            String stuAnswer = stu_ob.getString("answer");
            System.out.println("stu" + stuAnswer);
            JSONObject res = new JSONObject();
            if (stuAnswer.equals(answer)) {
                return "80";
            } else {
                return "80";
            }

        }
        else{
            int point = point();
            System.out.println(point);
            return "80";
        }
    }
}
