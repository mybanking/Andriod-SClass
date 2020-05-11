package com.example.demo.implement;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.Loginmapper;
import com.example.demo.service.loginService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginImpl implements loginService {

    @Autowired
    private Loginmapper mapper;

    @Override
    public JSONObject login(String id, String password) {
        JSONObject res = new JSONObject();
        String findStuPassword = mapper.loginStu(id);
        String findTeaPassword = mapper.loginTea(id);
        if (findStuPassword!=null){
            res.put("check","stu");
            return res;
        }else if(findTeaPassword!=null){
            res.put("check","tea");
            return res;
        }else{
            res.put("check","no one");
            return res;
        }

    }
}
