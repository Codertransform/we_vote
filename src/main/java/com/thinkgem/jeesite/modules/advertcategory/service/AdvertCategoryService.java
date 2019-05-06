package com.thinkgem.jeesite.modules.advertcategory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.advertcategory.entity.AdvertCategory;
import com.thinkgem.jeesite.modules.advertcategory.dao.AdvertCategoryDao;

/**
 * 广告类别Service
 *
 * @author hww
 * @version 2019-03-20
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AdvertCategoryService extends CrudService<AdvertCategoryDao, AdvertCategory> {
    @Override
    public AdvertCategory get(String id) {
        return super.get(id);
    }

    @Override
    public List<AdvertCategory> findList(AdvertCategory advertCategory) {
        return super.findList(advertCategory);
    }

    @Override
    public Page<AdvertCategory> findPage(Page<AdvertCategory> page, AdvertCategory advertCategory) {
        return super.findPage(page, advertCategory);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(AdvertCategory advertCategory) {
        if (advertCategory.getIsNewRecord()) {
            advertCategory.setOffice(advertCategory.getCurrentUser().getOffice());
        }
        super.save(advertCategory);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(AdvertCategory advertCategory) {
        super.delete(advertCategory);
    }

}