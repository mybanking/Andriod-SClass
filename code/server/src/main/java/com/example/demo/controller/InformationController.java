package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {
    @Autowired
    private InformationService informationService;

    @RequestMapping("/stu/information")
    public JSONObject infostu(){
        return informationService.getStuInfo("1");
    }

    @RequestMapping("/teacher/information")
    public JSONObject infotea(){
        return informationService.getTeaInfo("t1");
    }
}
