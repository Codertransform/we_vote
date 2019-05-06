/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.awardcategory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.awardcategory.entity.AwardCategory;
import com.thinkgem.jeesite.modules.awardcategory.dao.AwardCategoryDao;

/**
 * 奖品类别Service
 *
 * @author hww
 * @version 2019-03-19
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AwardCategoryService extends CrudService<AwardCategoryDao, AwardCategory> {
    @Override
    public AwardCategory get(String id) {
        return super.get(id);
    }

    @Override
    public List<AwardCategory> findList(AwardCategory awardCategory) {
        return super.findList(awardCategory);
    }

    @Override
    public Page<AwardCategory> findPage(Page<AwardCategory> page, AwardCategory awardCategory) {
        return super.findPage(page, awardCategory);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(AwardCategory awardCategory) {
        if (awardCategory.getIsNewRecord()) {
            awardCategory.setOffice(awardCategory.getCurrentUser().getOffice());
        }
        super.save(awardCategory);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(AwardCategory awardCategory) {
        super.delete(awardCategory);
    }

}