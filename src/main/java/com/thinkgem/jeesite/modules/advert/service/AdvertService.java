package com.thinkgem.jeesite.modules.advert.service;

import java.util.List;

import com.thinkgem.jeesite.common.constant.WeTou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.advert.entity.Advert;
import com.thinkgem.jeesite.modules.advert.dao.AdvertDao;

/**
 * 学校广告Service
 *
 * @author hww
 * @version 2019-03-18
 */
@Service
public class AdvertService extends CrudService<AdvertDao, Advert> {

    @Autowired
    private AdvertDao advertDao;

    @Override
    public Advert get(String id) {
        return super.get(id);
    }

    @Override
    public List<Advert> findList(Advert advert) {
        return super.findList(advert);
    }

    @Override
    public Page<Advert> findPage(Page<Advert> page, Advert advert) {
        return super.findPage(page, advert);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(Advert advert) {
        if (advert.getIsNewRecord()) {
            Integer onlineCount = this.getOnlineCount(advert);
            if (onlineCount.equals(WeTou.MAXONLINECOUNT)) {
                advert.setStatus(WeTou.OFFLINE);
                advert.preInsert();
                advertDao.insert(advert);
            } else {
                advert.setStatus(WeTou.ONlINE);
                advert.preInsert();
                advertDao.insert(advert);
            }
        } else {
            advert.preUpdate();
            advertDao.update(advert);
        }
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(Advert advert) {
        super.delete(advert);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public boolean onLine(Advert advert) {
        boolean flag = false;
        Integer onlineCount = this.getOnlineCount(advert);
        if (onlineCount.equals(WeTou.MAXONLINECOUNT)) {
            return flag;
        }
        advert.setStatus(WeTou.ONlINE);
        return advertDao.changeLine(advert);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public boolean offLine(Advert advert) {
        advert.setStatus(WeTou.OFFLINE);
        return advertDao.changeLine(advert);
    }


    private Integer getOnlineCount(Advert advert) {
        advert.setOffice(advert.getCurrentUser().getOffice());
        advert.setStatus(WeTou.ONlINE);
        advert.setDelFlag(WeTou.DEL_FLAG_NORMAL);
        return advertDao.getOnlineCountByOffice(advert);
    }

}