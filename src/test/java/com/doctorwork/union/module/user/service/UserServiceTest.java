package com.doctorwork.union.module.user.service;

import com.doctorwork.union.Application;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.shopkeeper.service.ShopkeeperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by barry on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private ShopkeeperService shopkeeperService;


    @Test
    public void selectByPrimaryKeyTest() throws Exception{

//        System.out.println(System.currentTimeMillis());
//        System.out.println(Calendar.getInstance().getTime().getTime());
//        System.out.println(new Date().getTime());
//        //1508824122771
//        System.out.println(new Date(1508824122771L));
        Doctor doctor=new Doctor();

        doctor.setDoctorName("barry");
        doctor.setPhone("15882346251");
        shopkeeperService.synDoctorClinic(doctor);
    }
}
