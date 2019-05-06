package com.thinkgem.jeesite.modules.activity.entity;

import com.thinkgem.jeesite.modules.advertcategory.entity.AdvertCategory;
import com.thinkgem.jeesite.modules.awardcategory.entity.AwardCategory;
import com.thinkgem.jeesite.modules.gitcategory.entity.GitCategory;
import com.thinkgem.jeesite.modules.style.entity.Style;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 活动Entity
 *
 * @author hww
 * @version 2019-03-19
 */
public class Activity extends DataEntity<Activity> {

    private static final long serialVersionUID = 1L;
    /**
     * 活动通知(页面头部滚动)
     */
    private String notify;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 活动规则
     */
    private String rules;
    /**
     * 活动内容
     */
    private String contents;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 广告id
     */
    private AdvertCategory advertCategory;
    /**
     * 奖品id
     */
    private AwardCategory awardCategory;
    /**
     * 礼物id
     */
    private GitCategory gitCategory;
    /**
     * 模板id
     */
    private Style style;
    /**
     * 活动状态(1未开始,2活动中,3已结束)
     */
    private Integer status;
    /**
     * 旧状态
     */
    private Integer oldStatus;
    /**
     * 新状态
     */
    private Integer newStatus;
    /**
     * 平台id
     */

    private Office office;

    public Activity() {
        super();
    }

    public Activity(String id) {
        super(id);
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    @Length(min = 1, max = 255, message = "活动标题长度必须介于 1 和 255 之间")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "开始时间不能为空")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "结束时间不能为空")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public AwardCategory getAwardCategory() {
        return awardCategory;
    }

    public void setAwardCategory(AwardCategory awardCategory) {
        this.awardCategory = awardCategory;
    }

    public GitCategory getGitCategory() {
        return gitCategory;
    }

    public void setGitCategory(GitCategory gitCategory) {
        this.gitCategory = gitCategory;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public AdvertCategory getAdvertCategory() {
        return advertCategory;
    }

    public void setAdvertCategory(AdvertCategory advertCategory) {
        this.advertCategory = advertCategory;
    }

    public Integer getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}