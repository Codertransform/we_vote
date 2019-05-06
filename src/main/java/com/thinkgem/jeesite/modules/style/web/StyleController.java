package com.thinkgem.jeesite.modules.style.web;

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
import com.thinkgem.jeesite.modules.style.entity.Style;
import com.thinkgem.jeesite.modules.style.service.StyleService;

/**
 * 模板Controller
 *
 * @author hww
 * @version 2019-03-24
 */
@Controller
@RequestMapping(value = "${adminPath}/style/style")
public class StyleController extends BaseController {

    @Autowired
    private StyleService styleService;

    @ModelAttribute
    public Style get(@RequestParam(required = false) String id) {
        Style entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = styleService.get(id);
        }
        if (entity == null) {
            entity = new Style();
        }
        return entity;
    }

    @RequiresPermissions("style:style:view")
    @RequestMapping(value = {"list", ""})
    public String list(Style style, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Style> page = styleService.findPage(new Page<Style>(request, response), style);
        model.addAttribute("page", page);
        return "modules/style/styleList";
    }

    @RequiresPermissions("style:style:view")
    @RequestMapping(value = "form")
    public String form(Style style, Model model) {
        model.addAttribute("style", style);
        return "modules/style/styleForm";
    }

    @RequiresPermissions("style:style:edit")
    @RequestMapping(value = "save")
    public String save(Style style, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, style)) {
            return form(style, model);
        }
        styleService.save(style);
        addMessage(redirectAttributes, "保存模板成功");
        return "redirect:" + Global.getAdminPath() + "/style/style/?repage";
    }

    @RequiresPermissions("style:style:edit")
    @RequestMapping(value = "delete")
    public String delete(Style style, RedirectAttributes redirectAttributes) {
        styleService.delete(style);
        addMessage(redirectAttributes, "删除模板成功");
        return "redirect:" + Global.getAdminPath() + "/style/style/?repage";
    }

}