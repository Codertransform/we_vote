package com.thinkgem.jeesite.modules.activity.web;

import com.thinkgem.jeesite.common.constant.WeTou;
import com.thinkgem.jeesite.modules.activity.entity.Activity;
import com.thinkgem.jeesite.modules.activity.service.ActivityService;
import com.thinkgem.jeesite.modules.advert.entity.Advert;
import com.thinkgem.jeesite.modules.advert.service.AdvertService;
import com.thinkgem.jeesite.modules.advertcategory.entity.AdvertCategory;
import com.thinkgem.jeesite.modules.production.entity.Production;
import com.thinkgem.jeesite.modules.production.service.ProductionService;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 手机访问Controller
 *
 * @Author: hww
 * @Date: 2019/3/24 13:33
 */
@Controller
@RequestMapping(value = "${mobilePath}/activity/activity")
public class MobileActivityController {


    @Autowired
    private ActivityService activityService;

    @Autowired
    private AdvertService advertService;
    @Autowired
    private ProductionService productionService;

    @RequestMapping(value = "index")
    public String activityIndex(String activityId, Model model) {
        System.out.println("activityId = " + activityId);
        //得到活动
        Activity activity = activityService.get(activityId);
        //得到机构
        Office office = activity.getOffice();
        //查询广告
        AdvertCategory advertCategory = activity.getAdvertCategory();
        Advert advert = new Advert();
        advert.setOffice(office);
        advert.setAdvertCategory(advertCategory);
        advert.setStatus(WeTou.ONlINE);
        List<Advert> advertList = advertService.findList(advert);
        if (advertList.size() > 0) {
            Advert advert1 = advertList.get(0);
            Advert advert2 = advertList.get(1);
            Advert advert3 = advertList.get(2);
            if (advert1 != null) {

                model.addAttribute("advert1", advert1);

            }
            if (advert2 != null) {

                model.addAttribute("advert2", advert2);

            }
            if (advert3 != null) {

                model.addAttribute("advert3", advert3);

            }
        }
        //查询作品
        List<Production> productions = productionService.fingAllProductions(activityId);
        model.addAttribute("productions", productions);
        model.addAttribute("activity", activity);
        return "modules/mobile/activityIndex";
    }


}
