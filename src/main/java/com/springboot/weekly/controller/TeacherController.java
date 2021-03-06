package com.springboot.weekly.controller;

import com.springboot.weekly.entity.Weekly;
import com.springboot.weekly.mapper.WeeklyMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教师端
 */
@Controller
public class TeacherController {
    @Autowired
    private WeeklyMapper weeklyMapper;

    //查看学生周报列表
    @GetMapping("/teacher/weekly")
    public String studentWeeklyList(Model model){
        List<HashMap> weeklyList = weeklyMapper.getWeeklyList();
        model.addAttribute("weeklylist",weeklyList);
        return "teacher/list";
    }

    //显示周报详情
    @GetMapping("/teacher/show/{weeklyId}/{studentNumber}/{studentName}")
    public String weeklyCheck(@PathVariable("weeklyId") String weeklyId,
                              @PathVariable("studentNumber") String studentNumber,
                              @PathVariable("studentName") String studentName,
                              Model model){
        Weekly weeklyByStudentNumberAndWeeklyId = weeklyMapper.getWeeklyByStudentNumberAndWeeklyId(studentNumber, weeklyId);
        model.addAttribute("studentName",studentName);
        model.addAttribute("weekly",weeklyByStudentNumberAndWeeklyId);
        return "teacher/show";
    }

    //审阅周报，添加审阅意见
    @PostMapping("/teacher/check")
    public String checkWeekly(Weekly weekly,Map<String,String> map){
        weekly.setCheckStatus("已审阅");
        boolean b = weeklyMapper.teacherCheck(weekly);
        if(b){
            System.out.println("审阅："+weekly);
            map.put("msg","审阅成功，已保存");
            return "teacher/commons//success";
        }else{
            return "teacher/commons/error";
        }
    }
}
