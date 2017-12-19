package com.doctorwork.union.module.withdrawals.service.impl;

import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.service.DoctorService;
import com.doctorwork.union.module.withdrawals.bean.Withdrawals;
import com.doctorwork.union.module.withdrawals.service.AutoWithdrawalsService;
import com.doctorwork.union.module.withdrawals.service.WithdrawalsService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhengxingle on 2017/10/20.
 */
@Service
@EnableScheduling
public class AutoWithdrawals implements AutoWithdrawalsService{

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private WithdrawalsService withdrawalsService;

    @Scheduled(cron="0 0 0 1 * ?")
    @Transactional
    public void autoWithdrawals(){
        RLock lock = redisson.getLock("autoWithdrawals");
        try {
            if (lock.tryLock()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
                String checkBatch = format.format(new Date());
                //先删除未处理的该批次的提现记录
                withdrawalsService.deleteByCheckBatch(checkBatch);
                List<Doctor> list = doctorService.selectAllDoctors();
                for (Doctor doctor: list) {
                    if (doctor.getCardNumber().isEmpty()) {
                        continue;
                    }
                    List<Withdrawals> withdrawalses = withdrawalsService.selectWithdrawals(doctor.getId(),checkBatch);
                    if (withdrawalses==null||withdrawalses.isEmpty()) {  //提现数据不存在，新生成
                        Withdrawals withdrawals = new Withdrawals();
                        withdrawals.setDoctorId(doctor.getId());
                        withdrawals.setPassportId(doctor.getPassportId());
                        withdrawals.setCheckBatch(checkBatch);
                        withdrawalsService.insertWithdrawals(withdrawals,doctor.getCardNumber());
                    }
                }
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int doWithdrawals() throws Exception {
        autoWithdrawals();
        return 0;
    }

}
