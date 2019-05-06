package com.thinkgem.jeesite.modules.production.entity;

import java.io.Serializable;

/**
 * @Author: hww
 * @Date: 2019/5/4 15:45
 */

public class MobileUser implements Serializable {

    private Integer id;
    private String username;
    private String email;
    private String phone;
    private String password;

    public MobileUser(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public MobileUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
