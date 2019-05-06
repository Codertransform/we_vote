package com.thinkgem.jeesite.modules.activitylink.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.activitylink.entity.ActivityLink;

/**
 * 活动链接DAO接口
 * @author hww
 * @version 2019-03-21
 */
@MyBatisDao
public interface ActivityLinkDao extends CrudDao<ActivityLink> {

    /**
     * 查询是否已经生成过该链接
     *
     * @param activityLink
     * @return
     */
    ActivityLink getActivityLink(ActivityLink activityLink);
}