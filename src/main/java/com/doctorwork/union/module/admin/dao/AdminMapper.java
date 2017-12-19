package com.doctorwork.union.module.admin.dao;

import com.doctorwork.union.module.admin.bean.Admin;
import com.doctorwork.union.module.admin.bean.AdminCriteria;
import java.util.List;

public interface AdminMapper {
    int countByExample(AdminCriteria example);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminCriteria example);

    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}