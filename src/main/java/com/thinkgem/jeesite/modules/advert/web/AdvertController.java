package com.thinkgem.jeesite.modules.advert.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.common.constant.WeTou;
import com.thinkgem.jeesite.modules.advertcategory.entity.AdvertCategory;
import com.thinkgem.jeesite.modules.advertcategory.service.AdvertCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.advert.entity.Advert;
import com.thinkgem.jeesite.modules.advert.service.AdvertService;

/**
 * 学校广告Controller
 *
 * @author hww
 * @version 2019-03-18
 */
@Controller
@RequestMapping(value = "${adminPath}/advert/advert")
public class AdvertController extends BaseController {

    @Autowired
    private AdvertService advertService;
    @Autowired
    private AdvertCategoryService advertCategoryService;

    @ModelAttribute
    public Advert get(@RequestParam(required = false) String id) {
        Advert entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = advertService.get(id);
        }
        if (entity == null) {
            entity = new Advert();
        }
        return entity;
    }

    @RequiresPermissions("advert:advert:view")
    @RequestMapping(value = {"list", ""})
    public String list(Advert advert, HttpServletRequest request, HttpServletResponse response, Model model) {
        advert.setOffice(advert.getCurrentUser().getOffice());
        AdvertCategory advertCategory = new AdvertCategory();
        advertCategory.setOffice(advert.getCurrentUser().getOffice());
        //查询某个学校的广告类别
        model.addAttribute("advertCategoryList", advertCategoryService.findList(advertCategory));
        Page<Advert> page = advertService.findPage(new Page<Advert>(request, response), advert);
        model.addAttribute("page", page);
        return "modules/advert/advertList";
    }

    @RequiresPermissions("advert:advert:view")
    @RequestMapping(value = "form")
    public String form(Advert advert, Model model) {
        AdvertCategory advertCategory = new AdvertCategory();
        advertCategory.setOffice(advert.getCurrentUser().getOffice());
        //查询某个学校的广告类别
        model.addAttribute("advertCategoryList", advertCategoryService.findList(advertCategory));
        model.addAttribute("advert", advert);
        return "modules/advert/advertForm";
    }

    @RequiresPermissions("advert:advert:edit")
    @RequestMapping(value = "save")
    public String save(Advert advert, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, advert)) {
            return form(advert, model);
        }

        advertService.save(advert);
        addMessage(redirectAttributes, "保存广告成功");
        return "redirect:" + Global.getAdminPath() + "/advert/advert/?repage";
    }

    @RequiresPermissions("advert:advert:edit")
    @RequestMapping(value = "delete")
    public String delete(Advert advert, RedirectAttributes redirectAttributes) {
        advertService.delete(advert);
        addMessage(redirectAttributes, "删除广告成功");
        return "redirect:" + Global.getAdminPath() + "/advert/advert/?repage";
    }

    @RequiresPermissions("advert:advert:edit")
    @RequestMapping(value = "onLine")
    public String onLine(Advert advert, RedirectAttributes redirectAttributes) {
        boolean flag = advertService.onLine(advert);
        if (flag) {
            addMessage(redirectAttributes, "上线成功");
        } else {
            addMessage(redirectAttributes, "最大上线数只能为三个");
        }
        return "redirect:" + Global.getAdminPath() + "/advert/advert/?repage";
    }

    @RequiresPermissions("advert:advert:edit")
    @RequestMapping(value = "offLine")
    public String offLine(Advert advert, RedirectAttributes redirectAttributes) {

        advertService.offLine(advert);
        addMessage(redirectAttributes, "下线成功");
        return "redirect:" + Global.getAdminPath() + "/advert/advert/?repage";
    }

}