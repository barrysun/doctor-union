package com.doctorwork.union.module.admin.bean;

import java.io.Serializable;

public class Admin implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String passportId;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private Long modifyTime;

    /**
     * 
     */
    private Integer isDelete;

    /**
     * 
     */
    private String phone;

    /**
     * t_admin
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @return passport_id 
     */
    public String getPassportId() {
        return passportId;
    }

    /**
     * 
     * @param passportId 
     */
    public void setPassportId(String passportId) {
        this.passportId = passportId == null ? null : passportId.trim();
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
     * 
     * @return is_delete 
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 
     * @param isDelete 
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 
     * @return phone 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone 
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
        Admin other = (Admin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassportId() == null ? other.getPassportId() == null : this.getPassportId().equals(other.getPassportId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassportId() == null) ? 0 : getPassportId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
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
        sb.append(", passportId=").append(passportId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}