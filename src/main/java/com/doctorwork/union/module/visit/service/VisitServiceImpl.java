package com.doctorwork.union.module.visit.service;

import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.common.uuid.UuidUtil;
import com.doctorwork.union.module.doctor.bean.Doctor;
import com.doctorwork.union.module.doctor.dao.DoctorMapper;
import com.doctorwork.union.module.invitation.bean.Invitation;
import com.doctorwork.union.module.invitation.dao.InvitationMapper;
import com.doctorwork.union.module.invitation.vo.ClinicVo;
import com.doctorwork.union.module.shopkeeper.service.ShopkeeperService;
import com.doctorwork.union.module.visit.bean.Visit;
import com.doctorwork.union.module.visit.bean.VisitCriteria;
import com.doctorwork.union.module.visit.dao.VisitExtMapper;
import com.doctorwork.union.module.visit.dao.VisitMapper;
import com.doctorwork.union.module.visit.vo.DayVo;
import com.doctorwork.union.module.visit.vo.TimeVo;
import com.doctorwork.union.module.visit.vo.VisitRetVo;
import com.doctorwork.union.module.visit.vo.VisitVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by barry on 2017/10/16.
 */
@Slf4j
@Service
public class VisitServiceImpl implements VisitService {

	@Autowired
	private ShopkeeperService shopkeeperService;

	@Resource
	private VisitMapper visitMapper;

	@Resource
	private DoctorMapper doctorMapper;

	@Resource
	private VisitExtMapper visitExtMapper;

	@Resource
	private InvitationMapper invitationMapper;

	@Override
	public VisitRetVo monthList(@Valid VisitVo visitVo) throws Exception {
		if(visitVo==null || visitVo.getStartTime()==null){
			//visitVo=new VisitVo();
			visitVo.setStartTime(getBeginDayOfMonth());
			visitVo.setEndTime(getEndDayOfMonth());
		}
		VisitRetVo ret=new VisitRetVo();
		ret.setStartTime(visitVo.getStartTime());
		ret.setEndTime(visitVo.getEndTime());
		ret.setDoctorId(visitVo.getDoctorId());
		List<Visit> visits=list(visitVo);
		List<DayVo> array=new ArrayList<>();
		if(visits!=null && visits.size()>0){
            //获取诊所名称
			Set<String> keys = new HashSet<>();
            for (Visit visit:visits) {
				keys.add(visit.getClinicId());
			}
			Map<String,ClinicVo> clinicMap = shopkeeperService.getClinicNames(keys);
			for(Visit visit:visits){
				DayVo tmp =null;
				if(array.size()==0){
					array.add(new DayVo());
				}
				tmp=array.get(array.size()-1);
				if(tmp.getDay()==null ||tmp.getDay()<=0D||(getDayStartTime(new Date(tmp.getDay())).equals(getDayStartTime(new Date(visit.getStartTime()))))){

				}else{
					array.add(new DayVo());
					tmp=array.get(array.size()-1);
				}
				tmp.setDay(getDayStartTime(new Date(visit.getStartTime())));
				if(visit.getTimeInterval()==1){
					TimeVo timeVo=new TimeVo();
					timeVo.setStartTime(visit.getStartTime());
					timeVo.setEndTime(visit.getEndTime());
					timeVo.setId(visit.getId());
					timeVo.setInvitationId(visit.getInvitationId());
					if (!clinicMap.isEmpty() && clinicMap.get(visit.getClinicId())!=null) {
						timeVo.setClinicName(clinicMap.get(visit.getClinicId()).getName());
					}
					if(StringUtils.isNotBlank(visit.getInvitationId())){
						Invitation invitation=invitationMapper.selectByPrimaryKey(visit.getInvitationId());
						timeVo.setInvitationStatus(invitation.getInvitationStatus());

					}
					tmp.setAm(timeVo);

				}else if(visit.getTimeInterval()==2){
					TimeVo timeVo=new TimeVo();
					timeVo.setStartTime(visit.getStartTime());
					timeVo.setEndTime(visit.getEndTime());
					timeVo.setId(visit.getId());
					timeVo.setInvitationId(visit.getInvitationId());
					if(StringUtils.isNotBlank(visit.getInvitationId())){
						Invitation invitation=invitationMapper.selectByPrimaryKey(visit.getInvitationId());
						timeVo.setInvitationStatus(invitation.getInvitationStatus());
					}
					if (!clinicMap.isEmpty() && clinicMap.get(visit.getClinicId())!=null) {
						timeVo.setClinicName(clinicMap.get(visit.getClinicId()).getName());
						//timeVo.setAddr(clinicMap.get(visit.getClinicId()));
					}
					tmp.setPm(timeVo);
				}
			}
		}
		ret.setList(array);
		return ret;
	}
	
	@Override
	public VisitRetVo weekList(VisitVo visitVo) throws Exception {
		if(visitVo==null || visitVo.getStartTime()==null){
			//visitVo=new VisitVo();
			visitVo.setStartTime(getBeginDayOfWeek());
			visitVo.setEndTime(getEndDayOfWeek());

		}
		VisitRetVo ret =new VisitRetVo();
		ret.setStartTime(visitVo.getStartTime());
		ret.setEndTime(visitVo.getEndTime());
		ret.setDoctorId(visitVo.getDoctorId());
		List<Visit> visits=list(visitVo);
		List<DayVo> array=new ArrayList<>();
		if(visits!=null && visits.size()>0){

			for(Visit visit:visits){
				DayVo tmp =null;
				if(array.size()==0){
					array.add(new DayVo());
				}
				tmp=array.get(array.size()-1);
				if(tmp.getDay()==null ||tmp.getDay()<=0D||(getDayStartTime(new Date(tmp.getDay())).equals(getDayStartTime(new Date(visit.getStartTime()))))){

				}else{
					array.add(new DayVo());
					tmp=array.get(array.size()-1);
				}
				tmp.setDay(getDayStartTime(new Date(visit.getStartTime())));
				if(visit.getTimeInterval()==1){
					TimeVo timeVo=new TimeVo();
					timeVo.setStartTime(visit.getStartTime());
					timeVo.setEndTime(visit.getEndTime());
					timeVo.setId(visit.getId());
					timeVo.setInvitationId(visit.getInvitationId());
					if(StringUtils.isNotBlank(visit.getInvitationId())){
						Invitation invitation=invitationMapper.selectByPrimaryKey(visit.getInvitationId());
						timeVo.setInvitationStatus(invitation.getInvitationStatus());

					}

					tmp.setAm(timeVo);

				}else if(visit.getTimeInterval()==2){
					TimeVo timeVo=new TimeVo();
					timeVo.setStartTime(visit.getStartTime());
					timeVo.setEndTime(visit.getEndTime());
					timeVo.setId(visit.getId());
					timeVo.setInvitationId(visit.getInvitationId());
					if(StringUtils.isNotBlank(visit.getInvitationId())){
						Invitation invitation=invitationMapper.selectByPrimaryKey(visit.getInvitationId());
						timeVo.setInvitationStatus(invitation.getInvitationStatus());

					}
					tmp.setPm(timeVo);
				}
			}
		}
		ret.setList(array);
		return ret;
	}

	/**
	 * 保存医生日程表
	 *
	 * 1、如果时间段数据库中不存在 则，直接将传入的日程写入到数据库中。
	 * 2、如果时间段在数据库中存在 则需要比较
	 *   1）、直接清空未预约的日程
	 *   2）、比较被预约的日程，如果已经预约则跳过，不做更改
	 *
	 * @param visitVo
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public VisitVo save(VisitVo visitVo) throws Exception {

		if(visitVo.getStartTime()==null || visitVo.getEndTime()==null){
			throw new RuntimeException("开始时间结束时间不能为空");
		}
		//验证专家医生是否可用
		Doctor doctor=doctorMapper.selectByPrimaryKey(visitVo.getDoctorId());
		if(doctor==null || doctor.getIsDelete()==1){
			throw new RuntimeException("该医生不存在");
		}
		if( doctor.getAccountStatus()==0){
			throw new RuntimeException("该医生被禁用无法设置日程");
		}
		//删除当前时间段未被预约的日程
		delete(visitVo);
		//查询被预约到的日程
		List<Visit> list=list(visitVo);
		//
		if(list!=null && list.size()>0){
			List<VisitVo> array=visitVo.getList();
			for(VisitVo vo:array){
				boolean isHas=false;
				for(Visit visit:list){
					//是否存在??
					isHas=isEquals(visit,vo);
					if(isHas){
						break;
					}
				}
				if(!isHas){
					Visit entity=new Visit();
					entity.setCreateTime(System.currentTimeMillis());
					entity.setStartTime(vo.getStartTime());
					entity.setEndTime(vo.getEndTime());
					entity.setDoctorId(vo.getDoctorId());
					entity.setId(UuidUtil.getUUID());
					entity.setIsDelete(0);
					entity.setModifyTime(System.currentTimeMillis());
					entity.setVisitStatus(0);
					entity.setDoctorId(visitVo.getDoctorId());
					entity.setInvitationId("");
					entity.setTimeInterval(vo.getTimeInterval());
					visitMapper.insertSelective(entity);
				}

			}
		}else{
			List<VisitVo> array=visitVo.getList();
			if(array!=null && array.size()>0){
				for(VisitVo vo:array){
					Visit visit=new Visit();
					visit.setCreateTime(System.currentTimeMillis());
					visit.setStartTime(vo.getStartTime());
					visit.setEndTime(vo.getEndTime());
					visit.setDoctorId(visitVo.getDoctorId());
					visit.setId(UuidUtil.getUUID());
					visit.setIsDelete(0);
					visit.setModifyTime(System.currentTimeMillis());
					visit.setVisitStatus(0);
					visit.setInvitationId("");
					visit.setTimeInterval(vo.getTimeInterval());
					visitMapper.insertSelective(visit);
				}
			}
		}
		if(visitVo.getList()==null || visitVo.getList().size()==0){
			//
			if(list.size()==0){
				return null;
			}
		}
		return null;
	}

	@Override
	public VisitRetVo page(VisitVo visitVo) throws Exception {

		if(visitVo.getStartTime()==null){
			visitVo.setStartTime(getNextDay().getTime());
		}
		if(visitVo.getEndTime()==null){
			visitVo.setEndTime(getNextWeek().getTime());
		}
		VisitRetVo visitRetVo=new VisitRetVo();

		visitRetVo.setStartTime(visitVo.getStartTime());
		visitRetVo.setEndTime(visitVo.getEndTime());
		visitRetVo.setDoctorId(visitVo.getDoctorId());
		visitVo.setPageNum(0);
		visitVo.setPageSize(10);
		VisitCriteria visitCriteria=new VisitCriteria();
		visitCriteria.createCriteria().andDoctorIdEqualTo(visitVo.getDoctorId()).andInvitationIdEqualTo("").andStartTimeGreaterThan(visitVo.getStartTime()).andEndTimeLessThan(visitVo.getEndTime()).andIsDeleteEqualTo(0);
		visitCriteria.setOrderByClause(" start_time desc ");
		Page<?> page= PageHelper.startPage(visitVo.getPageNum(),visitVo.getPageSize());

		PageResult<Visit> ret=new PageResult<>(page.getTotal(),page.getPages(),page.getPageNum(),page.getPageSize(),visitMapper.selectByExample(visitCriteria));
		List<Visit> visits=ret.getList();
		List<DayVo> array=new ArrayList<>();
		if(visits!=null && visits.size()>0){

			for(Visit visit:visits){
				DayVo tmp =null;
				if(array.size()==0){
					array.add(new DayVo());
				}
				tmp=array.get(array.size()-1);
				if(tmp.getDay()==null ||tmp.getDay()<=0D||(getDayStartTime(new Date(tmp.getDay())).equals(getDayStartTime(new Date(visit.getStartTime()))))){

				}else{
					array.add(new DayVo());
					tmp=array.get(array.size()-1);
				}
				tmp.setDay(getDayStartTime(new Date(visit.getStartTime())));
				if(visit.getTimeInterval()==1){
					TimeVo timeVo=new TimeVo();
					timeVo.setStartTime(visit.getStartTime());
					timeVo.setEndTime(visit.getEndTime());
					timeVo.setId(visit.getId());
					timeVo.setInvitationId(visit.getInvitationId());
					tmp.setAm(timeVo);

				}else if(visit.getTimeInterval()==2){
					TimeVo timeVo=new TimeVo();
					timeVo.setStartTime(visit.getStartTime());
					timeVo.setEndTime(visit.getEndTime());
					timeVo.setId(visit.getId());
					timeVo.setInvitationId(visit.getInvitationId());
					tmp.setPm(timeVo);
				}
			}
		}
		visitRetVo.setList(array);
		return visitRetVo;
	}


	private Date getNextDay() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return  cal.getTime();
	}

	private Date getNextWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, 8);
		return  cal.getTime();
	}


	/**
	 * 判断时间是相同时间段
	 * @param visit
	 * @param visitVo
	 * @return
	 */
	private boolean isEquals(Visit visit,VisitVo visitVo){
		if(visit.getTimeInterval()==visitVo.getTimeInterval()
				&& (getDayStartTime(new Date(visit.getStartTime())).equals(getDayStartTime(new Date(visitVo.getStartTime())))))
			{
				return true;
			}
			return false;
	}

	/**
	 * 删除当前未被预约到的日程
	 * @param visitVo
	 */
	private void delete(VisitVo visitVo){
		Visit visit=new Visit();
		visit.setStartTime(visitVo.getStartTime());
		visit.setDoctorId(visitVo.getDoctorId());
		visit.setEndTime(visitVo.getEndTime());
		visit.setVisitStatus(0);
		visitExtMapper.delete(visit);
	}

	private List<Visit> list(VisitVo visitVo){
		VisitCriteria visitCriteria=new VisitCriteria();
		visitCriteria.createCriteria().andStartTimeGreaterThanOrEqualTo(visitVo.getStartTime()).andEndTimeLessThanOrEqualTo(visitVo.getEndTime()).andDoctorIdEqualTo(visitVo.getDoctorId()).andIsDeleteEqualTo(0);
		visitCriteria.setOrderByClause(" start_time desc ");
		return visitMapper.selectByExample(visitCriteria);
	}

	/**
	 * 获取本月开始时间
	 * 
	 * @return
	 */
	private static Long getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}

	/**
	 * 获取本月结束时间
	 * 
	 * @return
	 */
	private static Long getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}

	/**
	 * 获取本周开始时间
	 * 
	 * @return
	 */
	private static Long getBeginDayOfWeek() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayofweek == 1) {
			dayofweek += 7;
		}
		cal.add(Calendar.DATE, 2 - dayofweek);
		return getDayStartTime(cal.getTime());
	}

	/**
	 * 获取本周结束时间
	 * 
	 * @return
	 */
	private static Long getEndDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(getBeginDayOfWeek()));
		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date weekEndSta = cal.getTime();
		return getDayEndTime(weekEndSta);
	}

	// 获取某个日期的结束时间
	private static Long getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23,
				59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTimeInMillis();
	}

	// 获取某个日期的开始时间
	private static Long getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d)
			calendar.setTime(d);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}

	// 获取今年是哪一年
	private static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}

	// 获取本月是哪一月
	private static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}

}
