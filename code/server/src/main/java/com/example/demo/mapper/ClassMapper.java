package com.example.demo.mapper;

import com.example.demo.bean.Paper;
import com.example.demo.utils.courseCollection;
import com.example.demo.utils.courseJson;
import com.example.demo.utils.courseSear;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassMapper {
    @Select("select * from Course\n" +
            "left join Teacher on Teacher.teacherId = Course.teacherId\n" +
            "left join Sc on Sc.courseId = Course.courseId\n" +
            "left join Student on Student.stuId = Sc.stuId \n" +
            "where Student.stuId=#{id};")
    List<courseJson> Stulist(@Param("id") String id);

    @Select("select * from Course\n" +
            "left join teacher on teacher.teacherId = Course.teacherId \n" +
            "left join Sc on Sc.courseId = Course.courseId where stuId = #{stuId};")
    List<courseSear> Sear(@Param("stuId") String stuId);


}
