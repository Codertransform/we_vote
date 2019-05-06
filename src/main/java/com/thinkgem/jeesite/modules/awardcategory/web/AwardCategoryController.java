/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.awardcategory.web;

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
import com.thinkgem.jeesite.modules.awardcategory.entity.AwardCategory;
import com.thinkgem.jeesite.modules.awardcategory.service.AwardCategoryService;

/**
 * 奖品类别Controller
 *
 * @author hww
 * @version 2019-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/awardcategory/awardCategory")
public class AwardCategoryController extends BaseController {

    @Autowired
    private AwardCategoryService awardCategoryService;

    @ModelAttribute
    public AwardCategory get(@RequestParam(required = false) String id) {
        AwardCategory entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = awardCategoryService.get(id);
        }
        if (entity == null) {
            entity = new AwardCategory();
        }
        return entity;
    }

    @RequiresPermissions("awardcategory:awardCategory:view")
    @RequestMapping(value = {"list", ""})
    public String list(AwardCategory awardCategory, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<AwardCategory> page = awardCategoryService.findPage(new Page<AwardCategory>(request, response), awardCategory);
        model.addAttribute("page", page);
        return "modules/awardcategory/awardCategoryList";
    }

    @RequiresPermissions("awardcategory:awardCategory:view")
    @RequestMapping(value = "form")
    public String form(AwardCategory awardCategory, Model model) {
        model.addAttribute("awardCategory", awardCategory);
        return "modules/awardcategory/awardCategoryForm";
    }

    @RequiresPermissions("awardcategory:awardCategory:edit")
    @RequestMapping(value = "save")
    public String save(AwardCategory awardCategory, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, awardCategory)) {
            return form(awardCategory, model);
        }
        awardCategoryService.save(awardCategory);
        addMessage(redirectAttributes, "保存奖品类别成功");
        return "redirect:" + Global.getAdminPath() + "/awardcategory/awardCategory/?repage";
    }

    @RequiresPermissions("awardcategory:awardCategory:edit")
    @RequestMapping(value = "delete")
    public String delete(AwardCategory awardCategory, RedirectAttributes redirectAttributes) {
        awardCategoryService.delete(awardCategory);
        addMessage(redirectAttributes, "删除奖品类别成功");
        return "redirect:" + Global.getAdminPath() + "/awardcategory/awardCategory/?repage";
    }

}