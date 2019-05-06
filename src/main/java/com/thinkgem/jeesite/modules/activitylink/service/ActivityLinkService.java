package com.thinkgem.jeesite.modules.activitylink.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.activitylink.entity.ActivityLink;
import com.thinkgem.jeesite.modules.activitylink.dao.ActivityLinkDao;

import javax.servlet.http.HttpServletRequest;

/**
 * 活动链接Service
 *
 * @author hww
 * @version 2019-03-21
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ActivityLinkService extends CrudService<ActivityLinkDao, ActivityLink> {

    @Value("${mobilePath}")
    private String mobilePath;
    @Autowired
    private ActivityLinkDao activityLinkDao;

    @Override
    public ActivityLink get(String id) {
        return super.get(id);
    }

    @Override
    public List<ActivityLink> findList(ActivityLink activityLink) {
        return super.findList(activityLink);
    }

    @Override
    public Page<ActivityLink> findPage(Page<ActivityLink> page, ActivityLink activityLink) {
        return super.findPage(page, activityLink);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(ActivityLink activityLink) {
        if (activityLink.getIsNewRecord()) {
            activityLink.setOffice(activityLink.getCurrentUser().getOffice());
        }
        super.save(activityLink);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(ActivityLink activityLink) {
        super.delete(activityLink);
    }

    /**
     * 查询是否已经生成过该链接
     *
     * @param activityLink
     * @return
     */
    public ActivityLink getActivityLink(ActivityLink activityLink) {
        return activityLinkDao.getActivityLink(activityLink);
    }

    /**
     * 生成活动连接
     *
     * @param selectValue 活动id
     * @return
     */
    public Map<String, Object> produceUrl(String selectValue, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(selectValue)) {
            map.put("success", false);
        } else {
            //http://localhost:8080/a/activitylink/activityLink/produceUrl
            StringBuffer requestURL = request.getRequestURL();
            //http
            String scheme = request.getScheme();
            //localhost
            String serverName = request.getServerName();
            //8080
            int serverPort = request.getServerPort();
            //拼接手机活动的入口
            String url = scheme + "://" + serverName + ":" + serverPort + mobilePath + "/activity/activity/index?activityId=" + selectValue;
            System.out.println("-----------------------url = " + url);
            map.put("success", true);
            map.put("url", url);
        }
        return map;

    }

}