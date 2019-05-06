package com.thinkgem.jeesite.modules.activity.quartz;

import com.thinkgem.jeesite.common.constant.WeTou;
import com.thinkgem.jeesite.modules.activity.entity.Activity;
import com.thinkgem.jeesite.modules.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: hww
 * @Date: 2019/3/20 17:23
 */
//@Service
//@Lazy(false)
public class ActivityQuartz {

    @Autowired
    private ActivityService activityService;

    @Scheduled(cron = "0 */1 * * * ? ")
    protected void updateActivityStartStatus() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Activity activity = new Activity();
        //查询还未开始的活动
        activity.setStatus(WeTou.NOTSTART);
        List<Activity> activityList = activityService.findActivityList(activity);
        if (activityList != null) {
            //遍历活动
            for (Activity item : activityList) {
                boolean flagStartTime = sf.format(item.getStartTime()).equals(sf.format(new Date()));
                if (flagStartTime) {
                    activity.setOldStatus(WeTou.NOTSTART);
                    activity.setNewStatus(WeTou.ALREADSTART);
                    activityService.updateActivityStatus(activity);
                }
            }
        }
        System.out.println(sf.format(new Date()) + "完成");

    }


    @Scheduled(cron = "0 */1 * * * ? ")
    protected void updateActivityStartEnd() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Activity activity = new Activity();
        //查出正在开始的活动
        activity.setStatus(WeTou.ALREADSTART);
        List<Activity> activityList = activityService.findActivityList(activity);
        if (activityList != null) {
            //遍历活动
            for (Activity item : activityList) {
                boolean flagEndTime = sf.format(item.getEndTime()).equals(sf.format(new Date()));
                if (flagEndTime) {
                    activity.setOldStatus(WeTou.ALREADSTART);
                    activity.setNewStatus(WeTou.ALREADEND);
                    activityService.updateActivityStatus(activity);
                }
            }
        }

        System.out.println(sf.format(new Date()) + "完成");

    }
}
