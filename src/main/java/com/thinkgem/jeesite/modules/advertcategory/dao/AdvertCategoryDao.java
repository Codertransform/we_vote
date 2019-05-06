package com.thinkgem.jeesite.modules.advertcategory.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.advertcategory.entity.AdvertCategory;

/**
 * 广告类别DAO接口
 * @author hww
 * @version 2019-03-20
 */
@MyBatisDao
public interface AdvertCategoryDao extends CrudDao<AdvertCategory> {
	
}