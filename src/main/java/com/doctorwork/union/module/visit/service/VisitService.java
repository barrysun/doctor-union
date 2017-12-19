package com.doctorwork.union.module.visit.service;

import java.util.List;

import com.doctorwork.common.result.PageResult;
import com.doctorwork.union.module.visit.bean.Visit;
import com.doctorwork.union.module.visit.vo.VisitRetVo;
import com.doctorwork.union.module.visit.vo.VisitVo;

/**
 * Created by barry on 2017/10/16.
 */
public interface VisitService {

	VisitRetVo monthList(VisitVo visitVo) throws Exception;

	VisitRetVo weekList(VisitVo visitVo) throws Exception;

	VisitVo save(VisitVo visitVo) throws Exception;

	VisitRetVo page(VisitVo visitVo) throws Exception;
}
