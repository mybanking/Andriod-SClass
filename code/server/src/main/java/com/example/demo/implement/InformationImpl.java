package com.example.demo.implement;

        import com.alibaba.fastjson.JSONObject;
        import com.example.demo.bean.Student;
        import com.example.demo.bean.Teacher;
        import com.example.demo.mapper.InformationMapper;
        import com.example.demo.service.InformationService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
@Service
public class InformationImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public JSONObject getStuInfo(String stuId) {
        JSONObject res = new JSONObject();
        List<Student> students = informationMapper.getStuInfo(stuId);
        res.put("data",students);
        return res;

    }

    @Override
    public JSONObject getTeaInfo(String teacherId) {
        JSONObject res = new JSONObject();
        List<Teacher> teachers = informationMapper.getTeaInfo(teacherId);
        res.put("data",teachers);
        return res;

    }
}
