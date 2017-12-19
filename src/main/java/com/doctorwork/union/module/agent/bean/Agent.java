package com.doctorwork.union.module.agent.bean;

import java.io.Serializable;

public class Agent implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 经纪人姓名
     */
    private String userName;

    /**
     * 
     */
    private Integer sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 备注
     */
    private String note;

    /**
     * 账号状态
     */
    private Integer accountStatus;

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
     * 
     */
    private String createUserId;

    /**
     * 
     */
    private String createUserName;

    /**
     * 微信OpenId
     */
    private String openId;

    /**
     * t_agent
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
     * 经纪人姓名
     * @return user_name 经纪人姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 经纪人姓名
     * @param userName 经纪人姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @return sex 
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 
     * @param sex 
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
     * 备注
     * @return note 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 备注
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 账号状态
     * @return account_status 账号状态
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * 账号状态
     * @param accountStatus 账号状态
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
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
     * 
     * @return create_user_id 
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 
     * @param createUserId 
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * 
     * @return create_user_name 
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 
     * @param createUserName 
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 微信OpenId
     * @return open_id 微信OpenId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 微信OpenId
     * @param openId 微信OpenId
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
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
        Agent other = (Agent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getAccountStatus() == null ? other.getAccountStatus() == null : this.getAccountStatus().equals(other.getAccountStatus()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getPassportId() == null ? other.getPassportId() == null : this.getPassportId().equals(other.getPassportId()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getAccountStatus() == null) ? 0 : getAccountStatus().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getPassportId() == null) ? 0 : getPassportId().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", note=").append(note);
        sb.append(", accountStatus=").append(accountStatus);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", passportId=").append(passportId);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", openId=").append(openId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}