package com.thinkgem.jeesite.modules.production.dao;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.production.entity.MobileUser;

/**
 * @Author: hww
 * @Date: 2019/5/4 16:32
 */
@MyBatisDao
public interface MobileUserDao {

    void addMobileUser(MobileUser mobileUser);

    MobileUser getMobileUser(MobileUser mobileUser);
}
