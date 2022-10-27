package com.cybersoft.crm.model;

public class UsersModel {
    private int id;
    private String email;
    private String password;
    private String fullName;
    private String avatar;
    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFirstName() {
        int idx = fullName.lastIndexOf(' ');
        if (idx == -1) {
            return fullName;
        }
        return fullName.substring(0, idx);
    }

    public String getLastName() {
        int idx = fullName.lastIndexOf(' ');
        if (idx == -1) {
            return fullName;
        }
        return fullName.substring(idx + 1);
    }

    public String getRole() {
        if (this.roleId == 1) {
            return "Quản lý trang";
        } else if (this.roleId == 2) {
            return "Quản lý";
        } else return "Nhân viên";
    }
}
