package com.doctorwork.union.module.income.service.impl;

import com.doctorwork.common.result.PageResult;
import com.doctorwork.common.util.BeanUtils;
import com.doctorwork.union.common.uuid.UuidUtil;
import com.doctorwork.union.module.doctor.dao.DoctorMapper;
import com.doctorwork.union.module.income.bean.Income;
import com.doctorwork.union.module.income.bean.IncomeCriteria;
import com.doctorwork.union.module.income.bean.IncomeRes;
import com.doctorwork.union.module.income.dao.IncomeMapper;
import com.doctorwork.union.module.income.service.IncomeService;
import com.doctorwork.union.module.income.vo.IncomeParamVo;
import com.doctorwork.union.module.invitation.vo.ClinicVo;
import com.doctorwork.union.module.shopkeeper.service.ShopkeeperService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
public class IncomeServiceImpl implements IncomeService {

    private static final double poundage = 0.000;

    @Autowired
    private ShopkeeperService shopkeeperService;

    @Resource
    private IncomeMapper incomeMapper;

    @Resource
    private DoctorMapper doctorMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Override
    public Income selectByPrimaryKey(String id) throws Exception {
        return incomeMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void add(Income income) throws Exception {
        if(!StringUtils.isNotBlank(income.getId())){
            income.setId(UuidUtil.getUUID());
        }
        incomeMapper.insertSelective(income);
    }

    @Override
    public PageResult<IncomeRes>  selectIncomeList(IncomeParamVo incomeParamVo) throws Exception {
        IncomeCriteria incomeCriteria = new IncomeCriteria();
        incomeCriteria.createCriteria().andIsDeleteEqualTo(0).andPassportIdEqualTo(incomeParamVo.getPassportId());
        incomeCriteria.setOrderByClause("modify_time desc");
        Page page= PageHelper.startPage(incomeParamVo.getPageNum(),incomeParamVo.getPageSize());
        List<Income> list = incomeMapper.selectByExample(incomeCriteria);
        List<IncomeRes> listRes = new ArrayList<>();
        Set<String> listClinicId = new HashSet<>();
        for (Income in : list) {
            IncomeRes res = new IncomeRes();
            BeanUtils.copyProperties(in,res);
            listRes.add(res);
            listClinicId.add(in.getClinicId());
        }
        //调用接口获取诊所名称
        Map<String,ClinicVo> clinicMap = shopkeeperService.getClinicNames(listClinicId);
        if (!clinicMap.isEmpty() ) {
            for (IncomeRes in : listRes) {
                if(clinicMap.containsKey(in.getClinicId())){
                    in.setClinicName(clinicMap.get(in.getClinicId()).getName());
                }
            }
        }
        PageResult pageResult = new PageResult<>(page.getTotal(),page.getPages(),page.getPageSize(),page.getPageNum(),listRes);
        return pageResult;
    }

}
