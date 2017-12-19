package com.doctorwork.union.module.invitation.bean;

import java.io.Serializable;

public class Invitation implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 诊所Id
     */
    private String clinicId;

    /**
     * 经纪人id
     */
    private String agentId;

    /**
     * 专家医生Id
     */
    private String doctorId;

    /**
     * 邀请总金额
     */
    private Long totalPrice;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 邀请状态 0 邀请审核中; 1 审核通过待支付 ；2 审核未通过（拒绝）
     */
    private Integer invitationStatus;

    /**
     * 支付方式 1 微信 2 　支付宝
     */
    private Integer payMethod;

    /**
     * 拒绝原因
     */
    private String reason;

    /**
     * 邀请每半天价格
     */
    private Long onePrice;

    /**
     * 邀请提醒发送状态
     */
    private Integer remindSendStatus;

    /**
     * 邀请提醒发送次数
     */
    private Integer remindSendCount;

    /**
     * 邀请提醒最后发送时间
     */
    private Long remindLastTime;

    /**
     * 删除标记
     */
    private Integer isDelete;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private Long modifyTime;

    /**
     * passport_id
     */
    private String passortId;

    /**
     * t_invitation
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
     * 诊所Id
     * @return clinic_id 诊所Id
     */
    public String getClinicId() {
        return clinicId;
    }

    /**
     * 诊所Id
     * @param clinicId 诊所Id
     */
    public void setClinicId(String clinicId) {
        this.clinicId = clinicId == null ? null : clinicId.trim();
    }

    /**
     * 经纪人id
     * @return agent_id 经纪人id
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * 经纪人id
     * @param agentId 经纪人id
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
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
     * 邀请总金额
     * @return total_price 邀请总金额
     */
    public Long getTotalPrice() {
        return totalPrice;
    }

    /**
     * 邀请总金额
     * @param totalPrice 邀请总金额
     */
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 支付状态
     * @return pay_status 支付状态
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 支付状态
     * @param payStatus 支付状态
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 邀请状态 0 邀请审核中; 1 审核通过待支付 ；2 审核未通过（拒绝）
     * @return invitation_status 邀请状态 0 邀请审核中; 1 审核通过待支付 ；2 审核未通过（拒绝）
     */
    public Integer getInvitationStatus() {
        return invitationStatus;
    }

    /**
     * 邀请状态 0 邀请审核中; 1 审核通过待支付 ；2 审核未通过（拒绝）
     * @param invitationStatus 邀请状态 0 邀请审核中; 1 审核通过待支付 ；2 审核未通过（拒绝）
     */
    public void setInvitationStatus(Integer invitationStatus) {
        this.invitationStatus = invitationStatus;
    }

    /**
     * 支付方式 1 微信 2 　支付宝
     * @return pay_method 支付方式 1 微信 2 　支付宝
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * 支付方式 1 微信 2 　支付宝
     * @param payMethod 支付方式 1 微信 2 　支付宝
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * 拒绝原因
     * @return reason 拒绝原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 拒绝原因
     * @param reason 拒绝原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 邀请每半天价格
     * @return one_price 邀请每半天价格
     */
    public Long getOnePrice() {
        return onePrice;
    }

    /**
     * 邀请每半天价格
     * @param onePrice 邀请每半天价格
     */
    public void setOnePrice(Long onePrice) {
        this.onePrice = onePrice;
    }

    /**
     * 邀请提醒发送状态
     * @return remind_send_status 邀请提醒发送状态
     */
    public Integer getRemindSendStatus() {
        return remindSendStatus;
    }

    /**
     * 邀请提醒发送状态
     * @param remindSendStatus 邀请提醒发送状态
     */
    public void setRemindSendStatus(Integer remindSendStatus) {
        this.remindSendStatus = remindSendStatus;
    }

    /**
     * 邀请提醒发送次数
     * @return remind_send_count 邀请提醒发送次数
     */
    public Integer getRemindSendCount() {
        return remindSendCount;
    }

    /**
     * 邀请提醒发送次数
     * @param remindSendCount 邀请提醒发送次数
     */
    public void setRemindSendCount(Integer remindSendCount) {
        this.remindSendCount = remindSendCount;
    }

    /**
     * 邀请提醒最后发送时间
     * @return remind_last_time 邀请提醒最后发送时间
     */
    public Long getRemindLastTime() {
        return remindLastTime;
    }

    /**
     * 邀请提醒最后发送时间
     * @param remindLastTime 邀请提醒最后发送时间
     */
    public void setRemindLastTime(Long remindLastTime) {
        this.remindLastTime = remindLastTime;
    }

    /**
     * 删除标记
     * @return is_delete 删除标记
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 删除标记
     * @param isDelete 删除标记
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 
     * @return create_time 
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return modify_time 
     */
    public Long getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * passport_id
     * @return passort_id passport_id
     */
    public String getPassortId() {
        return passortId;
    }

    /**
     * passport_id
     * @param passortId passport_id
     */
    public void setPassortId(String passortId) {
        this.passortId = passortId == null ? null : passortId.trim();
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
        Invitation other = (Invitation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClinicId() == null ? other.getClinicId() == null : this.getClinicId().equals(other.getClinicId()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getDoctorId() == null ? other.getDoctorId() == null : this.getDoctorId().equals(other.getDoctorId()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getInvitationStatus() == null ? other.getInvitationStatus() == null : this.getInvitationStatus().equals(other.getInvitationStatus()))
            && (this.getPayMethod() == null ? other.getPayMethod() == null : this.getPayMethod().equals(other.getPayMethod()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getOnePrice() == null ? other.getOnePrice() == null : this.getOnePrice().equals(other.getOnePrice()))
            && (this.getRemindSendStatus() == null ? other.getRemindSendStatus() == null : this.getRemindSendStatus().equals(other.getRemindSendStatus()))
            && (this.getRemindSendCount() == null ? other.getRemindSendCount() == null : this.getRemindSendCount().equals(other.getRemindSendCount()))
            && (this.getRemindLastTime() == null ? other.getRemindLastTime() == null : this.getRemindLastTime().equals(other.getRemindLastTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getPassortId() == null ? other.getPassortId() == null : this.getPassortId().equals(other.getPassortId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClinicId() == null) ? 0 : getClinicId().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getDoctorId() == null) ? 0 : getDoctorId().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getInvitationStatus() == null) ? 0 : getInvitationStatus().hashCode());
        result = prime * result + ((getPayMethod() == null) ? 0 : getPayMethod().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getOnePrice() == null) ? 0 : getOnePrice().hashCode());
        result = prime * result + ((getRemindSendStatus() == null) ? 0 : getRemindSendStatus().hashCode());
        result = prime * result + ((getRemindSendCount() == null) ? 0 : getRemindSendCount().hashCode());
        result = prime * result + ((getRemindLastTime() == null) ? 0 : getRemindLastTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getPassortId() == null) ? 0 : getPassortId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clinicId=").append(clinicId);
        sb.append(", agentId=").append(agentId);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", invitationStatus=").append(invitationStatus);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", reason=").append(reason);
        sb.append(", onePrice=").append(onePrice);
        sb.append(", remindSendStatus=").append(remindSendStatus);
        sb.append(", remindSendCount=").append(remindSendCount);
        sb.append(", remindLastTime=").append(remindLastTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", passortId=").append(passortId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}