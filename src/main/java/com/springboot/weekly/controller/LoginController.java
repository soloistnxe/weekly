package com.springboot.weekly.controller;

import com.springboot.weekly.entity.Information;
import com.springboot.weekly.entity.Student;
import com.springboot.weekly.mapper.InformationMapper;
import com.springboot.weekly.mapper.StudentMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * 登陆
 */
@Controller
public class LoginController {

    //    @DeleteMapping
//    @PutMapping
//    @GetMapping
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    InformationMapper informationMapper;

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("studentnumber") String studentnumber,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {


        Student user = studentMapper.getStudentByNumber(studentnumber);
        Information lastInformation = informationMapper.getLastInformation();

        if (user != null && password.equals(user.getPassword())) {
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", user.getStudentName());
            session.setAttribute("studentNumber", user.getStudentNumber());
            //将最新的通知信息返回前台
            map.put("msg", lastInformation);
            System.out.println(user);
            if (user.getStatus() == 1)
                return "teacher/main";
            else
                return "student/main";
        } else {
            //登陆失败
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }


    @GetMapping(value = "/")
    public String loginUser() {
        return "login";
    }

    @GetMapping(value = "/main")
    public String gotoMain(Map<String, Object> map) {
        Information lastInformation = informationMapper.getLastInformation();
        map.put("msg", lastInformation);
        return "student/main";
    }

    @GetMapping(value = "/teacher/main")
    public String gotoTeacherMain(Map<String, Object> map) {
        Information lastInformation = informationMapper.getLastInformation();
        map.put("msg", lastInformation);
        return "teacher/main";
    }


}
