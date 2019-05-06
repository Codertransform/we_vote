package com.thinkgem.jeesite.modules.award.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.awardcategory.entity.AwardCategory;
import com.thinkgem.jeesite.modules.awardcategory.service.AwardCategoryService;
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
import com.thinkgem.jeesite.modules.award.entity.Award;
import com.thinkgem.jeesite.modules.award.service.AwardService;

/**
 * 奖品Controller
 *
 * @author hww
 * @version 2019-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/award/award")
public class AwardController extends BaseController {

    @Autowired
    private AwardService awardService;
    @Autowired
    private AwardCategoryService categoryService;

    @ModelAttribute
    public Award get(@RequestParam(required = false) String id) {
        Award entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = awardService.get(id);
        }
        if (entity == null) {
            entity = new Award();
        }
        return entity;
    }

    @RequiresPermissions("award:award:view")
    @RequestMapping(value = {"list", ""})
    public String list(Award award, HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("awardCategoryList", categoryService.findList(new AwardCategory()));
        Page<Award> page = awardService.findPage(new Page<Award>(request, response), award);
        model.addAttribute("page", page);
        return "modules/award/awardList";
    }

    @RequiresPermissions("award:award:view")
    @RequestMapping(value = "form")
    public String form(Award award, Model model) {
        model.addAttribute("awardCategoryList", categoryService.findList(new AwardCategory()));
        model.addAttribute("award", award);
        return "modules/award/awardForm";
    }

    @RequiresPermissions("award:award:edit")
    @RequestMapping(value = "save")
    public String save(Award award, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, award)) {
            return form(award, model);
        }
        awardService.save(award);
        addMessage(redirectAttributes, "保存奖品成功");
        return "redirect:" + Global.getAdminPath() + "/award/award/?repage";
    }

    @RequiresPermissions("award:award:edit")
    @RequestMapping(value = "delete")
    public String delete(Award award, RedirectAttributes redirectAttributes) {
        awardService.delete(award);
        addMessage(redirectAttributes, "删除奖品成功");
        return "redirect:" + Global.getAdminPath() + "/award/award/?repage";
    }

}