package com.thinkgem.jeesite.modules.style.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.style.entity.Style;

/**
 * 模板DAO接口
 * @author hww
 * @version 2019-03-24
 */
@MyBatisDao
public interface StyleDao extends CrudDao<Style> {
	
}