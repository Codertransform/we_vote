package com.thinkgem.jeesite.modules.advert.entity;

import com.thinkgem.jeesite.modules.advertcategory.entity.AdvertCategory;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学校广告Entity
 *
 * @author hww
 * @version 2019-03-18
 */
public class Advert extends DataEntity<Advert> {

    private static final long serialVersionUID = 1L;
    /**
     * 广告图片
     */
    private String image;
    /**
     * 广告标题
     */
    private String title;
    /**
     * status
     */
    private Integer status;
    /**
     * office_id
     */
    private Office office;
    /**
     * 广告类别
     */
    private AdvertCategory advertCategory;

    @NotNull(message = "广告类别不能为空")
    public AdvertCategory getAdvertCategory() {
        return advertCategory;
    }

    public void setAdvertCategory(AdvertCategory advertCategory) {
        this.advertCategory = advertCategory;
    }

    public Advert() {
        super();
    }

    public Advert(String id) {
        super(id);
    }

    @Length(min = 1, max = 255, message = "广告图片长度必须介于 1 和 255 之间")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Length(min = 1, max = 64, message = "广告标题长度必须介于 1 和 64 之间")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    @Override
    public String toString() {
        return "Advert{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", office=" + office +
                '}';
    }
}