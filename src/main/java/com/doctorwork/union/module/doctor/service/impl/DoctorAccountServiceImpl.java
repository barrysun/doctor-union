package com.doctorwork.union.module.doctor.service.impl;

import com.doctorwork.common.exception.ServiceException;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.bean.DoctorCriteria;
import com.doctorwork.union.module.doctor.dao.DoctorExtMapper;
import com.doctorwork.union.module.doctor.dao.DoctorMapper;
import com.doctorwork.union.module.doctor.service.DoctorAccountService;
import com.doctorwork.union.module.doctor.vo.DoctorAccountVo;
import com.doctorwork.union.module.wallet.service.WalletService;
import com.doctorwork.union.module.wallet.vo.WalletResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */
@Slf4j
@Service
public class DoctorAccountServiceImpl implements DoctorAccountService {

    @Resource
    private DoctorMapper doctorMapper;

    @Autowired
    private WalletService walletService;



    @Override
    public int addAccount(DoctorAccountVo doctorAccountVo) throws Exception {
        DoctorCriteria doctorCriteria = new DoctorCriteria();
        DoctorCriteria.Criteria criteria = doctorCriteria.createCriteria();
        criteria.andIsDeleteEqualTo(0);
        criteria.andPassportIdEqualTo(doctorAccountVo.getPassportId());
        List<Doctor> doctors = doctorMapper.selectByExample(doctorCriteria);
        if (doctors==null||doctors.isEmpty()) {
            throw new ServiceException("passportId错误");
        }
        Doctor doctor = doctors.get(0);
        Doctor doctorAccount = new Doctor();
        doctorAccount.setId(doctor.getId());
        doctorAccount.setCardBank(doctorAccountVo.getCardBank());
        doctorAccount.setCardNumber(doctorAccountVo.getCardNumber());
        doctorAccount.setCardUserName(doctorAccountVo.getCardUserName());
        doctorAccount.setIdCard(doctorAccountVo.getIdCard());
        return doctorMapper.updateByPrimaryKeySelective(doctorAccount);
    }

    @Override
    public int updateAccount(DoctorAccountVo doctorAccountVo) throws Exception {
        Doctor doctorAccount = new Doctor();
        doctorAccount.setId(doctorAccountVo.getId());
        doctorAccount.setCardBank(doctorAccountVo.getCardBank());
        doctorAccount.setCardNumber(doctorAccountVo.getCardNumber());
        doctorAccount.setCardUserName(doctorAccountVo.getCardUserName());
        doctorAccount.setIdCard(doctorAccountVo.getIdCard());
        return doctorMapper.updateByPrimaryKeySelective(doctorAccount);
    }

    @Override
    public DoctorAccountVo queryAccount(DoctorAccountVo doctorAccountVo) throws Exception {
        DoctorCriteria doctorCriteria = new DoctorCriteria();
        DoctorCriteria.Criteria criteria = doctorCriteria.createCriteria();
        criteria.andIsDeleteEqualTo(0);
        criteria.andPassportIdEqualTo(doctorAccountVo.getPassportId());

        List<Doctor> doctors = doctorMapper.selectByExample(doctorCriteria);
        if (doctors==null||doctors.isEmpty()) {
            throw new ServiceException("passportId错误");
        }
        Doctor doctor = doctors.get(0);
        DoctorAccountVo doctorAccountRes = new DoctorAccountVo();
        doctorAccountRes.setId(doctor.getId());
        doctorAccountRes.setCardNumber(doctor.getCardNumber());
        doctorAccountRes.setCardBank(doctor.getCardBank());
        doctorAccountRes.setIdCard(doctor.getIdCard());
        doctorAccountRes.setCardUserName(doctor.getCardUserName());
        doctorAccountRes.setBalance(0L);
        //从钱包获取账户余额
        List<WalletResVo> list = walletService.walletAmountList(new String[]{doctorAccountVo.getPassportId()});
        if (list!=null&&!list.isEmpty()) {
            WalletResVo walletResVo = list.get(0);
            doctorAccountRes.setBalance(walletResVo.getAmount());
        }
        return doctorAccountRes;
    }
}
