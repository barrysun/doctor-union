package com.doctorwork.union.module.doctor.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Doctor implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 经济人Id
     */
    private String agentId;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 医生头像
     */
    private String doctorAvatar;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 所属医院
     */
    private String hospital;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 职称
     */
    private String title;

    /**
     * 擅长
     */
    private String specialty;

    /**
     * 简介
     */
    private String note;

    /**
     * 坐诊费用
     */
    private Long workPrice;

    /**
     * 挂号费
     */
    private Long orderPrice;

    /**
     * 账号状态 1 启动 2是停用
     */
    private Integer accountStatus;

    /**
     * 擅长状态
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
     * 邀请次数
     */
    private Integer invitationCount;

    /**
     * 户主账号
     */
    private String cardUserName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 卡号
     */
    private String cardNumber;

    /**
     * 开户行
     */
    private String cardBank;

    /**
     * passport_id
     */
    private String passportId;

    /**
     * 平台抽成
     */
    private BigDecimal platformRebate;

    /**
     * t_doctor
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
     * 经济人Id
     * @return agent_id 经济人Id
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * 经济人Id
     * @param agentId 经济人Id
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    /**
     * 医生姓名
     * @return doctor_name 医生姓名
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * 医生姓名
     * @param doctorName 医生姓名
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    /**
     * 医生头像
     * @return doctor_avatar 医生头像
     */
    public String getDoctorAvatar() {
        return doctorAvatar;
    }

    /**
     * 医生头像
     * @param doctorAvatar 医生头像
     */
    public void setDoctorAvatar(String doctorAvatar) {
        this.doctorAvatar = doctorAvatar == null ? null : doctorAvatar.trim();
    }

    /**
     * 性别
     * @return sex 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 手机号码
     * @return phone 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 所属医院
     * @return hospital 所属医院
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * 所属医院
     * @param hospital 所属医院
     */
    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    /**
     * 所属部门
     * @return department 所属部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 所属部门
     * @param department 所属部门
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * 职称
     * @return title 职称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 职称
     * @param title 职称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 擅长
     * @return specialty 擅长
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * 擅长
     * @param specialty 擅长
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    /**
     * 简介
     * @return note 简介
     */
    public String getNote() {
        return note;
    }

    /**
     * 简介
     * @param note 简介
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 坐诊费用
     * @return work_price 坐诊费用
     */
    public Long getWorkPrice() {
        return workPrice;
    }

    /**
     * 坐诊费用
     * @param workPrice 坐诊费用
     */
    public void setWorkPrice(Long workPrice) {
        this.workPrice = workPrice;
    }

    /**
     * 挂号费
     * @return order_price 挂号费
     */
    public Long getOrderPrice() {
        return orderPrice;
    }

    /**
     * 挂号费
     * @param orderPrice 挂号费
     */
    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 账号状态 1 启动 2是停用
     * @return account_status 账号状态 1 启动 2是停用
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * 账号状态 1 启动 2是停用
     * @param accountStatus 账号状态 1 启动 2是停用
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 擅长状态
     * @return is_delete 擅长状态
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 擅长状态
     * @param isDelete 擅长状态
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
     * 邀请次数
     * @return invitation_count 邀请次数
     */
    public Integer getInvitationCount() {
        return invitationCount;
    }

    /**
     * 邀请次数
     * @param invitationCount 邀请次数
     */
    public void setInvitationCount(Integer invitationCount) {
        this.invitationCount = invitationCount;
    }

    /**
     * 户主账号
     * @return card_user_name 户主账号
     */
    public String getCardUserName() {
        return cardUserName;
    }

    /**
     * 户主账号
     * @param cardUserName 户主账号
     */
    public void setCardUserName(String cardUserName) {
        this.cardUserName = cardUserName == null ? null : cardUserName.trim();
    }

    /**
     * 身份证号
     * @return id_card 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证号
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 卡号
     * @return card_number 卡号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 卡号
     * @param cardNumber 卡号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    /**
     * 开户行
     * @return card_bank 开户行
     */
    public String getCardBank() {
        return cardBank;
    }

    /**
     * 开户行
     * @param cardBank 开户行
     */
    public void setCardBank(String cardBank) {
        this.cardBank = cardBank == null ? null : cardBank.trim();
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
     * 平台抽成
     * @return platform_rebate 平台抽成
     */
    public BigDecimal getPlatformRebate() {
        return platformRebate;
    }

    /**
     * 平台抽成
     * @param platformRebate 平台抽成
     */
    public void setPlatformRebate(BigDecimal platformRebate) {
        this.platformRebate = platformRebate;
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
        Doctor other = (Doctor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getDoctorName() == null ? other.getDoctorName() == null : this.getDoctorName().equals(other.getDoctorName()))
            && (this.getDoctorAvatar() == null ? other.getDoctorAvatar() == null : this.getDoctorAvatar().equals(other.getDoctorAvatar()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getHospital() == null ? other.getHospital() == null : this.getHospital().equals(other.getHospital()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSpecialty() == null ? other.getSpecialty() == null : this.getSpecialty().equals(other.getSpecialty()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getWorkPrice() == null ? other.getWorkPrice() == null : this.getWorkPrice().equals(other.getWorkPrice()))
            && (this.getOrderPrice() == null ? other.getOrderPrice() == null : this.getOrderPrice().equals(other.getOrderPrice()))
            && (this.getAccountStatus() == null ? other.getAccountStatus() == null : this.getAccountStatus().equals(other.getAccountStatus()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getInvitationCount() == null ? other.getInvitationCount() == null : this.getInvitationCount().equals(other.getInvitationCount()))
            && (this.getCardUserName() == null ? other.getCardUserName() == null : this.getCardUserName().equals(other.getCardUserName()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getCardNumber() == null ? other.getCardNumber() == null : this.getCardNumber().equals(other.getCardNumber()))
            && (this.getCardBank() == null ? other.getCardBank() == null : this.getCardBank().equals(other.getCardBank()))
            && (this.getPassportId() == null ? other.getPassportId() == null : this.getPassportId().equals(other.getPassportId()))
            && (this.getPlatformRebate() == null ? other.getPlatformRebate() == null : this.getPlatformRebate().equals(other.getPlatformRebate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getDoctorName() == null) ? 0 : getDoctorName().hashCode());
        result = prime * result + ((getDoctorAvatar() == null) ? 0 : getDoctorAvatar().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getHospital() == null) ? 0 : getHospital().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSpecialty() == null) ? 0 : getSpecialty().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getWorkPrice() == null) ? 0 : getWorkPrice().hashCode());
        result = prime * result + ((getOrderPrice() == null) ? 0 : getOrderPrice().hashCode());
        result = prime * result + ((getAccountStatus() == null) ? 0 : getAccountStatus().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getInvitationCount() == null) ? 0 : getInvitationCount().hashCode());
        result = prime * result + ((getCardUserName() == null) ? 0 : getCardUserName().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getCardNumber() == null) ? 0 : getCardNumber().hashCode());
        result = prime * result + ((getCardBank() == null) ? 0 : getCardBank().hashCode());
        result = prime * result + ((getPassportId() == null) ? 0 : getPassportId().hashCode());
        result = prime * result + ((getPlatformRebate() == null) ? 0 : getPlatformRebate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", agentId=").append(agentId);
        sb.append(", doctorName=").append(doctorName);
        sb.append(", doctorAvatar=").append(doctorAvatar);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", hospital=").append(hospital);
        sb.append(", department=").append(department);
        sb.append(", title=").append(title);
        sb.append(", specialty=").append(specialty);
        sb.append(", note=").append(note);
        sb.append(", workPrice=").append(workPrice);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", accountStatus=").append(accountStatus);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", invitationCount=").append(invitationCount);
        sb.append(", cardUserName=").append(cardUserName);
        sb.append(", idCard=").append(idCard);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", cardBank=").append(cardBank);
        sb.append(", passportId=").append(passportId);
        sb.append(", platformRebate=").append(platformRebate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}