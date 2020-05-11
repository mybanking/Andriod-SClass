package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscussController {
    @Autowired
    private DiscussService discussService;

    @RequestMapping("/stu/dis/sendQuestion")//发送讨论区问题
    public JSONObject sendQuestion(@RequestBody String json){
        System.out.println(json);
        JSONObject res = JSONObject.parseObject(json);
        if(res.getString("signal").equals("update")) {
            return discussService.update(res.getString("totalgood"),res.getString("stuId"),res.getString("courseName"),res.getString("date"));
        }
        else {
            return discussService.sendQuestion(res.getString("stuId"), res.getString("stuName"), res.getString("question"), res.getString("date"), res.getString("courseName"));
        }

    }

    @RequestMapping("/stu/dis/sttdiscuss")//学生开始讨论
    public JSONObject sttdiscuss(@RequestBody String json){
        System.out.println(json);

        JSONObject res = JSONObject.parseObject(json);
        return discussService.sttdiscuss(res.getString("tstuId"),res.getString("tsuName"),res.getString("assess"),res.getString("tdate"),res.getString("stuId"),res.getString("date"),res.getString("courseName"));
    }

    @RequestMapping("/stu/dis/enterQues")//学生进入问题区
    public JSONObject enterQues(@RequestBody String json){
        System.out.println(json);
        JSONObject res = JSONObject.parseObject(json);
        System.out.println(discussService.enterQues(res.getString("courseName")));
        return discussService.enterQues(res.getString("courseName"));
    }

    @RequestMapping("/stu/dis/enterDiss")//学生加载diss
    public JSONObject enterDiss(@RequestBody String json){
        System.out.println(json);
        JSONObject res = JSONObject.parseObject(json);
        return discussService.enterDiss(res.getString("courseName"),res.getString("stuId"),res.getString("date"));
    }

//    @RequestMapping("")//计算点赞数
//    public JSONObject count(@RequestBody String json){
//        System.out.println(json);
//
//    }
//

}
