package com.example.demo.mapper;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Student;
import com.example.demo.bean.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InformationMapper {

    @Select("select * from student where stuId = #{stuId}")
    List<Student> getStuInfo(String stuId);

    @Select("select * from teacher where teacherId = #{teacherId}")
    List<Teacher> getTeaInfo(String teacherId);
}
