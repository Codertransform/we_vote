package com.thinkgem.jeesite.modules.production.entity;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.modules.activity.entity.Activity;
import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 作品Entity
 *
 * @author hww
 * @version 2019-05-04
 */
public class Production extends DataEntity<Production> {

    private static final long serialVersionUID = 1L;
    private Activity activity;
    private Office office;
    private String image;
    private MobileUser mobileUser;
    private Integer ticket;

    public Production() {
        super();
    }

    public Production(String id) {
        super(id);
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }
}