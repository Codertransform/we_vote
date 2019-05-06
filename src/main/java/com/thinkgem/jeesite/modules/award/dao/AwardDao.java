package com.thinkgem.jeesite.modules.award.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.award.entity.Award;

/**
 * 奖品DAO接口
 * @author hww
 * @version 2019-03-19
 */
@MyBatisDao
public interface AwardDao extends CrudDao<Award> {
	
}