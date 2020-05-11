package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaperController {

    @RequestMapping("/stu/paper/sendAnswer")//判断正确率 answer 先调出试卷 post请求
    public String sendAnswer(@RequestBody String json){
        System.out.println(json);
        return "60";
    }


    @RequestMapping("/stu/paper/getPaper")
    public String getPaper(){//返回
        String req = "{\"data\":{\"paperName\":\"Test A\",\"content\":[{\"description\":\"456745\",\"options\":\"A:4567,B:235,C:2345,D:235\",\"answer\":\"A\"},{\"description\":\"asgfasdf\",\"options\":\"A:asdfadsf,B:werterwt,C:wertwert,D:erytrtey\",\"answer\":\"C\"},{\"description\":\"34564365 wertewrt\",\"options\":\"A:wertwert 2353 wert,B:wetwert wertwert,C:435254 2345235,D:wertwert  2345345\",\"answer\":\"D\"}]},\"check\":1}";
        return req;
    }



}

