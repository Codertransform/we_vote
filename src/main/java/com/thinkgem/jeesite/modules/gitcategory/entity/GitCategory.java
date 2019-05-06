package com.thinkgem.jeesite.modules.gitcategory.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 礼物类别Entity
 *
 * @author hww
 * @version 2019-03-19
 */
public class GitCategory extends DataEntity<GitCategory> {

    private static final long serialVersionUID = 1L;
    /**
     * 类别名称
     */
    private String name;
    /**
     * 类别图片
     */
    private String image;
    /**
     * 平台id
     */
    private Office office;

    public GitCategory() {
        super();
    }

    public GitCategory(String id) {
        super(id);
    }

    @Length(min = 1, max = 64, message = "类别名称长度必须介于 1 和 64 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "GitCategory{" +
                "id='" + id + '\'' +
                '}';
    }
}