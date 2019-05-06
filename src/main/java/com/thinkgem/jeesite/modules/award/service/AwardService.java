/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.award.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.award.entity.Award;
import com.thinkgem.jeesite.modules.award.dao.AwardDao;

/**
 * 奖品Service
 *
 * @author hww
 * @version 2019-03-19
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AwardService extends CrudService<AwardDao, Award> {
    @Override
    public Award get(String id) {
        return super.get(id);
    }

    @Override
    public List<Award> findList(Award award) {
        return super.findList(award);
    }

    @Override
    public Page<Award> findPage(Page<Award> page, Award award) {
        return super.findPage(page, award);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(Award award) {
        super.save(award);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(Award award) {
        super.delete(award);
    }

}