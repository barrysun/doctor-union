package com.doctorwork.union.common.utils;

/**
 * Created by barry on 2017/10/19.
 */
public enum  Role {
    DEFAULT("0","默认值"),
    ADMIN("1","管理员"),
    AGENT("2","经纪人"),
    DOCTOR("3","医生");
    private String roleId;
    private String roleName;
    private Role(String roleId,String roleName){
        this.roleId=roleId;
        this.roleName= roleName;
    }
    private Role(){

    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
