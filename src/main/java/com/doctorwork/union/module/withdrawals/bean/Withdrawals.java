package com.doctorwork.union.module.withdrawals.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Withdrawals implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 日期
     */
    private Long withdrawalsDate;

    /**
     * 提现金额
     */
    private BigDecimal withdrawalsMoney;

    /**
     * 提现手续费
     */
    private BigDecimal serviceMoney;

    /**
     * 个税代缴金额
     */
    private BigDecimal personalIncomeTaxMoney;

    /**
     * 实际到账金额
     */
    private BigDecimal arrivalMoney;

    /**
     * 账户余额
     */
    private BigDecimal balance;

    /**
     * 提现状态
     */
    private Integer status;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long modifyTime;

    /**
     * 删除标志
     */
    private Integer isDelete;

    /**
     * doctor id
     */
    private String doctorId;

    /**
     * passport_id
     */
    private String passportId;

    /**
     * 操作人
     */
    private String modifyUserName;

    /**
     * 流水号
     */
    private String serialNumber;

    /**
     * 账单批次
     */
    private String checkBatch;

    /**
     * 钱包订单号
     */
    private String orderNo;

    /**
     * t_withdrawals
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
     * 日期
     * @return withdrawals_date 日期
     */
    public Long getWithdrawalsDate() {
        return withdrawalsDate;
    }

    /**
     * 日期
     * @param withdrawalsDate 日期
     */
    public void setWithdrawalsDate(Long withdrawalsDate) {
        this.withdrawalsDate = withdrawalsDate;
    }

    /**
     * 提现金额
     * @return withdrawals_money 提现金额
     */
    public BigDecimal getWithdrawalsMoney() {
        return withdrawalsMoney;
    }

    /**
     * 提现金额
     * @param withdrawalsMoney 提现金额
     */
    public void setWithdrawalsMoney(BigDecimal withdrawalsMoney) {
        this.withdrawalsMoney = withdrawalsMoney;
    }

    /**
     * 提现手续费
     * @return service_money 提现手续费
     */
    public BigDecimal getServiceMoney() {
        return serviceMoney;
    }

    /**
     * 提现手续费
     * @param serviceMoney 提现手续费
     */
    public void setServiceMoney(BigDecimal serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    /**
     * 个税代缴金额
     * @return personal_income_tax_money 个税代缴金额
     */
    public BigDecimal getPersonalIncomeTaxMoney() {
        return personalIncomeTaxMoney;
    }

    /**
     * 个税代缴金额
     * @param personalIncomeTaxMoney 个税代缴金额
     */
    public void setPersonalIncomeTaxMoney(BigDecimal personalIncomeTaxMoney) {
        this.personalIncomeTaxMoney = personalIncomeTaxMoney;
    }

    /**
     * 实际到账金额
     * @return arrival_money 实际到账金额
     */
    public BigDecimal getArrivalMoney() {
        return arrivalMoney;
    }

    /**
     * 实际到账金额
     * @param arrivalMoney 实际到账金额
     */
    public void setArrivalMoney(BigDecimal arrivalMoney) {
        this.arrivalMoney = arrivalMoney;
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
     * 提现状态
     * @return status 提现状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 提现状态
     * @param status 提现状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 失败原因
     * @return reason 失败原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 失败原因
     * @param reason 失败原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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
     * doctor id
     * @return doctor_id doctor id
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * doctor id
     * @param doctorId doctor id
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
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
     * 操作人
     * @return modify_user_name 操作人
     */
    public String getModifyUserName() {
        return modifyUserName;
    }

    /**
     * 操作人
     * @param modifyUserName 操作人
     */
    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName == null ? null : modifyUserName.trim();
    }

    /**
     * 流水号
     * @return serial_number 流水号
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * 流水号
     * @param serialNumber 流水号
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    /**
     * 账单批次
     * @return check_batch 账单批次
     */
    public String getCheckBatch() {
        return checkBatch;
    }

    /**
     * 账单批次
     * @param checkBatch 账单批次
     */
    public void setCheckBatch(String checkBatch) {
        this.checkBatch = checkBatch == null ? null : checkBatch.trim();
    }

    /**
     * 钱包订单号
     * @return order_no 钱包订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 钱包订单号
     * @param orderNo 钱包订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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
        Withdrawals other = (Withdrawals) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWithdrawalsDate() == null ? other.getWithdrawalsDate() == null : this.getWithdrawalsDate().equals(other.getWithdrawalsDate()))
            && (this.getWithdrawalsMoney() == null ? other.getWithdrawalsMoney() == null : this.getWithdrawalsMoney().equals(other.getWithdrawalsMoney()))
            && (this.getServiceMoney() == null ? other.getServiceMoney() == null : this.getServiceMoney().equals(other.getServiceMoney()))
            && (this.getPersonalIncomeTaxMoney() == null ? other.getPersonalIncomeTaxMoney() == null : this.getPersonalIncomeTaxMoney().equals(other.getPersonalIncomeTaxMoney()))
            && (this.getArrivalMoney() == null ? other.getArrivalMoney() == null : this.getArrivalMoney().equals(other.getArrivalMoney()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getDoctorId() == null ? other.getDoctorId() == null : this.getDoctorId().equals(other.getDoctorId()))
            && (this.getPassportId() == null ? other.getPassportId() == null : this.getPassportId().equals(other.getPassportId()))
            && (this.getModifyUserName() == null ? other.getModifyUserName() == null : this.getModifyUserName().equals(other.getModifyUserName()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getCheckBatch() == null ? other.getCheckBatch() == null : this.getCheckBatch().equals(other.getCheckBatch()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWithdrawalsDate() == null) ? 0 : getWithdrawalsDate().hashCode());
        result = prime * result + ((getWithdrawalsMoney() == null) ? 0 : getWithdrawalsMoney().hashCode());
        result = prime * result + ((getServiceMoney() == null) ? 0 : getServiceMoney().hashCode());
        result = prime * result + ((getPersonalIncomeTaxMoney() == null) ? 0 : getPersonalIncomeTaxMoney().hashCode());
        result = prime * result + ((getArrivalMoney() == null) ? 0 : getArrivalMoney().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getDoctorId() == null) ? 0 : getDoctorId().hashCode());
        result = prime * result + ((getPassportId() == null) ? 0 : getPassportId().hashCode());
        result = prime * result + ((getModifyUserName() == null) ? 0 : getModifyUserName().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getCheckBatch() == null) ? 0 : getCheckBatch().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", withdrawalsDate=").append(withdrawalsDate);
        sb.append(", withdrawalsMoney=").append(withdrawalsMoney);
        sb.append(", serviceMoney=").append(serviceMoney);
        sb.append(", personalIncomeTaxMoney=").append(personalIncomeTaxMoney);
        sb.append(", arrivalMoney=").append(arrivalMoney);
        sb.append(", balance=").append(balance);
        sb.append(", status=").append(status);
        sb.append(", reason=").append(reason);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", passportId=").append(passportId);
        sb.append(", modifyUserName=").append(modifyUserName);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", checkBatch=").append(checkBatch);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}