package com.thinkgem.jeesite.modules.awardcategory.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 奖品类别Entity
 *
 * @author hww
 * @version 2019-03-19
 */
public class AwardCategory extends DataEntity<AwardCategory> {

    private static final long serialVersionUID = 1L;
    /**
     * 类别名称
     */
    private String name;
    /**
     * 平台id
     */
    private Office office;

    public AwardCategory() {
        super();
    }

    public AwardCategory(String id) {
        super(id);
    }

    @Length(min = 1, max = 64, message = "类别名称长度必须介于 1 和 64 之间")
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