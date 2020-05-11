package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface InformationService {
    JSONObject getStuInfo(String stuId);

    JSONObject getTeaInfo(String teacherId);
}
