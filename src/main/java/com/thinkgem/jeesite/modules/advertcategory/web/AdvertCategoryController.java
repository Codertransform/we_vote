package com.thinkgem.jeesite.modules.advertcategory.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.thinkgem.jeesite.modules.advertcategory.entity.AdvertCategory;
import com.thinkgem.jeesite.modules.advertcategory.service.AdvertCategoryService;

/**
 * 广告类别Controller
 *
 * @author hww
 * @version 2019-03-20
 */
@Controller
@RequestMapping(value = "${adminPath}/advertcategory/advertCategory")
public class AdvertCategoryController extends BaseController {

    @Autowired
    private AdvertCategoryService advertCategoryService;

    @ModelAttribute
    public AdvertCategory get(@RequestParam(required = false) String id) {
        AdvertCategory entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = advertCategoryService.get(id);
        }
        if (entity == null) {
            entity = new AdvertCategory();
        }
        return entity;
    }

    @RequiresPermissions("advertcategory:advertCategory:view")
    @RequestMapping(value = {"list", ""})
    public String list(AdvertCategory advertCategory, HttpServletRequest request, HttpServletResponse response, Model model) {
        advertCategory.setOffice(advertCategory.getCurrentUser().getOffice());
        Page<AdvertCategory> page = advertCategoryService.findPage(new Page<AdvertCategory>(request, response), advertCategory);
        model.addAttribute("page", page);
        return "modules/advertcategory/advertCategoryList";
    }

    @RequiresPermissions("advertcategory:advertCategory:view")
    @RequestMapping(value = "form")
    public String form(AdvertCategory advertCategory, Model model) {
        model.addAttribute("advertCategory", advertCategory);
        return "modules/advertcategory/advertCategoryForm";
    }

    @RequiresPermissions("advertcategory:advertCategory:edit")
    @RequestMapping(value = "save")
    public String save(AdvertCategory advertCategory, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, advertCategory)) {
            return form(advertCategory, model);
        }
        advertCategoryService.save(advertCategory);
        addMessage(redirectAttributes, "保存广告类别成功");
        return "redirect:" + Global.getAdminPath() + "/advertcategory/advertCategory/?repage";
    }

    @RequiresPermissions("advertcategory:advertCategory:edit")
    @RequestMapping(value = "delete")
    public String delete(AdvertCategory advertCategory, RedirectAttributes redirectAttributes) {
        advertCategoryService.delete(advertCategory);
        addMessage(redirectAttributes, "删除广告类别成功");
        return "redirect:" + Global.getAdminPath() + "/advertcategory/advertCategory/?repage";
    }

}