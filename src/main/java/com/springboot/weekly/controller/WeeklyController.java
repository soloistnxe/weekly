package com.springboot.weekly.controller;


import com.springboot.weekly.entity.Information;
import com.springboot.weekly.entity.Weekly;
import com.springboot.weekly.mapper.InformationMapper;
import com.springboot.weekly.mapper.WeeklyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 学生端
 */
@Controller
public class WeeklyController {
    @Autowired
    private  WeeklyMapper weeklyMapper;
    //获取周报列表，每个人只能查看自己的
    @GetMapping("/weekly")
    public String findWeeklyList(Model model, HttpSession session){
        Object studentNumber = session.getAttribute("studentNumber");
        List<Weekly> weeklys = (List<Weekly>) weeklyMapper.getWeeklyByStudentNumber((String) studentNumber);
        model.addAttribute("weeklys",weeklys);
        return "student/list";
    }
    //添加周报的表单提交
    @PostMapping("/add")
    public String addWeekly(Map<String,String> map,@RequestParam("weeklyId")String weekltid, @RequestParam("weeklyId1") String weekltid_1, @RequestParam("file") MultipartFile file,Weekly weekly){
        //周报添加页面
        String filename = file.getOriginalFilename();
        if(filename!=null && !"".equals(filename) ){
            //获取文件的名字
            //上传的文件放在D盘下的upload文件夹中
            String path = "d:\\upload\\";
            //防止文件名重复  随机文件名
            filename = path +filename;

            weekly.setFilename(filename);

            File f = new File(filename);
            //如果D盘下没有upload文件夹 则创建一个
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            try {
                //把MultipartFile转化为File类型
                file.transferTo(f);

            } catch (IOException e) {
                e.printStackTrace();
                map.put("msg","上传文件大小超过限制，限制为50MB");
                return "commons/error";
            }
        }
        weekly.setWeeklyId(weekltid+"|"+weekltid_1);
        weekly.setDate(new Date());
        weekly.setCheckStatus("未审阅");
        boolean insert = weeklyMapper.insert(weekly);
        if(insert){
            System.out.println("保存的周报信息："+weekly);
            return "commons/success";
        }else{
            return "commons/error";
        }
    }
    @GetMapping("/add")
    public String toAddPage(){
        return "student/add";
    }

    /**
     * 显示周报信息
     * @return
     */
    @GetMapping("/show/{weeklyid}")
    public String show(@PathVariable("weeklyid") String weeklyId,Model model,HttpSession session){
        Object studentNumber = session.getAttribute("studentNumber");
        Weekly weeklyByStudentNumberAndWeeklyId = weeklyMapper.getWeeklyByStudentNumberAndWeeklyId((String) studentNumber, weeklyId);
        model.addAttribute("weekly",weeklyByStudentNumberAndWeeklyId);
        return "student/show";
    }
    //跳转到编辑周报页面
    @GetMapping("/edit/{weeklyid}")
    public String toEditPage(@PathVariable("weeklyid") String weeklyId, Model model, HttpSession session){
        Object studentNumber = session.getAttribute("studentNumber");
        Weekly weeklyByStudentNumberAndWeeklyId = weeklyMapper.getWeeklyByStudentNumberAndWeeklyId((String) studentNumber, weeklyId);
        String[] strArr = weeklyByStudentNumberAndWeeklyId.getWeeklyId().split("\\|");
        model.addAttribute("weeklyId",strArr[0]);
        model.addAttribute("weeklyId1",strArr[1]);
        model.addAttribute("weekly",weeklyByStudentNumberAndWeeklyId);
        return "student/edit";
    }
    //编辑周报的表单提交
    @PostMapping("/edit")
    public String editWeekly(@RequestParam("file") MultipartFile file,@RequestParam("weeklyId")String weekltid,@RequestParam("weeklyId1") String weekltid_1,Weekly weekly){
        //周报编辑页面

        String filename = file.getOriginalFilename();
        if(filename!=null && !"".equals(filename)){
            //上传的文件放在D盘下的upload文件夹中
            String path = "d:\\upload\\";
            //防止文件名重复  随机文件名
            filename = path +filename;

            weekly.setFilename(filename);

            File f = new File(filename);
            //如果D盘下没有upload文件夹 则创建一个
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            try {
                //把MultipartFile转化为File类型
                file.transferTo(f);

            } catch (IOException e) {
                e.printStackTrace();

                return "commons/error";
            }
        }
        weekly.setWeeklyId(weekltid+"|"+weekltid_1);
        weekly.setDate(new Date());
        boolean update = weeklyMapper.update(weekly);
        if(update){
            System.out.println("更新周报信息："+weekly);
            return "commons/success";
        }else{
            return "commons/error";
        }
    }


}
