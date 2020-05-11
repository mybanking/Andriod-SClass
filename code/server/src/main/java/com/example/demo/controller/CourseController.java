package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.TreeSet;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
//
//    @RequestMapping("/test")//返回指定学生id课程
//    public String Stucourse(){
//        String req = "{\"data\":{\"paperName\":\"Test A\",\"content\":[{\"description\":\"456745\",\"options\":\"A:4567,B:235,C:2345,D:235\",\"answer\":\"A\"},{\"description\":\"asgfasdf\",\"options\":\"A:asdfadsf,B:werterwt,C:wertwert,D:erytrtey\",\"answer\":\"C\"},{\"description\":\"34564365 wertewrt\",\"options\":\"A:wertwert 2353 wert,B:wetwert wertwert,C:435254 2345235,D:wertwert  2345345\",\"answer\":\"D\"}]},\"check\":1}";
//        return req;
//    }
//
//    @RequestMapping("/test1")//返回指定学生id课程
//    public JSONObject Stucourse(@RequestBody String json){
//        System.out.println(json);
//        JSONObject jsonObject = JSONObject.parseObject(json);
//        return courseService.course(jsonObject.getString("studentId"));
//
//    }
//
//    @RequestMapping("/test2/{id}")//返回指定学生id课程
//    public JSONObject Stucourse1(@PathVariable("id") String id){
//
//        return courseService.course(id);
//
//    }

    @RequestMapping("/stu/course/search")
    public JSONObject stucourse(@RequestBody String json){
        System.out.println(json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(courseService.coursesearch(jsonObject.getString("stuId")));
        return courseService.coursesearch(jsonObject.getString("stuId"));
    }

    double x=39.952045;
    double y=116.344104;
    public String signcontent="false";

    Set<String> signed = new TreeSet<String>();
    @RequestMapping("/stu/course/teacher/sign")
    //public JSONObject stucourseteachersign(@RequestBody String json){
        public JSONObject stucourseteachersign(@RequestBody String json) throws InterruptedException {
        JSONObject jsonObject = JSONObject.parseObject(json);
       // System.out.println("teacher"+json);
        signcontent= "true";
        //留存
        x = jsonObject.getDouble("x");
        y = jsonObject.getDouble("y");

        JSONObject jsonReturn = new JSONObject();
//        System.out.println("0s "+signcontent);
        Thread.sleep(4000);
        signcontent= "false";
       // System.out.println("ns "+signcontent);
        jsonReturn.put("list",signed);
        //System.out.println(jsonReturn);
        return jsonReturn;

    }


    @RequestMapping("/stu/course/student/sign")
    public JSONObject stucoursestudentsign(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);

        double stu_x = jsonObject.getDouble("x");
        double stu_y = jsonObject.getDouble("y");
        String check = jsonObject.getString("check");
       // System.out.println(x+" "+y);

        double dis2 = Math.pow(stu_x-x,2)+Math.pow(stu_y-y,2);
        double dis = Math.pow(dis2,0.5);
//        System.out.println(dis);

        JSONObject jsonReturn = new JSONObject();
        if(signcontent.equals("true")){
            if(dis<1000){
               // System.out.println("==============距离合适================");
                if(check.equals("true")){
                   // System.out.println("NJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"+jsonObject.getString("stu_id"));
                    signed.add(jsonObject.getString("stu_id"));
                }
            }

         //   System.out.println("=！！！！！！！！！！！！！！！！！！！！！距离不合适================");


            jsonReturn.put("sign","true");
        }else{
            jsonReturn.put("sign","false");
        }
        return jsonReturn;

    }

    String type;
    String topic;

    public static String que = null;


    @RequestMapping("/tea/releasequestion")
    public String release(@RequestBody String json){
        System.out.println("sentttttttttttttttttttttttttttttttttttttttttttttttt");
        que = json;
        JSONObject jsonObject = JSONObject.parseObject(json);
        type= jsonObject.getString("type");
        topic=jsonObject.getString("topic");
        return "sent successful";
    }

    @RequestMapping("/stu/getquestion")
    public String  getquestion(){
        System.out.println("11111111111111111111111111111111111111111111111"+que);

        //JSONObject res = new JSONObject();
//        res.put("data",que);
        //res.put("check","true");

        return que;
    }

    @RequestMapping("/stu/course/paperorquestion")
    public JSONObject stucoursepaperorquestion(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        String paper_question_id=jsonObject.getString("paper_question_id");

        JSONObject jsonReturn = new JSONObject();
        if(topic.equals(paper_question_id)){
            jsonReturn.put("check","false");
        }else{
            jsonReturn.put("check","true");
            jsonReturn.put("type",type);
            jsonReturn.put("topic",topic);
        }
        return jsonReturn;
//        System.out.println("11111111111111111111111111111111111111111111111"+que);
//
//        JSONObject res = new JSONObject();
//        res.put("data",que);
//        res.put("check","true");
//
//        return res;
    }

}




