package com.example.demo.implement;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Paper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.service.CourseService;
import com.example.demo.utils.courseCollection;
import com.example.demo.utils.courseJson;
import com.example.demo.utils.courseSear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public JSONObject course(String id) {//查询指定学生课程
        JSONObject res = new JSONObject();
        List<courseJson> stuList = classMapper.Stulist(id);
        res.put("data",stuList);
        if(stuList!=null){
            res.put("check:","0");
        }
        else{
            res.put("check","error");
        }
        return res;

    }

    @Override
    public JSONObject coursesearch(String stuId) {
        JSONObject res = new JSONObject();
        List<courseSear> courseSears = classMapper.Sear(stuId);
        res.put("data",courseSears);
        if(courseSears!=null){
            res.put("check:","0");
        }
        else{
            res.put("check","error");
        }
        return res;
    }



}
