package com.thinkgem.jeesite.modules.git.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.git.entity.Git;

/**
 * 礼物DAO接口
 * @author hww
 * @version 2019-03-19
 */
@MyBatisDao
public interface GitDao extends CrudDao<Git> {
	
}