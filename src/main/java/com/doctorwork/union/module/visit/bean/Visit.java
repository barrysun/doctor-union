package com.doctorwork.union.module.visit.bean;

import java.io.Serializable;

public class Visit implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * 专家医生Id
     */
    private String doctorId;

    /**
     * 是否出诊 1.表示出诊
     */
    private Integer visitStatus;

    /**
     * 是否被邀请 1:被邀请
     */
    private Integer invitationStatus;

    /**
     * 诊所id
     */
    private String clinicId;

    /**
     * 删除标志
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 邀请每天价格
     */
    private Long onePrice;

    /**
     * 
     */
    private String invitationId;

    /**
     * 修改时间
     */
    private Long modifyTime;

    /**
     * 时间段 1:表示上午，2表示下午
     */
    private Integer timeInterval;

    /**
     * t_visit
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * 专家医生Id
     * @return doctor_id 专家医生Id
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * 专家医生Id
     * @param doctorId 专家医生Id
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    /**
     * 是否出诊 1.表示出诊
     * @return visit_status 是否出诊 1.表示出诊
     */
    public Integer getVisitStatus() {
        return visitStatus;
    }

    /**
     * 是否出诊 1.表示出诊
     * @param visitStatus 是否出诊 1.表示出诊
     */
    public void setVisitStatus(Integer visitStatus) {
        this.visitStatus = visitStatus;
    }

    /**
     * 是否被邀请 1:被邀请
     * @return invitation_status 是否被邀请 1:被邀请
     */
    public Integer getInvitationStatus() {
        return invitationStatus;
    }

    /**
     * 是否被邀请 1:被邀请
     * @param invitationStatus 是否被邀请 1:被邀请
     */
    public void setInvitationStatus(Integer invitationStatus) {
        this.invitationStatus = invitationStatus;
    }

    /**
     * 诊所id
     * @return clinic_id 诊所id
     */
    public String getClinicId() {
        return clinicId;
    }

    /**
     * 诊所id
     * @param clinicId 诊所id
     */
    public void setClinicId(String clinicId) {
        this.clinicId = clinicId == null ? null : clinicId.trim();
    }

    /**
     * 删除标志
     * @return is_delete 删除标志
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 删除标志
     * @param isDelete 删除标志
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 邀请每天价格
     * @return one_price 邀请每天价格
     */
    public Long getOnePrice() {
        return onePrice;
    }

    /**
     * 邀请每天价格
     * @param onePrice 邀请每天价格
     */
    public void setOnePrice(Long onePrice) {
        this.onePrice = onePrice;
    }

    /**
     * 
     * @return invitation_id 
     */
    public String getInvitationId() {
        return invitationId;
    }

    /**
     * 
     * @param invitationId 
     */
    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId == null ? null : invitationId.trim();
    }

    /**
     * 修改时间
     * @return modify_time 修改时间
     */
    public Long getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 时间段 1:表示上午，2表示下午
     * @return time_interval 时间段 1:表示上午，2表示下午
     */
    public Integer getTimeInterval() {
        return timeInterval;
    }

    /**
     * 时间段 1:表示上午，2表示下午
     * @param timeInterval 时间段 1:表示上午，2表示下午
     */
    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Visit other = (Visit) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getDoctorId() == null ? other.getDoctorId() == null : this.getDoctorId().equals(other.getDoctorId()))
            && (this.getVisitStatus() == null ? other.getVisitStatus() == null : this.getVisitStatus().equals(other.getVisitStatus()))
            && (this.getInvitationStatus() == null ? other.getInvitationStatus() == null : this.getInvitationStatus().equals(other.getInvitationStatus()))
            && (this.getClinicId() == null ? other.getClinicId() == null : this.getClinicId().equals(other.getClinicId()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOnePrice() == null ? other.getOnePrice() == null : this.getOnePrice().equals(other.getOnePrice()))
            && (this.getInvitationId() == null ? other.getInvitationId() == null : this.getInvitationId().equals(other.getInvitationId()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getTimeInterval() == null ? other.getTimeInterval() == null : this.getTimeInterval().equals(other.getTimeInterval()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getDoctorId() == null) ? 0 : getDoctorId().hashCode());
        result = prime * result + ((getVisitStatus() == null) ? 0 : getVisitStatus().hashCode());
        result = prime * result + ((getInvitationStatus() == null) ? 0 : getInvitationStatus().hashCode());
        result = prime * result + ((getClinicId() == null) ? 0 : getClinicId().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOnePrice() == null) ? 0 : getOnePrice().hashCode());
        result = prime * result + ((getInvitationId() == null) ? 0 : getInvitationId().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getTimeInterval() == null) ? 0 : getTimeInterval().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", visitStatus=").append(visitStatus);
        sb.append(", invitationStatus=").append(invitationStatus);
        sb.append(", clinicId=").append(clinicId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", onePrice=").append(onePrice);
        sb.append(", invitationId=").append(invitationId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", timeInterval=").append(timeInterval);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}