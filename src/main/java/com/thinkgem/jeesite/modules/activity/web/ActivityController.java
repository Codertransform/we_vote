package com.thinkgem.jeesite.modules.activity.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.advertcategory.entity.AdvertCategory;
import com.thinkgem.jeesite.modules.advertcategory.service.AdvertCategoryService;
import com.thinkgem.jeesite.modules.awardcategory.entity.AwardCategory;
import com.thinkgem.jeesite.modules.awardcategory.service.AwardCategoryService;
import com.thinkgem.jeesite.modules.gitcategory.entity.GitCategory;
import com.thinkgem.jeesite.modules.gitcategory.service.GitCategoryService;
import com.thinkgem.jeesite.modules.style.entity.Style;
import com.thinkgem.jeesite.modules.style.service.StyleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.activity.entity.Activity;
import com.thinkgem.jeesite.modules.activity.service.ActivityService;

import java.util.Date;

/**
 * 活动Controller
 *
 * @author hww
 * @version 2019-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/activity/activity")
public class ActivityController extends BaseController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private GitCategoryService gitCategoryService;
    @Autowired
    private AwardCategoryService awardCategoryService;
    @Autowired
    private AdvertCategoryService advertCategoryService;
    @Autowired
    private StyleService styleService;

    @ModelAttribute
    public Activity get(@RequestParam(required = false) String id) {
        Activity entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = activityService.get(id);
        }
        if (entity == null) {
            entity = new Activity();
        }
        return entity;
    }

    @RequiresPermissions("activity:activity:view")
    @RequestMapping(value = {"list", ""})
    public String list(Activity activity, HttpServletRequest request, HttpServletResponse response, Model model) {
        //根据学校查询某学校举办的活动
        activity.setOffice(activity.getCurrentUser().getOffice());
        Page<Activity> page = activityService.findPage(new Page<Activity>(request, response), activity);
        model.addAttribute("gitCategorys", gitCategoryService.findList(new GitCategory()));
        model.addAttribute("awardCategorys", awardCategoryService.findList(new AwardCategory()));
        //查询当前学校的广告类别
        AdvertCategory advertCategory = new AdvertCategory();
        advertCategory.setOffice(activity.getCurrentUser().getOffice());
        model.addAttribute("advertCategoryList", advertCategoryService.findList(advertCategory));
        model.addAttribute("styleList", styleService.findList(new Style()));
        model.addAttribute("page", page);
        return "modules/activity/activityList";
    }

    @RequiresPermissions("activity:activity:view")
    @RequestMapping(value = "form")
    public String form(Activity activity, Model model, String message) {
        model.addAttribute("gitCategorys", gitCategoryService.findList(new GitCategory()));
        model.addAttribute("awardCategorys", awardCategoryService.findList(new AwardCategory()));
        //查询当前学校的广告类别
        AdvertCategory advertCategory = new AdvertCategory();
        advertCategory.setOffice(activity.getCurrentUser().getOffice());
        model.addAttribute("advertCategoryList", advertCategoryService.findList(advertCategory));
        model.addAttribute("activity", activity);
        model.addAttribute("styleList", styleService.findList(new Style()));
        model.addAttribute("errorMessage", message);
        return "modules/activity/activityForm";
    }

    @RequiresPermissions("activity:activity:edit")
    @RequestMapping(value = "save")
    public String save(Activity activity, Model model, RedirectAttributes redirectAttributes) {

        if (activity.getEndTime().before(new Date())) {
            String message = "结束时间已过期,请合理填写时间";
            return form(activity, model, message);
        }
        if (activity.getEndTime().before(activity.getStartTime())) {
            String message = "结束时间不能小于开始时间,请合理填写时间";
            return form(activity, model, message);
        }
        if (!beanValidator(model, activity)) {
            return form(activity, model, null);
        }
        activityService.save(activity);
        addMessage(redirectAttributes, "保存活动成功");
        return "redirect:" + Global.getAdminPath() + "/activity/activity/?repage";
    }

    @RequiresPermissions("activity:activity:edit")
    @RequestMapping(value = "delete")
    public String delete(Activity activity, RedirectAttributes redirectAttributes) {
        activityService.delete(activity);
        addMessage(redirectAttributes, "删除活动成功");
        return "redirect:" + Global.getAdminPath() + "/activity/activity/?repage";
    }


}