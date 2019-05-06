package com.thinkgem.jeesite.modules.production.service;

import com.thinkgem.jeesite.modules.production.dao.MobileUserDao;
import com.thinkgem.jeesite.modules.production.entity.MobileUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: hww
 * @Date: 2019/5/4 16:38
 */
@Service
public class MobileUserService {
    @Autowired
    private MobileUserDao mobileUserDao;

    public void addMobileUser(MobileUser mobileUser) {
        mobileUserDao.addMobileUser(mobileUser);
    }

    public MobileUser getMobileUser(MobileUser mobileUser) {
        return mobileUserDao.getMobileUser(mobileUser);
    }
}
