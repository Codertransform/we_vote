package com.thinkgem.jeesite.modules.gitcategory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.gitcategory.entity.GitCategory;
import com.thinkgem.jeesite.modules.gitcategory.dao.GitCategoryDao;

/**
 * 礼物类别Service
 *
 * @author hww
 * @version 2019-03-19
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class GitCategoryService extends CrudService<GitCategoryDao, GitCategory> {
    @Override
    public GitCategory get(String id) {
        return super.get(id);
    }

    @Override
    public List<GitCategory> findList(GitCategory gitCategory) {
        return super.findList(gitCategory);
    }

    @Override
    public Page<GitCategory> findPage(Page<GitCategory> page, GitCategory gitCategory) {
        return super.findPage(page, gitCategory);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(GitCategory gitCategory) {
        if (gitCategory.getIsNewRecord()) {
            gitCategory.setOffice(gitCategory.getCurrentUser().getOffice());
        }
        super.save(gitCategory);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(GitCategory gitCategory) {
        super.delete(gitCategory);
    }

}