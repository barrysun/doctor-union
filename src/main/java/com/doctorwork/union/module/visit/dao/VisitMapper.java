package com.doctorwork.union.module.visit.dao;

import com.doctorwork.union.module.visit.bean.Visit;
import com.doctorwork.union.module.visit.bean.VisitCriteria;
import java.util.List;

public interface VisitMapper {
    int countByExample(VisitCriteria example);

    int insert(Visit record);

    int insertSelective(Visit record);

    List<Visit> selectByExample(VisitCriteria example);

    Visit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKey(Visit record);
}