package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.service.CollectionService;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping("/stu/getCourse")//发送学生Id返回course
    public JSONObject Course(){
        return collectionService.collection("1");
    }

    @RequestMapping("/stu/getcollection")
    public JSONObject getCollection(){
        return collectionService.getCollection("1","1");
    }

    @RequestMapping("/stu/getcollection/content")
    public JSONObject getSpecialCollection(){
      return  collectionService.getSpecialCollection("1","1","1");
    }
}
