package com.springboot.weekly.mapper;

import com.springboot.weekly.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    public Student getStudentByNumber(String studentNumber);
    public void update(String password,String studentNumber);
}
