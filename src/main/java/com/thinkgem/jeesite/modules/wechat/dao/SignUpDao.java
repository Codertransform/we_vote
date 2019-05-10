package com.thinkgem.jeesite.modules.wechat.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wechat.entity.SignUp;

@MyBatisDao
public interface SignUpDao extends CrudDao<SignUp> {
}
