package com.doctorwork.union.module.admin.service;


import com.doctorwork.union.module.admin.bean.Admin;

import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */
public interface AdminService {


    List<Admin> selectAdminByPassId(String passportId) throws Exception;

}
