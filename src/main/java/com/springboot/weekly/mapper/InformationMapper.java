package com.springboot.weekly.mapper;

import com.springboot.weekly.entity.Information;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InformationMapper {
    public Information getInformationById(Integer id);
    public boolean insert(Information information);
    public Information getLastInformation();
}
