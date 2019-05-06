package com.thinkgem.jeesite.modules.production.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.activity.entity.Activity;
import com.thinkgem.jeesite.modules.activity.service.ActivityService;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.service.OfficeService;
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
import com.thinkgem.jeesite.modules.production.entity.Production;
import com.thinkgem.jeesite.modules.production.service.ProductionService;

import java.util.List;

/**
 * 作品Controller
 * @author hww
 * @version 2019-05-04
 */
@Controller
@RequestMapping(value = "${adminPath}/production/production")
public class ProductionController extends BaseController {

	@Autowired
	private ProductionService productionService;
	@Autowired
	private OfficeService officeService;
	@Autowired
    private ActivityService activityService;

	@ModelAttribute
	public Production get(@RequestParam(required=false) String id) {
		Production entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = productionService.get(id);
		}
		if (entity == null){
			entity = new Production();
		}
		return entity;
	}

	@RequestMapping(value = {"list", ""})
	public String list(Production production, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Office> officeList = officeService.findAll();
        List<Activity> activityList = activityService.findActivityList(new Activity());
        Page<Production> page = productionService.findPage(new Page<Production>(request, response), production);
		model.addAttribute("page", page);
		model.addAttribute("officeList", officeList);
        model.addAttribute("activityList", activityList);
		return "modules/production/productionList";
	}

	@RequestMapping(value = "form")
	public String form(Production production, Model model) {
		model.addAttribute("production", production);
		return "modules/production/productionForm";
	}

	@RequestMapping(value = "save")
	public String save(Production production, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, production)){
			return form(production, model);
		}
		productionService.save(production);
		addMessage(redirectAttributes, "保存作品成功");
		return "redirect:"+Global.getAdminPath()+"/production/production/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Production production, RedirectAttributes redirectAttributes) {
		productionService.delete(production);
		addMessage(redirectAttributes, "删除作品成功");
		return "redirect:"+Global.getAdminPath()+"/production/production/?repage";
	}

}