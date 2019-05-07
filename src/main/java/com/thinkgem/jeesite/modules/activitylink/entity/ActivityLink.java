package com.thinkgem.jeesite.modules.activitylink.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.activity.entity.Activity;
import com.thinkgem.jeesite.modules.sys.entity.Office;

/**
 * 活动链接Entity
 *
 * @author hww
 * @version 2019-03-21
 */
public class ActivityLink extends DataEntity<ActivityLink> {

    private static final long serialVersionUID = 1L;
    /**
     * 活动链接
     */
    private String url;
    /**
     * 活动id
     */
    private Activity activity;
    /**
     * 学校id
     */
    private Office office;

    public ActivityLink() {
        super();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}