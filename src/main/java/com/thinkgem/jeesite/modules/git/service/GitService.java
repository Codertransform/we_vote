/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.git.service;

import java.util.List;

import com.thinkgem.jeesite.modules.gitcategory.entity.GitCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.git.entity.Git;
import com.thinkgem.jeesite.modules.git.dao.GitDao;

/**
 * 礼物Service
 *
 * @author hww
 * @version 2019-03-19
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class GitService extends CrudService<GitDao, Git> {
    @Override
    public Git get(String id) {
        return super.get(id);
    }

    @Override
    public List<Git> findList(Git git) {
        return super.findList(git);
    }

    @Override
    public Page<Git> findPage(Page<Git> page, Git git) {
        return super.findPage(page, git);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(Git git) {
        super.save(git);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(Git git) {
        super.delete(git);
    }

}