package com.thinkgem.jeesite.modules.advertcategory.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 广告类别Entity
 *
 * @author hww
 * @version 2019-03-20
 */
public class AdvertCategory extends DataEntity<AdvertCategory> {

    private static final long serialVersionUID = 1L;
    /**
     * 广告类别名称
     */
    private String name;
    /**
     * 平台id
     */
    private Office office;

    public AdvertCategory() {
        super();
    }

    public AdvertCategory(String id) {
        super(id);
    }

    @Length(min = 1, max = 64, message = "广告类别名称长度必须介于 1 和 64 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

}