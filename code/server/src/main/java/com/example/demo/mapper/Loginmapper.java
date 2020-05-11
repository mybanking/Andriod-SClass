package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Loginmapper {
    @Select("select password from student where stuId = #{id}")
    String loginStu(@Param("id") String id);

    @Select("select password from teacher where teacherId =#{id}")
    String loginTea(@Param("id") String id);

    @Update("update student set password = 123456 where id =#{id}")
    int upStu(String id);

    @Update("update teacher set password = 123456 where id =#{id}")
    int upTea(String id);

    @Select("select email from teacher")
    String emailTea(String id);

    @Select("select email from student")
    String emailStu(String id);
}
