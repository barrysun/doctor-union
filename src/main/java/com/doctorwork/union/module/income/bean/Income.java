package com.doctorwork.union.module.income.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Income implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 交易流水号
     */
    private String serialNumber;

    /**
     * 交易日期
     */
    private Long incomeDate;

    /**
     * 支付账号
     */
    private String payAccount;

    /**
     * 诊所id
     */
    private String clinicId;

    /**
     * 支付金额
     */
    private BigDecimal payMoney;

    /**
     * 交易手续费
     */
    private BigDecimal serviceMoney;

    /**
     * 平台抽层
     */
    private BigDecimal platformMoney;

    /**
     * 我的收入
     */
    private BigDecimal incomonMoney;

    /**
     * 账户余额
     */
    private BigDecimal balance;

    /**
     * 删除标志
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long modifyTime;

    /**
     * passport_id
     */
    private String passportId;

    /**
     * 医生Id
     */
    private String doctorId;

    /**
     * 邀请id
     */
    private String invitationId;

    /**
     * t_income
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
     * 交易流水号
     * @return serial_number 交易流水号
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * 交易流水号
     * @param serialNumber 交易流水号
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    /**
     * 交易日期
     * @return income_date 交易日期
     */
    public Long getIncomeDate() {
        return incomeDate;
    }

    /**
     * 交易日期
     * @param incomeDate 交易日期
     */
    public void setIncomeDate(Long incomeDate) {
        this.incomeDate = incomeDate;
    }

    /**
     * 支付账号
     * @return pay_account 支付账号
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * 支付账号
     * @param payAccount 支付账号
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount == null ? null : payAccount.trim();
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
     * 支付金额
     * @return pay_money 支付金额
     */
    public BigDecimal getPayMoney() {
        return payMoney;
    }

    /**
     * 支付金额
     * @param payMoney 支付金额
     */
    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * 交易手续费
     * @return service_money 交易手续费
     */
    public BigDecimal getServiceMoney() {
        return serviceMoney;
    }

    /**
     * 交易手续费
     * @param serviceMoney 交易手续费
     */
    public void setServiceMoney(BigDecimal serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    /**
     * 平台抽层
     * @return platform_money 平台抽层
     */
    public BigDecimal getPlatformMoney() {
        return platformMoney;
    }

    /**
     * 平台抽层
     * @param platformMoney 平台抽层
     */
    public void setPlatformMoney(BigDecimal platformMoney) {
        this.platformMoney = platformMoney;
    }

    /**
     * 我的收入
     * @return incomon_money 我的收入
     */
    public BigDecimal getIncomonMoney() {
        return incomonMoney;
    }

    /**
     * 我的收入
     * @param incomonMoney 我的收入
     */
    public void setIncomonMoney(BigDecimal incomonMoney) {
        this.incomonMoney = incomonMoney;
    }

    /**
     * 账户余额
     * @return balance 账户余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 账户余额
     * @param balance 账户余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
     * passport_id
     * @return passport_id passport_id
     */
    public String getPassportId() {
        return passportId;
    }

    /**
     * passport_id
     * @param passportId passport_id
     */
    public void setPassportId(String passportId) {
        this.passportId = passportId == null ? null : passportId.trim();
    }

    /**
     * 医生Id
     * @return doctor_id 医生Id
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * 医生Id
     * @param doctorId 医生Id
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    /**
     * 邀请id
     * @return invitation_id 邀请id
     */
    public String getInvitationId() {
        return invitationId;
    }

    /**
     * 邀请id
     * @param invitationId 邀请id
     */
    public void setInvitationId(String invitationId) {
        this.invitationId = invitationId == null ? null : invitationId.trim();
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
        Income other = (Income) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getIncomeDate() == null ? other.getIncomeDate() == null : this.getIncomeDate().equals(other.getIncomeDate()))
            && (this.getPayAccount() == null ? other.getPayAccount() == null : this.getPayAccount().equals(other.getPayAccount()))
            && (this.getClinicId() == null ? other.getClinicId() == null : this.getClinicId().equals(other.getClinicId()))
            && (this.getPayMoney() == null ? other.getPayMoney() == null : this.getPayMoney().equals(other.getPayMoney()))
            && (this.getServiceMoney() == null ? other.getServiceMoney() == null : this.getServiceMoney().equals(other.getServiceMoney()))
            && (this.getPlatformMoney() == null ? other.getPlatformMoney() == null : this.getPlatformMoney().equals(other.getPlatformMoney()))
            && (this.getIncomonMoney() == null ? other.getIncomonMoney() == null : this.getIncomonMoney().equals(other.getIncomonMoney()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getPassportId() == null ? other.getPassportId() == null : this.getPassportId().equals(other.getPassportId()))
            && (this.getDoctorId() == null ? other.getDoctorId() == null : this.getDoctorId().equals(other.getDoctorId()))
            && (this.getInvitationId() == null ? other.getInvitationId() == null : this.getInvitationId().equals(other.getInvitationId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getIncomeDate() == null) ? 0 : getIncomeDate().hashCode());
        result = prime * result + ((getPayAccount() == null) ? 0 : getPayAccount().hashCode());
        result = prime * result + ((getClinicId() == null) ? 0 : getClinicId().hashCode());
        result = prime * result + ((getPayMoney() == null) ? 0 : getPayMoney().hashCode());
        result = prime * result + ((getServiceMoney() == null) ? 0 : getServiceMoney().hashCode());
        result = prime * result + ((getPlatformMoney() == null) ? 0 : getPlatformMoney().hashCode());
        result = prime * result + ((getIncomonMoney() == null) ? 0 : getIncomonMoney().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getPassportId() == null) ? 0 : getPassportId().hashCode());
        result = prime * result + ((getDoctorId() == null) ? 0 : getDoctorId().hashCode());
        result = prime * result + ((getInvitationId() == null) ? 0 : getInvitationId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", incomeDate=").append(incomeDate);
        sb.append(", payAccount=").append(payAccount);
        sb.append(", clinicId=").append(clinicId);
        sb.append(", payMoney=").append(payMoney);
        sb.append(", serviceMoney=").append(serviceMoney);
        sb.append(", platformMoney=").append(platformMoney);
        sb.append(", incomonMoney=").append(incomonMoney);
        sb.append(", balance=").append(balance);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", passportId=").append(passportId);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", invitationId=").append(invitationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}