package com.thinkgem.jeesite.modules.awardcategory.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.awardcategory.entity.AwardCategory;

/**
 * 奖品类别DAO接口
 * @author hww
 * @version 2019-03-19
 */
@MyBatisDao
public interface AwardCategoryDao extends CrudDao<AwardCategory> {
	
}