package com.example.demo.mapper;

import com.example.demo.bean.Collection;
import com.example.demo.utils.courseCollection;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectionMapper {
    @Select("select courseName,information,teacherName from Course\n" +
            "left join Teacher on Teacher.teacherId = Course.teacherId\n" +
            "left join Sc on Sc.courseId = Course.courseId\n" +
            "left join Student on Student.stuId = Sc.stuId \n" +
            "where Student.stuId=#{stuId}")
    List<courseCollection> collectionCourse(@Param("stuId") String stuId);

    @Select("select * from Collection where stuId =#{stuId} and courseName = #{courseName}")
    List<Collection> getCollection(@Param("stuId") String stuId, @Param("courseName") String courseName);

    @Select("select * from Collection where description=#{description} and type = #{type} and courseName = #{courseName}")
    List<Collection> getSpecialCollection(@Param("description") String description, @Param("type") String type, @Param("courseName") String courseName);
}
