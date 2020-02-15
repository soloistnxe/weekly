package com.springboot.weekly.mapper;

import com.springboot.weekly.entity.Weekly;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeeklyMapper {
    public List<Weekly> getWeeklyByStudentNumber(String studentNumber);
    public boolean insert(Weekly weekly);
    public boolean update(Weekly weekly);
    public Weekly getWeeklyByStudentNumberAndWeeklyId(String studentNumber,String weeklyId);
}
