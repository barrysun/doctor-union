package com.doctorwork.union.module.admin.service.impl;

import com.doctorwork.union.module.admin.bean.Admin;
import com.doctorwork.union.module.admin.bean.AdminCriteria;
import com.doctorwork.union.module.admin.dao.AdminMapper;
import com.doctorwork.union.module.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;


    @Override
    public List<Admin> selectAdminByPassId(String passportId) throws Exception {
        AdminCriteria adminCriteria = new AdminCriteria();
        AdminCriteria.Criteria criteria = adminCriteria.createCriteria();
        criteria.andIsDeleteEqualTo(0).andPassportIdEqualTo(passportId);
        return adminMapper.selectByExample(adminCriteria);
    }
}
