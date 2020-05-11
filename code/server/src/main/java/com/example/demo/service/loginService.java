package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;

@Service
public interface loginService {
    JSONObject login(String id, String password);

}
