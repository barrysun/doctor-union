package com.doctorwork.union.module.visit.controller;

import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.common.rest.Response;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.service.DoctorService;
import com.doctorwork.union.module.visit.bean.Visit;
import com.doctorwork.union.module.visit.service.VisitService;
import com.doctorwork.union.module.visit.vo.VisitVo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by barry on 2017/10/16.
 */
@Slf4j
@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private DoctorService doctorService;

    /**
     * 获取当月时间
     * @return
     */
    @PostMapping("/list/month")
    public @ResponseBody HttpResult monthList(@RequestBody  VisitVo visitVo,BindingResult result){
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            if(list.size()>0) {
                return new HttpResult(Response.ERROR, list.get(0).getDefaultMessage(), null);
            }
        }
    	try {
            if(StringUtils.isNotBlank(visitVo.getPassportId())){
                Doctor doctor=doctorService.queryByPassportId(visitVo.getPassportId());
                if(doctor==null){
                    return new HttpResult(Response.ERROR,"医生不存在","");
                }

                visitVo.setDoctorId(doctor.getId());
            }
            if(!StringUtils.isNotBlank(visitVo.getDoctorId())){
                return new HttpResult(Response.ERROR,"参数不能为空",null);
            }
			return new HttpResult(Response.SUCCESS,"",visitService.monthList(visitVo));
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
			return new HttpResult(Response.ERROR,e.getMessage(),null);
		}
    }

    /**
     * 获取本周时间
     * @param visitVo
     * @return
     */
    @PostMapping("/list/week")
    public @ResponseBody HttpResult weekList(@RequestBody @Valid VisitVo visitVo,BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            if(list.size()>0) {
                return new HttpResult(Response.ERROR, list.get(0).getDefaultMessage(), null);
            }
        }
        try{
            if(StringUtils.isNotBlank(visitVo.getPassportId())){
            Doctor doctor=doctorService.queryByPassportId(visitVo.getPassportId());
            visitVo.setDoctorId(doctor.getId());
            }
            return new HttpResult(Response.SUCCESS,"",visitService.weekList(visitVo));
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    /**
     * 出诊时间设置
     * @param visit
     * @return
     */
    @PostMapping("/save")
    public @ResponseBody HttpResult save(@RequestBody @Valid VisitVo visit,BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            if(list.size()>0) {
                return new HttpResult(Response.ERROR, list.get(0).getDefaultMessage(), null);
            }
        }
        try{
            if(StringUtils.isNotBlank(visit.getPassportId())){
                Doctor doctor=doctorService.queryByPassportId(visit.getPassportId());
                visit.setDoctorId(doctor.getId());
            }
            return new HttpResult(Response.SUCCESS,"",visitService.save(visit));
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    @PostMapping("/list")
    public @ResponseBody HttpResult page(@RequestBody @Valid VisitVo visitVo,BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            if(list.size()>0) {
                return new HttpResult(Response.ERROR, list.get(0).getDefaultMessage(), null);
            }
        }

        try{
            if(StringUtils.isNotBlank(visitVo.getPassportId())){
                Doctor doctor=doctorService.queryByPassportId(visitVo.getPassportId());
                visitVo.setDoctorId(doctor.getId());
            }
            return new HttpResult(Response.SUCCESS,"",visitService.page(visitVo));
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }


}
