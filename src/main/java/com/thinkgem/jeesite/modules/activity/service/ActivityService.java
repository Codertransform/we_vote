package com.thinkgem.jeesite.modules.activity.service;

import java.util.Date;
import java.util.List;

import com.thinkgem.jeesite.common.constant.WeTou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.activity.entity.Activity;
import com.thinkgem.jeesite.modules.activity.dao.ActivityDao;

/**
 * 活动Service
 *
 * @author hww
 * @version 2019-03-19
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ActivityService extends CrudService<ActivityDao, Activity> {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public Activity get(String id) {
        return super.get(id);
    }

    @Override
    public List<Activity> findList(Activity activity) {
        return super.findList(activity);
    }

    @Override
    public Page<Activity> findPage(Page<Activity> page, Activity activity) {
        return super.findPage(page, activity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(Activity activity) {
        if (activity.getIsNewRecord()) {
            activity.setOffice(activity.getCurrentUser().getOffice());
            if (activity.getStartTime().before(new Date())) {
                activity.setStatus(WeTou.ALREADSTART);
            } else if (activity.getStartTime().after(new Date())) {
                activity.setStatus(WeTou.NOTSTART);
            }
        }
        super.save(activity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(Activity activity) {
        super.delete(activity);
    }


    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void updateActivityStatus(Activity activity) {

        activityDao.updateActivityStatus(activity);
    }

    public List<Activity> findActivityList(Activity activity) {

        return activityDao.findActivityList(activity);
    }

}