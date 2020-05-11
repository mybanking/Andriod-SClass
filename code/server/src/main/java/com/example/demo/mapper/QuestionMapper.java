package com.example.demo.mapper;

import com.example.demo.bean.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface QuestionMapper {
    @Insert("insert into Question values(#{QuestionId},#{description},#{answer},#{courseId})")
    int insertQue(Question question);

    @Select("select MAX(QuestionId) from Question;")
    int findId();

    @Select("select answer from Question where description = #{description}")
    String getAnswer(@Param("description") String description);
}
