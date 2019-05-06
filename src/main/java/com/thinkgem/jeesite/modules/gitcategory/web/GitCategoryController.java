package com.thinkgem.jeesite.modules.gitcategory.web;

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
import com.thinkgem.jeesite.modules.gitcategory.entity.GitCategory;
import com.thinkgem.jeesite.modules.gitcategory.service.GitCategoryService;

/**
 * 礼物类别Controller
 *
 * @author hww
 * @version 2019-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/gitcategory/gitCategory")
public class GitCategoryController extends BaseController {

    @Autowired
    private GitCategoryService gitCategoryService;

    @ModelAttribute
    public GitCategory get(@RequestParam(required = false) String id) {
        GitCategory entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = gitCategoryService.get(id);
        }
        if (entity == null) {
            entity = new GitCategory();
        }
        return entity;
    }

    @RequiresPermissions("gitcategory:gitCategory:view")
    @RequestMapping(value = {"list", ""})
    public String list(GitCategory gitCategory, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<GitCategory> page = gitCategoryService.findPage(new Page<GitCategory>(request, response), gitCategory);
        model.addAttribute("page", page);
        return "modules/gitcategory/gitCategoryList";
    }

    @RequiresPermissions("gitcategory:gitCategory:view")
    @RequestMapping(value = "form")
    public String form(GitCategory gitCategory, Model model) {
        model.addAttribute("gitCategory", gitCategory);
        return "modules/gitcategory/gitCategoryForm";
    }

    @RequiresPermissions("gitcategory:gitCategory:edit")
    @RequestMapping(value = "save")
    public String save(GitCategory gitCategory, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, gitCategory)) {
            return form(gitCategory, model);
        }
        gitCategoryService.save(gitCategory);
        addMessage(redirectAttributes, "保存礼物类别成功");
        return "redirect:" + Global.getAdminPath() + "/gitcategory/gitCategory/?repage";
    }

    @RequiresPermissions("gitcategory:gitCategory:edit")
    @RequestMapping(value = "delete")
    public String delete(GitCategory gitCategory, RedirectAttributes redirectAttributes) {
        gitCategoryService.delete(gitCategory);
        addMessage(redirectAttributes, "删除礼物类别成功");
        return "redirect:" + Global.getAdminPath() + "/gitcategory/gitCategory/?repage";
    }

}