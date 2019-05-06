package com.thinkgem.jeesite.modules.activity.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.activity.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动DAO接口
 *
 * @author hww
 * @version 2019-03-19
 */
@MyBatisDao
public interface ActivityDao extends CrudDao<Activity> {
    /**
     * 更新活动状态
     *
     * @param activity
     */
    void updateActivityStatus(Activity activity);

    /**
     * 查询所有活动
     *
     * @param activity
     * @return
     */
    List<Activity> findActivityList(Activity activity);


}