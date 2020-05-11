package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.Loginmapper;
import com.example.demo.service.MailService;
import com.example.demo.service.loginService;
import netscape.javascript.JSObject;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class LoginController {
    public String DMcontent="";
    @Autowired
    private loginService loginService;

    @Autowired
    private MailService mailService;

    @Autowired
    private Loginmapper loginmapper;

    @RequestMapping("/hello")
    public String hello(){
        return "ok";
    }

    @RequestMapping("/login")
    public JSONObject login(@RequestBody String json){
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        //System.out.println(loginService.login(jsonObject.getString("Id"),jsonObject.getString("password")));
        return loginService.login(jsonObject.getString("Id"),jsonObject.getString("password"));
    }
    @RequestMapping("/DM")
    public JSONObject DM(@RequestBody String json){
        JSONObject res = new JSONObject();
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject.getString("content"));
        DMcontent=jsonObject.getString("content");
        res.put("check","true");
        return res;
    }
    @RequestMapping("/loadDM")
    public JSONObject loadDM(@RequestBody String json){
        JSONObject res = new JSONObject();


        if(DMcontent.equals("")){
            res.put("check","false");
            return res;}
        else {
            res.put("check","true");
            res.put("content",DMcontent);
            return res;}


    }
    @RequestMapping("/message")
    public JSONObject message(@RequestBody String json){
        JSONObject res = new JSONObject();
        JSONObject jsonObject = JSON.parseObject(json);

        int codeLength = 6;
        String code = "";
        Random random=new Random();
        for (int i = 0;i<codeLength;i++){
            code += String.valueOf(random.nextInt(10));
        }

        if(loginmapper.loginStu(jsonObject.getString("id"))!=null){
            mailService.sendSimpleMail(loginmapper.emailStu(jsonObject.getString("id")),"请修改您的密码","123456");
            loginmapper.upStu(jsonObject.getString("id"));
        }else if(loginmapper.loginTea(jsonObject.getString("id"))!=null){
            mailService.sendSimpleMail(loginmapper.emailTea(jsonObject.getString("id")),"请修改您的密码","123456");
            loginmapper.upTea(jsonObject.getString("id"));
        }
        else{
            res.put("check","please register");
        }
        res.put("code",code);
        return res;
    }


}
