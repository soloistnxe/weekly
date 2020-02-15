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
        return "password";
    }
    @PostMapping(value = "/edit_password")
    public String password(Map<String,Object> map, @RequestParam("password") String password,
                           @RequestParam("password_affirm") String password_affirm, HttpSession session){
        if(password.equals(password_affirm)){
            studentMapper.update(password, (String) session.getAttribute("studentNumber"));
            map.put("msg","修改成功");
            return "redirect:weekly";
        }else {
            map.put("msg","两次输入密码不一致");
            return "redirect:/password";
        }
    }
}
