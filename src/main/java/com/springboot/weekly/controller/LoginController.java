package com.springboot.weekly.controller;

import com.springboot.weekly.entity.Student;
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

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping
    @Autowired
    StudentMapper studentMapper;
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("studentnumber") String studentnumber,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        Student student=studentMapper.getStudentByNumber(studentnumber);
        if(student!=null && password.equals(student.getPasswaord())){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",student.getStudentName());
            session.setAttribute("studentNumber",student.getStudentNumber());
            System.out.println(student);
            return "main";
        }else{
            //登陆失败

            map.put("msg","用户名或密码错误");
            return  "login";
        }

    }

    @GetMapping(value = "/")
    public String loginUser(){
       return "login";
    }

    @GetMapping(value = "/main")
    public String gotoMain(){
        return "main";
    }


}
