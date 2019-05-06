package com.thinkgem.jeesite.modules.git.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.gitcategory.entity.GitCategory;
import com.thinkgem.jeesite.modules.gitcategory.service.GitCategoryService;
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
import com.thinkgem.jeesite.modules.git.entity.Git;
import com.thinkgem.jeesite.modules.git.service.GitService;

/**
 * 礼物Controller
 *
 * @author hww
 * @version 2019-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/git/git")
public class GitController extends BaseController {

	@Autowired
	private GitService gitService;
	@Autowired
	private GitCategoryService gitCategoryService;

	@ModelAttribute
	public Git get(@RequestParam(required = false) String id) {
		Git entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = gitService.get(id);
		}
		if (entity == null) {
			entity = new Git();
		}
		return entity;
	}

	@RequiresPermissions("git:git:view")
	@RequestMapping(value = {"list", ""})
	public String list(Git git, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("-----------------------git = " + git);
		Page<Git> page = gitService.findPage(new Page<Git>(request, response), git);
		model.addAttribute("page", page);
		model.addAttribute("gitCategoryList", gitCategoryService.findList(new GitCategory()));
		return "modules/git/gitList";
	}

	@RequiresPermissions("git:git:view")
	@RequestMapping(value = "form")
	public String form(Git git, Model model) {
		model.addAttribute("git", git);
		model.addAttribute("gitCategoryList", gitCategoryService.findList(new GitCategory()));
		return "modules/git/gitForm";
	}

	@RequiresPermissions("git:git:edit")
	@RequestMapping(value = "save")
	public String save(Git git, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, git)) {
			return form(git, model);
		}
		gitService.save(git);
		addMessage(redirectAttributes, "保存礼物成功");
		return "redirect:" + Global.getAdminPath() + "/git/git/?repage";
	}

	@RequiresPermissions("git:git:edit")
	@RequestMapping(value = "delete")
	public String delete(Git git, RedirectAttributes redirectAttributes) {
		gitService.delete(git);
		addMessage(redirectAttributes, "删除礼物成功");
		return "redirect:" + Global.getAdminPath() + "/git/git/?repage";
	}

}