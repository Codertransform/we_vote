/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.style.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.style.entity.Style;
import com.thinkgem.jeesite.modules.style.dao.StyleDao;

/**
 * 模板Service
 *
 * @author hww
 * @version 2019-03-24
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StyleService extends CrudService<StyleDao, Style> {
    @Override
    public Style get(String id) {
        return super.get(id);
    }

    @Override
    public List<Style> findList(Style style) {
        return super.findList(style);
    }

    @Override
    public Page<Style> findPage(Page<Style> page, Style style) {
        return super.findPage(page, style);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(Style style) {
        if (style.getIsNewRecord()) {
            style.setOffice(style.getCurrentUser().getOffice());
        }
        super.save(style);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(Style style) {
        super.delete(style);
    }

}