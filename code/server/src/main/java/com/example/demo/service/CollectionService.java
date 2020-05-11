package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface CollectionService {

    JSONObject collection(String stuId);

    JSONObject getCollection(String stuId,String courseName);

    JSONObject getSpecialCollection(String description,String type,String courseName);
}
