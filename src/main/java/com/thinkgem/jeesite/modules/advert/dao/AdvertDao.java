/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.advert.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.advert.entity.Advert;

import java.util.List;

/**
 * 学校广告DAO接口
 *
 * @author hww
 * @version 2019-03-18
 */
@MyBatisDao
public interface AdvertDao extends CrudDao<Advert> {
    /**
     * 根据office查找Advert
     *
     * @param entity
     * @return
     */

    Integer getOnlineCountByOffice(Advert entity);

    /**
     * 上下线
     *
     * @param advert
     * @return
     */
    boolean changeLine(Advert advert);
}