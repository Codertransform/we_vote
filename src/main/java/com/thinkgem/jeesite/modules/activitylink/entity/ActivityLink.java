package com.thinkgem.jeesite.modules.activitylink.entity;

import com.thinkgem.jeesite.modules.activity.entity.Activity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 活动链接Entity
 *
 * @author hww
 * @version 2019-03-21
 */
@Data
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


}