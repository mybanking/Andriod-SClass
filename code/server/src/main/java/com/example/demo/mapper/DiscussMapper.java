package com.example.demo.mapper;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Discussion;
import com.example.demo.bean.Talk;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DiscussMapper {
    @Insert("insert into discussion values(#{stuId},#{stuName},#{question},#{date},#{courseName},#{totalgood})")
    int sendQueInt(Discussion discuss);

    @Insert("insert into talk values(#{tsuId},#{tsuName},#{assess},#{tdate},#{stuId},#{date},#{courseName})")
    int sttdis(Talk talk);

    @Select("select * from discussion \n" +
            "left join  Course on Course.courseName = discussion.courseName where discussion.courseName = #{courseName};")
    List<Discussion> findByCourseId(@Param("courseName") String courseName);

    @Select("select * from talk where courseName = #{courseName} and stuId = #{stuId} and date = #{date}")
    List<Talk> findBystu(String courseName, String stuId, String date);

    @Update("update discussion set totalgood = #{totalgood} where stuId =#{stuId} and courseName = #{courseName} and date = #{date}")
    void update(@Param("totalgood") String totalgood,@Param("stuId") String stuId,@Param("courseName") String courseName,@Param("date") String date);
}
