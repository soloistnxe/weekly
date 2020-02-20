package com.springboot.weekly.controller;

import com.springboot.weekly.entity.Information;
import com.springboot.weekly.mapper.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 教师端发布通知
 */
@Controller
public class InformationController {
    @Autowired
    InformationMapper informationMapper;
    @GetMapping("/information")
    public String toInformation(Model model){
        Information informationById = informationMapper.getInformationById(1);
        model.addAttribute("informationById",informationById);
        return "student/information";
    }

    @GetMapping("/teacher/add")
    public String toTeacherInformation(Model model){
        Information informationById = informationMapper.getInformationById(1);
        model.addAttribute("informationById",informationById);
        return "teacher/information";
    }

    @PostMapping("/teacher/add")
    public String addInformation(HttpServletResponse response,Information information){

        information.setDate(new Date());
        boolean insert = informationMapper.insert(information);
        if(insert){
            return "teacher/commons/success";
        }
            return "teacher/commons/error";
    }

    @GetMapping("/notice/{information}")
    public String notice(@PathVariable("information") String information,Model model){
        model.addAttribute("information",information);
        return "notice";
    }


}
