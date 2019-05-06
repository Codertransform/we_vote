package com.thinkgem.jeesite.modules.gitcategory.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.gitcategory.entity.GitCategory;

/**
 * 礼物类别DAO接口
 * @author hww
 * @version 2019-03-19
 */
@MyBatisDao
public interface GitCategoryDao extends CrudDao<GitCategory> {
	
}