package com.doctorwork.union.module.doctor.controller;

import com.doctorwork.common.result.HttpResult;
import com.doctorwork.union.common.annotation.Auth;
import com.doctorwork.union.common.rest.Response;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.service.DoctorService;
import com.doctorwork.union.module.doctor.vo.DoctorPwdVo;
import com.doctorwork.union.module.doctor.vo.DoctorVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import java.util.List;
/**
 * Created by barry on 2017/10/16.
 */

@Slf4j
@RestController
@RequestMapping("/doctor")
public class DoctorController {




    @Autowired
    private DoctorService doctorService;

    @GetMapping(value ="/list")
    //@Auth
    public @ResponseBody HttpResult page(@QueryParam("pageNum") Integer pageNum,@QueryParam("pageSize") Integer pageSize,@QueryParam("search") String search,@QueryParam("agentId") String agentId){
        try{
            DoctorVo doctorVo=new DoctorVo();
            doctorVo.setPageNum(0);
            doctorVo.setPageSize(15);
            if(pageNum!=null && pageNum>0){
                doctorVo.setPageNum(pageNum);
            }
            if(pageSize!=null && pageSize>0){
                doctorVo.setPageSize(pageSize);
            }
            doctorVo.setSearch(search);
            doctorVo.setAgentId(agentId);
            return new HttpResult(Response.SUCCESS,"",doctorService.selectByExample(doctorVo));
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    @GetMapping(value ="/clinic/list")
    //@Auth
    public @ResponseBody HttpResult clinicList(@QueryParam("pageNum") Integer pageNum,@QueryParam("pageSize") Integer pageSize,@QueryParam("doctorName") String doctorName,@QueryParam("hospital") String hospital,@QueryParam("title") String title){
        try{
            DoctorVo doctorVo=new DoctorVo();
            doctorVo.setPageNum(0);
            doctorVo.setPageSize(15);
            if(pageNum!=null && pageNum>0){
                doctorVo.setPageNum(pageNum);
            }
            if(pageSize!=null && pageSize>0){
                doctorVo.setPageSize(pageSize);
            }
            doctorVo.setSearch(null);
            doctorVo.setAgentId(null);
            doctorVo.setDoctorName(doctorName);
            doctorVo.setHospital(hospital);
            doctorVo.setTitle(title);
            return new HttpResult(Response.SUCCESS,"",doctorService.clinicSelect(doctorVo));
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    @RequestMapping("/{id}")
    @Auth
    public @ResponseBody HttpResult queryById(@PathVariable String id){
        try{
            if(!StringUtils.isNotBlank(id)){
                return new HttpResult(Response.ERROR,"id不能为空",null);
            }

            if(StringUtils.isNumeric(id)){
                Doctor doctor=doctorService.queryByPassportId(id);
                id=doctor.getId();
            }
            return new HttpResult(Response.SUCCESS,"",doctorService.selectByPrimaryKey(id));
        }catch(Exception e){
            log.error(e.getMessage());
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    @PostMapping(value="/update")
    @Auth
    public @ResponseBody HttpResult update(@RequestBody @Valid DoctorPwdVo doctor, BindingResult result){
        try{
            if (result.hasErrors()) {
                List<ObjectError> list = result.getAllErrors();
                if(list.size()>0) {
                    return new HttpResult(Response.ERROR, list.get(0).getDefaultMessage(), null);
                }
            }
            return new HttpResult(Response.SUCCESS,"",doctorService.updateByPrimaryKey(doctor));
        }catch(Exception e){
            log.error(e.getMessage());
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    @PostMapping("/add")
    //@Auth
    public @ResponseBody HttpResult add(@RequestBody @Valid Doctor doctor,BindingResult result){

        try{
            if (result.hasErrors()) {
                List<ObjectError> list = result.getAllErrors();
                if(list.size()>0) {
                    return new HttpResult(Response.ERROR, list.get(0).getDefaultMessage(), null);
                }
            }
            return new HttpResult(Response.SUCCESS,"",doctorService.insertSelective(doctor));
        }catch(Exception e){
            log.error(e.getMessage());
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }

    }

    @PostMapping("/reset_password")
    @Auth
    public @ResponseBody HttpResult reSetPassword(@RequestBody @Valid Doctor doctor){
        try{
            if(!(doctor!=null && StringUtils.isNotBlank(doctor.getId()))){
                return new HttpResult(Response.ERROR,"id不能为空",null);
            }
            doctorService.reSetPassword(doctor);
            return new HttpResult(Response.SUCCESS,"",null);
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }

    @PostMapping("/query_in_clinic")
//    @Auth
    public @ResponseBody HttpResult queryInClinic(@RequestBody @Valid Doctor doctor){
        try{
            if(!(doctor!=null && StringUtils.isNotBlank(doctor.getPhone()))){
                return new HttpResult(Response.ERROR,"phone不能为空",null);
            }
            return new HttpResult(Response.SUCCESS,"success", doctorService.queryInClinic(doctor));
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return new HttpResult(Response.ERROR,e.getMessage(),null);
        }
    }
}
