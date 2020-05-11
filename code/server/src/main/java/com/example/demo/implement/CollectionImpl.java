package com.example.demo.implement;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Collection;
import com.example.demo.mapper.CollectionMapper;
import com.example.demo.service.CollectionService;
import com.example.demo.utils.courseCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public JSONObject collection(String stuId) {
        System.out.println(stuId);
        JSONObject res = new JSONObject();
        List<courseCollection> courseCollections = collectionMapper.collectionCourse(stuId);
        res.put("data",courseCollections);
        res.put("check","1");
        return res;

    }

    @Override
    public JSONObject getCollection(String stuId, String courseName) {
        JSONObject res = new JSONObject();
        List<Collection> collections = collectionMapper.getCollection(stuId,courseName);
        res.put("data",collections);
        res.put("check","1");
        return res;

    }

    @Override
    public JSONObject getSpecialCollection(String description, String type, String courseName) {
        JSONObject res = new JSONObject();
        List<Collection> collections = collectionMapper.getSpecialCollection(description,type,courseName);
        res.put("data",collections);
        res.put("check","1");
        return res;
    }
}
