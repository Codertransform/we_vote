package com.thinkgem.jeesite.modules.production.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.production.entity.Production;

import java.util.List;

/**
 * 作品DAO接口
 * @author hww
 * @version 2019-05-04
 */
@MyBatisDao
public interface ProductionDao extends CrudDao<Production> {



    List<Production> fingAllProductions(String activityId);
}