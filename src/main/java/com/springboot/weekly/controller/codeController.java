package com.springboot.weekly.controller;
import com.springboot.weekly.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 密码Controller
 */
@Controller
public class codeController {
    @Autowired
    StudentMapper studentMapper;

    //学生端页面跳转
    @GetMapping("/password")
    public String password(){
        return "student/password";
    }
    //教师端页面跳转
    @GetMapping("/teacher/password")
    public String teacherPassword(){
        return "/teacher/password";
    }

    //教师端编辑密码
    @PostMapping(value = "/teacher/edit_password")
    public String teacherPassword(Map<String,Object> map, @RequestParam("password") String password,
                           @RequestParam("password_affirm") String password_affirm, HttpSession session){

            studentMapper.update(password, (String) session.getAttribute("studentNumber"));

            return "redirect:/teacher/weekly";

    }
    //学生端编辑密码
    @PostMapping(value = "/edit_password")
    public String password(Map<String,Object> map, @RequestParam("password") String password,
                           @RequestParam("password_affirm") String password_affirm, HttpSession session){

        studentMapper.update(password, (String) session.getAttribute("studentNumber"));

        return "redirect:/weekly";

    }
}
