package com.springboot.weekly.controller;
import com.springboot.weekly.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
public class codeController {
    @Autowired
    StudentMapper studentMapper;
    @GetMapping("/password")
    public String password(){
        return "student/password";
    }

    @GetMapping("/teacher/password")
    public String teacherPassword(){
        return "/teacher/password";
    }


    @PostMapping(value = "/teacher/edit_password")
    public String teacherPassword(Map<String,Object> map, @RequestParam("password") String password,
                           @RequestParam("password_affirm") String password_affirm, HttpSession session){

            studentMapper.update(password, (String) session.getAttribute("studentNumber"));

            return "redirect:/teacher/weekly";

    }

    @PostMapping(value = "/edit_password")
    public String password(Map<String,Object> map, @RequestParam("password") String password,
                           @RequestParam("password_affirm") String password_affirm, HttpSession session){

        studentMapper.update(password, (String) session.getAttribute("studentNumber"));

        return "redirect:/weekly";

    }
}
