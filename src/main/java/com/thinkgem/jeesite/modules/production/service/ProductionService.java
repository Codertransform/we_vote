package com.thinkgem.jeesite.modules.production.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.production.entity.Production;
import com.thinkgem.jeesite.modules.production.dao.ProductionDao;

/**
 * 作品Service
 *
 * @author hww
 * @version 2019-05-04
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductionService extends CrudService<ProductionDao, Production> {

    @Autowired
    private ProductionDao productionDao;

    @Override
    public Production get(String id) {
        return super.get(id);
    }

    @Override
    public List<Production> findList(Production production) {
        return super.findList(production);
    }

    @Override
    public Page<Production> findPage(Page<Production> page, Production production) {
        return super.findPage(page, production);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(Production production) {
        if (production.getIsNewRecord()) {
            production.setOffice(production.getActivity().getOffice());
        }
        super.save(production);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(Production production) {
        super.delete(production);
    }


    public  List<Production> fingAllProductions(String activityId) {
        return productionDao.fingAllProductions(activityId);
    }

}