package com.springboot.weekly.controller;

import com.springboot.weekly.entity.Weekly;
import com.springboot.weekly.mapper.WeeklyMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private WeeklyMapper weeklyMapper;
    @GetMapping("/teacher/weekly")
    public String studentWeeklyList(Model model){
        List<HashMap> weeklyList = weeklyMapper.getWeeklyList();
        model.addAttribute("weeklylist",weeklyList);
        return "teacher/list";
    }
    @GetMapping("/teacher/show/{weeklyId}/{studentNumber}")
    public String weeklyCheck(@PathVariable("weeklyId") String weeklyId,
                              @PathVariable("studentNumber") String studentNumber,
                              Model model){
        Weekly weeklyByStudentNumberAndWeeklyId = weeklyMapper.getWeeklyByStudentNumberAndWeeklyId(studentNumber, weeklyId);
        model.addAttribute("weekly",weeklyByStudentNumberAndWeeklyId);
        return "teacher/show";
    }
}
