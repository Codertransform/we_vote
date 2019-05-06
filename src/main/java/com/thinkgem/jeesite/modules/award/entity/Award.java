package com.thinkgem.jeesite.modules.award.entity;

import com.thinkgem.jeesite.modules.awardcategory.entity.AwardCategory;
import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 奖品Entity
 *
 * @author hww
 * @version 2019-03-19
 */
public class Award extends DataEntity<Award> {

    private static final long serialVersionUID = 1L;
    /**
     * 奖品名称
     */
    private String name;
    /**
     * 奖项
     */
    private Integer item;
    /**
     * 奖品图片
     */
    private String image;
    /**
     * 奖项数量
     */
    private Integer itemCount;
    /**
     * 奖品类别
     */
    private AwardCategory awardCategory;

    public Award() {
        super();
    }

    public Award(String id) {
        super(id);
    }

    @Length(min = 1, max = 64, message = "奖品名称长度必须介于 1 和 64 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 0, max = 1024, message = "奖品图片长度必须介于 0 和 1024 之间")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public AwardCategory getAwardCategory() {
        return awardCategory;
    }

    public void setAwardCategory(AwardCategory awardCategory) {
        this.awardCategory = awardCategory;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
}