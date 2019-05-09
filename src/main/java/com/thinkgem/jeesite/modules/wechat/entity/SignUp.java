package com.thinkgem.jeesite.modules.wechat.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.springframework.web.multipart.MultipartFile;

public class SignUp extends DataEntity<SignUp> {
    private String name;
    private String email;
    private String tel;
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
