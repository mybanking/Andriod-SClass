package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    JSONObject course(String id);

    JSONObject coursesearch(String stuId);


}
